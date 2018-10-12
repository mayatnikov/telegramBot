package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 07/03/16
 * Time: 09:05
 */
@Component
public class ContactProcessor extends StageMaster {

    public  ContactProcessor() {
        name="ContactProcessor";
        nextStageName="?";
        descr="contact processor";
        msg =  "?";

    }
    private Log log = LogFactory.getLog(ContactProcessor.class);

//    String[][] menu = {
//            {"1","2"},
//            {"4","3"}
//    };
    String msg="Скоро контакт будет обрабатываться как ввод персональных данных";


    @Override
    public void process(User user, Result r) {

    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendText(chatId,msg);
//        tgbot.sendMenuON(chatId,msg,menu);
    }


}
