package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.soap.WaitPolicy;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import mvn.tgBot.utils.Regions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: Проверка данных
 */
@Component
public class S1_25 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;

@Autowired
    WaitPolicy waitPolicy;

    private Log log = LogFactory.getLog(S1_25.class);

    private String nextStageVar="";
    public S1_25() {
        name = "s1-25";
        nextStageName = "s1-27";
        msg = "Давайте проверим:\n" +
                "Тип полиса: %s,\n" +
                "Территория страхования: %s,\n" +
                "Даты поездки: %s - %s\n" +
                "Продолжительность, дней: %d\n" +
                "Страхователь: «%s», «%s», %s %s», %s %s \n" +
                "Застрахованные:\n" +
                "%s\n" +
                "Страховое покрытие 30 000 EUR\n"+
        "Пожалуйста, ожидайте сообщения о создании полиса и ссылки на оплату.\n" +
                "Если что то пойдет не так, введите /refresh";
        descr="проверка";
    }
    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.contains("ПРАВ") ) {
            nextStageVar="s1-26";                     // !!!!!!
        }
        else if(txt.contains("ОШИБ") ) {
            user.setCorrectMode(true);
            nextStageVar="s1-3";                     // !!!!!!
            user.setWait4Stage(nextStageVar);
        }
        else {
                log.error("stage:"+name+" ошибка ввода:"+txt);
                tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - ошибка в команде");
        }

        StageInt next = stageList.getStage(nextStageVar);
        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        user.setWait4Stage(nextStageVar);     // запомнить след шаг для данного ChatID
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r)  {
        Long chatId = user.getChatId();
// ------ формирование документа
        Long diff = null;
        try {
            diff = checkDates.diffDays(user.getDateFrom(),user.getDateTo());
        } catch (ParseException e) {
            diff =0L;
        }
        StringBuffer userList = new StringBuffer();
        HashMap<String,EnsuredType> es = user.getEnsured();
        for(String key : es.keySet()) {
            EnsuredType us = es.get(key);
            log.trace("Add user:" +key+" > "+us.getLastName()+", " + us.getFirstName()+", "+us.getBirthday()+", "+us.getPasport() );
            userList.append(us.getLastName()+", " + us.getFirstName()+", "+us.getBirthday()+", "+us.getPasport()+"\n");
        }
        String outMessage = String.format(msg,
                "разовый", //  user.getPolicyType(),
                Regions.get (user.getRegionType()),
                user.getDateFrom(), user.getDateTo(),diff,
                user.getUserName(),
                user.getBirthday(),user.getPhone(),user.getEmail(), user.getAddress1(), user.getAddress2(),
                userList.toString());

        tgbot.sendMenuOff(chatId,outMessage);

        log.debug("wait soap response ...");
        try {
            Future<String> ans = waitPolicy.getAnsw(tgbot, user);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            tgbot.sendMistake(chatId,"ошибка при создании запроса");
        }
    }

}

