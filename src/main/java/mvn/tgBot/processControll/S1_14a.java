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
 * Stage: вопрос о необходимости опций
 */
@Component
public class S1_14a extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_14a.class);

    public S1_14a() {
        name = "s1-14a";
        nextStageName = "?";
        msg = "Добавить опции страхования?";
        descr="вопрос о необходимости опций";

    }
    String[][] menu = {
            {"ДА"},
            {"НЕТ"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.startsWith("ДА")) {
            user.setEnsuranceOptEnable(true);                      // !!!!!!
            user.setWait4Stage("s1-15");     // запомнить след шаг для данного ChatID
        }
        else if(txt.startsWith("НЕТ")) {
            user.setEnsuranceOptEnable(false);                      // !!!!!!
            user.setEnsuranceOpt1(null);
            user.setEnsuranceOpt2(null);
            user.setEnsuranceOpt3(null);
            user.setEnsuranceOpt4(null);
            user.setWait4Stage("s1-16");     // запомнить след шаг для данного ChatID
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - неправильная команда!");
        }
        if(!err) {
            StageInt next=stageList.getStage(user.getWait4Stage());
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            db.save(user);
        }
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId,msg,menu);
    }
}

