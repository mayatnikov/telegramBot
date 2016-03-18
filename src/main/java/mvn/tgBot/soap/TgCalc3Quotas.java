package mvn.tgBot.soap;

import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgControl.Messenger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import ru.toi.model.gw.quote.QuoteType;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 15/03/16
 * Time: 13:55
 */
@Service
public class TgCalc3Quotas {
    private Log log = LogFactory.getLog(TgCalc3Quotas.class);

    @Autowired
    TgCalcQuote tgCalcQuote;
    @Autowired
    Messenger tgbot;

    String[][] menu = {
            { "\ud83c\udf34"+" Спокойный отдых"},
            {"\ud83d\udeb2" + " Активный отдых"},
            {"\ud83c\udfc2"+" Опасные виды спорта"}
    };

    public String getHolydayMessage(HolidayType ht) {
        int id=0;
        switch (ht) {
            case CALM:
                id=0;
                break;
            case ACTIVE:
                id=1;
                break;
            case DANGEROUS:
                id=2;
                break;
        }
        return (menu[id][0]);
    }

    @Async
    public Future<String> waitResponse(User user) throws InterruptedException {

        // Async call расчет вариантов стоимости
        Future<QuoteType> quote1 = tgCalcQuote.getResponse(tgbot, user, HolidayType.CALM, false);
        Future<QuoteType> quote2 = tgCalcQuote.getResponse(tgbot, user, HolidayType.ACTIVE, false);
        Future<QuoteType> quote3 = tgCalcQuote.getResponse(tgbot, user, HolidayType.DANGEROUS, false);

        // Wait until they are all done
        while (!(quote1.isDone() && quote2.isDone() && quote3.isDone())) {
            Thread.sleep(500); // 200-millisecond pause between each check
            log.trace("Wait...");
        }
        log.trace("quote1 status canceled:"+quote1.isCancelled() +">"+ quote1.getClass());
        log.trace("quote2 status canceled:"+quote2.isCancelled() +">"+ quote1.getClass());
        log.trace("quote3 status canceled:"+quote3.isCancelled() +">"+ quote1.getClass());

        tgbot.sendMenuON(user.getChatId(), "Выберите подходящий вариант:" ,menu);
        return new AsyncResult<String>("ok");
    }
}

/*

"\ud83c\udf34" - palm_tree
"\ud83d\udeb4" - bicyclist
"\ud83c\udfc2" - snowboarder

 */