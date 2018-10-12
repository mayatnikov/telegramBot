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
 * Stage: ввод E-Mail
 */
@Component
public class S1_18 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_19.class);

    @Autowired
    Regexp regexpl;

    public S1_18() {
        name = "s1-18";
        nextStageName="s1-19";
        msg =  "Ваш e-mail?\nНа него мы отправим готовый полис";
        descr="email";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        if(Regexp.checkEmail(txt)) {
            user.setEmail(txt);
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            tgbot.sendMistake(chatId,"ошибка в адресе почты");
        }
        db.save(user);
    }

    @Override
    public void sendMessage(User user, Result r) {
        String[][] menu = {
                {"?"}        // 1                  [0][0]
        };
        Long chatId = user.getChatId();

        if(user.getEmail()!=null && user.getEmail().length()>=5) { // отобразить кнопку с email если он есть в профиле
            menu[0][0] =   user.getEmail();
            tgbot.sendMenuON(chatId, msg, menu);
        }
        else
            tgbot.sendMenuOff(chatId,msg);
    }
}
