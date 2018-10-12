package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
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
 * Stage: доступ к оплате
 */
@Component
public class S1_END extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_END.class);

    private String nextStageVar="";
    public S1_END() {
        name = "s1-END";
        nextStageName = "s1-0";
        msg = "спасибо";
    }

//    String[][] menu = {
//            {"оплатил"}
//    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        log.debug("End of business process");
        StageInt next = stageList.getStage(nextStageName);
        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
        user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        db.save(user);
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        // @TODO получить ссылку на оплату и вывести ее клиенту
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId,msg);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();

    }

}

