package mvn.tgBot.processControll;

import mvn.tgBot.soap.TgCalcQuote;
import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toi.model.gw.quote.QuoteType;

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
    TgCalcQuote tgCalcQuote;

    private Log log = LogFactory.getLog(S1_25.class);

    private String nextStageVar="";
    public S1_25() {
        name = "s1-25";
        nextStageName = "s1-27";
        msg = "Давайте проверим:\n" +
                "«%s», «%s»,\n «%s - %s»,\n «на %d дней» \n" +
                "Страхователь: «%s», «%s»,\n «%s %s», \n«%s %s»\n" +
                "Застрахованные:\n" +
                "%s\n" +
                "Страховое покрытие 30 000 EUR\n"+
        "если что то пойдет не так, можно выдать команду /refresh \n ждем ответа сервера ....";
        descr="проверка";
    }
    String[][] menu = {
            {"все правильно"},
            {"есть ошибки"}
    };

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
        }
        else {
                log.error("stage:"+name+" ошибка ввода:"+txt);
                tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - ошибка в команде");
        }

        StageInt next = stageList.getStage(nextStageVar);
        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
        user.setWait4Stage(nextStageVar);     // запомнить след шаг для данного ChatID
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
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
            userList.append(us.getLastName()+", " + us.getFirstName()+", "+us.getBirthday()+", "+us.getPasport()+"\n");
        }
        String outMessage = String.format(msg,
                user.getPolicyType(),
                user.getRegionType(),
                user.getDateFrom(), user.getDateTo(),diff,
                user.getUserName(),
                user.getBirthday(),user.getPhone(),user.getEmail(), user.getAddress1(), user.getAddress2(),
                userList.toString());

        tgbot.sendMenuON(chatId,outMessage,menu);


        Future<QuoteType> quote = tgCalcQuote.getResponse(tgbot, user,user.getHolidayType(),true);
        log.debug("wait soap response ...");

//        while (!(quote.isDone())) {
//            try {
//                Thread.sleep(1000); //1 sec pause between each check
//                log.debug("wait ...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.debug("Wait...");
//        }
    }
}

/*
public class S1_25 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;
    @Autowired
    TgCalcQuote tgCalcQuote;

    private Log log = LogFactory.getLog(S1_25.class);

    private String nextStageVar="";
    public S1_25() {
        name = "s1-25";
        nextStageName = "s1-27";
        msg = "Давайте проверим:\n" +
                "«%s», «%s», «%s - %s», «на %d дней» \n" +
                "Страхователь: «%s», «%s», «%s %s», «%s %s»\n" +
                "Застрахованные:\n" +
                "%s\n" +
                "Страховое покрытие 30 000 EUR\n" +
                "Стоимость полиса ___ рублей\n" +
                "Оплачиваем?";
        descr="проверка";

}
        String[][] menu = {
        {"все правильно"},
        {"есть ошибки"}
        };

@Override
public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.contains("ПРАВ") ) {
        nextStageVar="s1-26";                     // !!!!!!
        }
        else if(txt.contains("ОШИБ") ) {
        user.setCorrectMode(true);
        nextStageVar="s1-2";                     // !!!!!!
        }
        else {
        log.error("stage:"+name+" ошибка ввода:"+txt);
        tg.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - ошибка в команде");
        }

        StageInt next = stageList.getStage(nextStageVar);
        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        //        rs.getStatusCode().getReasonPhrase();
        user.setWait4Stage(nextStageVar);     // запомнить след шаг для данного ChatID
        db.save(user);
        }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
@Override
public void sendMessage(User user, Result r) {
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
        userList.append(us.getLastName()+", " + us.getFirstName()+", "+us.getBirthday()+", "+us.getPasport()+"\n");
        }
        String outMessage = String.format(msg,
        user.getPolicyType(),
        user.getRegionType(),
        user.getDateFrom(), user.getDateTo(),diff,
        user.getUserName(),
        user.getBirthday(),user.getPhone(),user.getEmail(), user.getAddress1(), user.getAddress2(),
        userList.toString());

        menuControl.menuON(chatId,outMessage,menu);
// уходим на async обмен с шиной
        log.debug("start quote request");
        Future<QuoteType> quote = tgCalcQuote.getResponse(db,tg,menuControl, user);
//        Future<QuoteType> quote = tgCalcQuote.getResponse(null,null,null, user);
        log.debug("wait soap response ...");
        while (!(quote.isDone())) {
        try {
        Thread.sleep(1000); //1 sec pause between each check
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        log.debug("Wait...");
        }


        }
        }

 */