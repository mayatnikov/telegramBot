package mvn.tgBot.processControll;

import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.soap.TgCalc3Quotas;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import mvn.tgBot.utils.Regions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: выбор типа отдыха
 */
@Component
public class S1_14 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    @Autowired
    TgCalc3Quotas tgCalc3Quotas;

    private Log log = LogFactory.getLog(S1_14.class);

    public S1_14() {
        name = "s1-14";
        nextStageName = "s1-14a";
        msg = "Итак, Вы собираетесь поехать в %s с %s по %s в составе %s человек\n" +
                "Подождите, идет расчет 3-х вариантов отдыха...";
        descr="вид отдыха";
/*
И так, Вы собираетесь поехать в Шенген/Азию/Весь Мир с 22/03/2016 по 22/03/2016 в составе 2 человек.
 */
    }
    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.contains("АКТИВН".toUpperCase())) {
            user.setHolidayType(HolidayType.ACTIVE);                      // !!!!!!
        }
        else if(txt.contains("СПОК".toUpperCase())) {
            user.setHolidayType(HolidayType.CALM);                      // !!!!!!
        }
        else if(txt.contains("ОПАСН".toUpperCase())) {
            user.setHolidayType(HolidayType.DANGEROUS);                      // !!!!!!
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
        }
        if(!err) {
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            db.save(user);
        }
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        String err = "err s1-14. Что то пошло не так!";

        Long chatId = user.getChatId();
        String outMessage;
        try {
            int pQuant = user.getEnsuredNumber()+user.getOldNumber()+user.getChildNumber();
            log.trace("params 1 2 3 4 "+user.getRegionType()+"|"+user.getCountryName()+"|"+user.getDateFrom()+"|"+user.getDatePolicyEnd()+"|"+pQuant);
            String regionORcountry = (user.getRegionType() == null) ? user.getCountryName() : Regions.get(user.getRegionType());
            outMessage = String.format(msg,regionORcountry,user.getDateFrom(),user.getDatePolicyEnd(),pQuant);
        }  catch (java.util.IllegalFormatConversionException e) {
            outMessage = err+e.getMessage();
        }  catch (java.util.MissingFormatArgumentException e) {
            outMessage = err+e.getMessage();
        }
        tgbot.sendMenuOff(chatId,outMessage);
        // Async call расчет стоимости вариантов полисов
        try {
            Future<String> res =  tgCalc3Quotas.waitResponse(user);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            tgbot.sendMistake(chatId,"Ошибки в обработке запросов вычисления стоимости полисов, наберите команду /refresh");
        }
    }
}
