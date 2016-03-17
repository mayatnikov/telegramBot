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
 * Stage: первичный вход
 */
@Component
public class S1_1 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_1.class);

    public S1_1() {
        name = "s1-1";
        nextStageName="s1-2";
        descr="первичный вход";
        msg =  "Привет! Я помогу Вам оформить " +
                "туристическую страховку. Начнём?";
    }
    String[][] menu = {
            {"ДА, хочу страховку"},
            {"НЕТ, спасибо"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
       log.debug("start stage for user:"+user.getUserName()+" request:"+r.getMessage().getText());
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.equals("/START") || txt.equals("START") || txt.equals("/СТАРТ") || txt.equals("СТАРТ") || txt.startsWith("ДА")) {
            StageInt next = stageList.getStage(nextStageName);
            log.debug("next stage:"+next);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            StageInt next = stageList.getStage("s1-0");
            log.debug("next stage:"+next);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage("s1=0");     // запомнить след шаг для данного ChatID
        }
        db.save(user);
    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//        ResponseEntity rs = tg.sendMenuOff(chatId,msg);
//        menuControl.menuON(chatId,msg,menu);
          tgbot.sendMenuON(chatId,msg,menu);
    }
}
