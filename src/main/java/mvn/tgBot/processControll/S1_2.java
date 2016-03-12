package mvn.tgBot.processControll;

import mvn.tgBot.db.PolicyType;
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
 * Stage: выбор типа police
 */
@Component
public class S1_2 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_2.class);

    public S1_2() {
        name = "s1-2";
        nextStageName="s1-4c";    // было s1-3
        msg =  "Отлично! Вам нужна страховка на разовую поездку " +
                "или многократная для поездок по всему миру в течение года?";
        descr="выбор типа полиса";
    }
    String[][] menu = {
            {"На одну поездку"},
            {"Годовая (скоро будет)"}
    };


    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        if(txt.equals("/ONETRIP") || txt.equals("ONETRIP") || txt.contains("ОДН") ) {
            user.setPolicyType(PolicyType.ONETRIP);                        // !!!!!!
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else if(txt.contains("ГОДОВ")) {
            user.setWait4Stage("s1-1");     // запомнить след шаг для данного ChatID
            StageInt next = stageList.getStage("s1-1");
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - неправильная команда!");
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//        menuControl.menuON(chatId,msg,menu);
        tgbot.sendMenuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();

    }
}

