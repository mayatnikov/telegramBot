package mvn.tgBot.processControll;

import mvn.tgBot.soap.TgCalcQuote;
import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toi.model.gw.quote.QuoteType;

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
    TgCalcQuote tgCalcQuote;

    private Log log = LogFactory.getLog(S1_14.class);

    public S1_14() {
        name = "s1-14";
        nextStageName = "s1-14a";
        msg = "И так: Вы собираетесь в поездку " +
                "в %s с %s по %s " +
                "в составе %s человек.\n" +
                "Предлагаю такие варианты:\n" +
                "ждите расчета 3-х вариантов отдыха ...";
        descr="вид отдыха";

    }
    String[][] menu = {
            {"Спокойный отдых"},
            {"Активный отдых"},
            {"Опасные виды спорта"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.startsWith("АКТИ")) {
            user.setHolidayType(HolidayType.ACTIVE);                      // !!!!!!
        }
        else if(txt.startsWith("СПОК")) {
            user.setHolidayType(HolidayType.CALM);                      // !!!!!!
        }
        else if(txt.startsWith("ОПАС")) {
            user.setHolidayType(HolidayType.DANGEROUS);                      // !!!!!!
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - неправильная команда!");
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
            int tt = user.getEnsuredNumber()+user.getOldNumber()+user.getChildNumber();
            log.trace("params 1 2 3 4 "+user.getRegionType()+"|"+user.getCountryName()+"|"+user.getDateFrom()+"|"+user.getDateTo()+"|"+tt);
            String regionORcountry = (user.getRegionType() == null) ? user.getCountryName() : user.getRegionType().toString();
            outMessage = String.format(msg,regionORcountry,user.getDateFrom(),user.getDateFrom(),tt);
        }  catch (java.util.IllegalFormatConversionException e) {
            outMessage = err+e.getMessage();
        }  catch (java.util.MissingFormatArgumentException e) {
            outMessage = err+e.getMessage();
        }
        // Async call расчет вариантов стоимости
        Future<QuoteType> quote1 = tgCalcQuote.getResponse(tgbot, user,HolidayType.CALM,false);
        Future<QuoteType> quote2 = tgCalcQuote.getResponse(tgbot, user,HolidayType.ACTIVE,false);
        Future<QuoteType> quote3 = tgCalcQuote.getResponse(tgbot, user,HolidayType.DANGEROUS,false);
        tgbot.sendMenuON(chatId,outMessage,menu);
    }
}

