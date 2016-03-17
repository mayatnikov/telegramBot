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

    private Log log = LogFactory.getLog(WaitPolicy.class);

    @Async
    public Future<String> getAnsw(Messenger tgbot, User user) throws InterruptedException {
        String[][] menu = {
                {"все правильно"},
                {"есть ошибки"}
        };
        Future<QuoteType> answ = tgCalcQuote.getResponse(tgbot, user, user.getHolidayType(), true);
        while (!(answ.isDone())) {
            Thread.sleep(200); // 200-millisecond pause between each check
            log.trace("Wait...");
        }
        tgbot.sendMenuON(user.getChatId(), "\ud83d\ude0a", menu);
        return new AsyncResult<String>("ok");
    }

}
