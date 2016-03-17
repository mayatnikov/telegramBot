package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: доступ к оплате
 */
@Component
public class S1_27 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    @Autowired
    MongoOperations mongoOperations;  // для хранения истории

    private Log log = LogFactory.getLog(S1_27.class);

    private String nextStageVar="";
    public S1_27() {
        name = "s1-27";
        nextStageName = "s1-1";
        msg = "Спасибо, что были с нами";
    }

    String paymentUrl="https://ttt.aaa/%s";

    String[][] menu = {
            {"начать новый процесс"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            db.save(user);
            Date dt = new Date();
            Long timeNow =dt.getTime();
            user.setOpDate(timeNow);
            saveHistory(user);                     // !!!!!!
    }

    private void saveHistory(User user) {
        Date dt = new Date();
        String usid = user.getId()+"hist"+dt.getTime();
        user.setId(usid);
        mongoOperations.save(user,"history");
    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendText(chatId,msg);
        tgbot.sendMenuON(chatId,paymentUrl,menu);
    }
}

