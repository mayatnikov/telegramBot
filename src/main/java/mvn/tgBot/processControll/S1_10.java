package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Age;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: Ввод числа взрослых  если Шенген или Финнл-я
 */
@Component
public class S1_10 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;

    private Log log = LogFactory.getLog(S1_10.class);

    public S1_10() {
        name = "s1-10";
        nextStageName = "s1-12";
        msg="Срок страхования с %s по %s. Количество дней поездки %s дней.\n" +
                "Обращаю внимание, что срок действия полиса увеличен на 15 дней в соответствии с Визовым Кодексом стран Шенгенской зоны. " +
                "Стоимость полиса не увеличится! Продолжаем.\n" +
                "Сколько человек "+ Age.get[0]+" от 12 до 60 лет едет?";
        descr="число взрослых Шенген";
    }

    String[][] menu = {
            {"1","2","3","4","5"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String input = regexp.filterDigital(txt);
        int nu = Integer.parseInt(input);
        if(nu>=0 && nu<6 ) {
            user.setEnsuredNumber(Integer.parseInt(input));                      // !!!!!!
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setEnsured(null);  // сброс списка участников
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        String err = "err s1-18. Что то пошло не так!";
        Long chatId = user.getChatId();
        Long diff = null;
        String outMessage;
//        try {
 //           diff = checkDates.diffDays(user.getDateFrom(),user.getDateTo());
            outMessage = String.format(msg,user.getDateFrom(),user.getDatePolicyEnd(),user.getDateDuration());
//        } catch (ParseException e) {
//            outMessage = err;
//        } catch (java.util.IllegalFormatConversionException e) {
//            outMessage = err;
//        }
//        outMessage = String.format(msg,user.getDateFrom(),user.getDateTo(),""+(diff+15L));
 //       tg.sendMenuOff(chatId,outMessage);
        tgbot.sendMenuON(chatId,outMessage,menu);
    }
}

