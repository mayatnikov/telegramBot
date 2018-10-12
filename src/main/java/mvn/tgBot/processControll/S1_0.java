package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ТОЧКА ВХОДА
 */
@Component
public class S1_0 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_0.class);

    public S1_0() {
        name = "s1-0";
        nextStageName="s1-1";
        descr="точка входа";
        msg =  "Для возобновления работы введите команду /start";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        // @TODO присвоение уникального номера процессу
        log.debug("start stage for user:" + user.getUserName() + " request:" + r.getMessage().getText());
        String txt = r.getMessage().getText().toUpperCase();
        StageInt next = stageList.getStage(nextStageName);
        log.debug("next stage:" + next);
        user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        db.save(user);
    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId, msg);
    }
}
