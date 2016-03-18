package mvn.tgBot.soap;

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
 * Time: 23:02
 */
@Service
public class WaitPolicy {
    @Autowired
    TgCalcQuote tgCalcQuote;

    @Autowired
    TgCalc3Quotas tgCalc3Quotas;   // это олько  что бы сообщение забрать

    private Log log = LogFactory.getLog(WaitPolicy.class);

    @Async
    public Future<String> getAnsw(Messenger tgbot, User user) throws InterruptedException {
        String[][] menu = {
                {"все правильно"},
                {"есть ошибки"}
        };
        Future<QuoteType> answ = tgCalcQuote.getResponse(tgbot, user, user.getHolidayType(), true);
        while (!(answ.isDone())) {
            Thread.sleep(500); // 500-millisecond pause between each check
            log.trace("Wait...");
        }
        String m2 = tgCalc3Quotas.getHolydayMessage(user.getHolidayType());  // забрать описание типа отдыха
        tgbot.sendMenuON(user.getChatId(), "Страховка для "+m2, menu);
        return new AsyncResult<String>("ok");
    }
}
