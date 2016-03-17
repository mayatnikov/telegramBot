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
 * Stage: ввод адрес регистрации
 */
@Component
public class S1_22 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_18.class);


    public S1_22() {
        name = "s1-22";
        nextStageName="s1-23";
        msg =  "Адрес регистрации?";
        descr="адрес прож-я";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        if(txt.length()>=10) {
            user.setAddress1(txt);
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId, "слишком короткий адрес");
        }
        db.save(user);
    }

/*
    отправить сообщение клиенту
    используется из стадии предыдущей этой
     */
    @Override
    public void sendMessage(User user, Result r) {
        String[][] menu = {
                {"?"}
        };
        Long chatId = user.getChatId();
        if(user.getAddress1()!=null && user.getAddress1().length()>=10) { // отобразить кнопку с Адрес проживания если он есть в профиле
            menu[0][0] =   user.getAddress1();
            tgbot.sendMenuON(chatId, msg, menu);
        }
        else
            tgbot.sendMenuOff(chatId,msg);
    }
}
