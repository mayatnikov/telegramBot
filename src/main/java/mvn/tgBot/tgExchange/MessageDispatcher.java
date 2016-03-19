package mvn.tgBot.tgExchange;

import mvn.tgBot.db.User;
import mvn.tgBot.db.UserRepository;
import mvn.tgBot.processControll.*;
import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.tgObjects.Updates;
import mvn.tgBot.utils.CheckNewUser;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageDispatcher  implements CommandLineRunner {

    private Log log = LogFactory.getLog(MessageDispatcher.class);

//   @Autowired CheckDB checkDB;
//    @Autowired CheckTelegram checkTelegram;


    @Autowired StageList stageList;
    @Autowired
    Messenger tgbot;

    @Autowired Regexp regexp;
    @Autowired UserRepository db;
    @Autowired CheckNewUser checkNewUser;

    @Autowired
    ContactProcessor contactProcessor;
    @Autowired
    PhotoProcessor photoProcessor;
    @Autowired
    LocationProcessor locationProcessor;


    Long currentUpdateId;

    @Value("${configName}")
    String configName;   // проверка от куда взяли конфиг


    // пока не работает !!!
    @Value("${tg.cron}")
    String tgCron;

    @Override
    public void run(String ... args) throws Exception {
//        checkDB.run(args);
//        checkTelegram.run(args);
// checkTinkoff();
        String current = new java.io.File( "." ).getCanonicalPath();
        log.info(">>> PWD:"+current+" CRON:"+tgCron+" <<<<");
        log.info(">>>>>>>>>>>>>CONFIG NAME>>>>>>>>>>>>>"+configName+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        currentUpdateId = new Long(0L);
        log.info("Start pooling ...");
    }

    //  sec min hour day-of-month month day-of-week MON-SUN
//    @Scheduled(cron = "*/3 * * * * *")
    @Scheduled(cron = "${tg.cron}")
    public void pooling() {
        // get all message
        ResponseEntity<Updates> resp = tgbot.getAllMessage(currentUpdateId);
        Updates updates = resp.getBody();
        List<Result> results = new ArrayList();
        Long chatID=0L;
        try {
            results = updates.getResult();      // список сообщений от абонетов
            if(results.size()>0) log.debug("Incoming message-packet size=" + results.size() + " start from update_id=" + currentUpdateId);
            for (Result r : results) {
//  -------------- !!!!!!!!!!!!!!ВАЖНО
                 currentUpdateId = r.getUpdate_id();                // сохранить текущще значение update_id
// --------------- !!!!!!!!!!!!!!!
                log.trace("Update current message id=" + currentUpdateId);

                chatID = r.getMessage().getFrom().getId();
                User user = checkNewUser.proc(chatID, r);

// ========================   обработка не текстовых сообщений
                if(r.getMessage().getContact()!=null) { contactProcessor.sendMessage(user,r); continue;}
                if(r.getMessage().getPhoto()!=null) { photoProcessor.process(user,r);  continue; }
                if(r.getMessage().getLocation()!=null) { locationProcessor.sendMessage(user,r); continue; }

// ==================== проверка текстовых сообщений
                String msg = r.getMessage().getText().toUpperCase();
                log.debug("Message chatId:[" + r.getMessage().getChat().getId() + "]from:[" + r.getMessage().getFrom().getUsername()+" /isNew="+ user.isNewUser() + "] text=" + msg);
                if (r.getMessage().getText() == null) continue; // пустое сообщение
// ============ CANCEL ============
                else if(msg.startsWith("CANCEL") || msg.startsWith("/CANCEL") ) {
                    log.debug("clear stage for:"+user.getFirstName());
                    clearStage4ThisUser(user,r);
                }
// ======================================= for debug ONLY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  /SPERSET: STAGE 1 16
                else if(msg.startsWith("/SUPERSET:")  ) {
                    log.debug("SUPERSET from:"+user.getFirstName());
                    String command = r.getMessage().getText().toUpperCase();
                    String par[] = regexp.filterUserData(command);
                    if(par[1].equals("STAGE")) {
                        user.setWait4Stage("s"+par[2]+"-"+par[3]);
                        db.save(user);
                        tgbot.sendText(user.getChatId(),"следующая команда /refresh восстановит стадию:s"+par[2]+"-"+par[3]);
                    }
                }
// =========================================================

                else if(msg.startsWith("RETRY") || msg.startsWith("/RETRY") ) { // в режиме коррекции ошибок
                    String nextStage="s1-4c";
                    user.setWait4Stage(nextStage);
                    user.setEnsuredCurrentKey(null);
                    user.setCorrectMode(true);
                    db.save(user);
                    StageInt ws = stageList.getStage(nextStage);
                    ws.sendMessage(user,r);
                }
// =========================================================
                else if(msg.startsWith("START") || msg.startsWith("/START") ) { // в режиме коррекции ошибок
                    String nextStage="s1-1";
                    user.setWait4Stage(nextStage);
                    user.setCorrectMode(false);
                    user.setEnsuranceOpt1(null);
                    user.setEnsuranceOpt2(null);
                    user.setEnsuranceOpt3(null);
                    user.setEnsuranceOpt4(null);
                    user.setEnsuredCurrentKey(null);
                    user.setEnsured(null);
                    db.save(user);
                    StageInt ws = stageList.getStage(nextStage);
                    ws.sendMessage(user,r);
                }


                else if(msg.startsWith("HELP") || msg.startsWith("/HELP") ) {
                    log.debug("disolay help");
                    displayHelp(chatID);
                }
                else if(msg.startsWith("REFRESH") || msg.startsWith("/REFRESH") ) {
                    String wait4Stage = user.getWait4Stage();
                    if(wait4Stage!=null) {
                        StageInt ws = stageList.getStage(wait4Stage);
                        ws.sendMessage(user,r);
                    }
                }

                else if(msg.startsWith("INFO") || msg.startsWith("/INFO") ) {
                    log.debug("display user data");
                    displayUserData(chatID,user);
                }
                else if(msg.equals("?") || msg.equals("/?") ) {
                    log.debug("display short help");
                    displayQuest(chatID);
                }
                else { // вызвать процесс обработки следующей стадии для пользователя
                    String currStageName = user.getWait4Stage();
                    if(currStageName==null || currStageName.equals("")|| currStageName.equals("?") ) currStageName="s1-0";
                    log.debug("Restore stage:"+currStageName+" for user:"+user.getUserName());
                    StageInt currStage = stageList.getStage(currStageName);
                    if(currStage!=null)  { log.debug("goto stage:"+currStage); currStage.process(user,r); }
                    else log.error("Stage:"+currStageName+"-not found!");
                }
            }  // end of for each results
        }  catch (StageNotFoundException e) {
            log.error("error in stage sequence, stage not found. Process is break");
            tgbot.sendMistake(chatID,"Ошибка в сценарии робота");
            e.printStackTrace();
        }  catch (java.lang.NullPointerException e) {
            tgbot.sendMistake(chatID,"Ошибка в данных (null pointer ex-n)");
            log.error("Processed message with update_id=" + currentUpdateId + " ===> SKIPPED ! error:" + e.getMessage());
        }  catch (org.springframework.web.client.HttpClientErrorException e) {
            log.error("Bad request to TELEGRAM update_id=" + currentUpdateId + " ===> SKIPPED ! error:" + e.getMessage());
        }  catch (java.lang.ArrayIndexOutOfBoundsException e) {
            log.error("Bad array index. update_id=" + currentUpdateId + " ===> SKIPPED ! error:" + e.getMessage());
        }  catch (org.springframework.web.client.HttpServerErrorException e) {
            log.error("Http error!!!!!. update_id=" + currentUpdateId + " ===> SKIPPED ! error:" + e.getMessage());
        } catch (java.lang.NumberFormatException e) {
            tgbot.sendMistake(chatID,"ошибка при вводе числа");
            log.error("Number format error update_id=" + currentUpdateId + " ===> SKIPPED ! input date/number error:" + e.getMessage());
        } catch (java.time.DateTimeException e) {
            tgbot.sendMistake(chatID,"Некорректная дата");
            log.error("Date time format error. update_id=" + currentUpdateId + " ===> SKIPPED ! input date error:" + e.getMessage());
        }


//       пометить сообщения как обработанные
        if (results != null && results.size() != 0) currentUpdateId++;

    }

    private void displayUserData(Long chatID, User user) {
        StringBuffer sb = new StringBuffer();
        sb.append("\nChat ID:" +  user.getChatId() );
        sb.append("\n Is new User:" +  user.isNewUser());
        sb.append("\nFirst Name:" +  user.getFirstName() );
        sb.append("\n Second name:" +  user.getSecondName() );
        sb.append("\nLast name:" +  user.getLastName() );
        sb.append("\nUser name:" +  user.getUserName() );
        sb.append("\n Current state:" +  user.getWait4Stage() );
        sb.append("\nPhone:" +  user.getPhone() );
        sb.append("\nE-Mail:" +  user.getEmail() );
        sb.append("\nBirthday:" +  user.getBirthday() );
        sb.append("\nAddr-1:" +  user.getAddress1() );
        sb.append("\nAddr-2:" +  user.getAddress2() );
        sb.append("\nGender:" +  user.getSex() );

        tgbot.sendText(chatID,sb.toString());
    }

    // сбросить текущий статус пользователя
    private void clearStage4ThisUser(User user, Result r) {
//        tgbot.sendMenuOff(user.getChatId(),"Процесс сброшен");

        String nst = "s1-0";
        user.setWait4Stage(nst);
        user.setLastErr(false);
        user.setEnsuranceOpt1(null);
        user.setEnsuranceOpt2(null);
        user.setEnsuranceOpt3(null);
        user.setEnsuranceOpt4(null);
        user.setCorrectMode(false);   // режим коррекции данных - нет
        user.setEnsuredCurrentKey(null);
        user.setEnsured(null);

        try {
            StageInt next = null;
            next = stageList.getStage(nst);
            next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
        } catch (StageNotFoundException e) {
            log.error("сброс процесса переход не возможен");
        }

        db.save(user);
        log.debug("reset user history");
    }
    
    private void displayHelp(long chatId) {
        String txt="основные команды: " +
                "/start - начать полис заново, с потерей данных \n" +
                "/retry – к началу для уточнения данных \n" +
                "/refresh - повторить последний вопрос\n" +
                "/cancel - отменить оформление\n" +
                "/info - данные пользователя \n" +
                "/help - список команд бота\n";
        tgbot.sendText(chatId,txt);
    }

    private void displayQuest(long chatId) {
        String txt=
                "/start /retry /refresh /cancel /info /help";
        tgbot.sendText(chatId,txt);
    }

}

/*
команды для BOT-а:

start - начать полис заново, с потерей данных
retry - к началу для уточнения данных
refresh - повторить последний вопрос
cancel - отменить оформление
info - данные пользователя
help - список команд бота


 */

