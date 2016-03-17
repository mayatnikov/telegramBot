package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Age;
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
 * Stage: Ввод числа детей
 */
@Component
public class S1_13 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_13.class);

    public S1_13() {
        name = "s1-13";
        nextStageName = "s1-14";
        msg = "И сколько детей "+ Age.get[2] +" до 12 лет?";
        descr="число детей";

    }
    String[][] menu = {
            {"0","1","2","3"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String input = regexp.filterDigital(txt);
        int chaild = Integer.parseInt(input);
        if( chaild >=0 && chaild <=3 ) {
            user.setChildNumber(chaild);                      // !!!!!!
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
        }
        db.save(user);
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId,msg,menu);
    }
}

