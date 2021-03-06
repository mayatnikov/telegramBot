package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.soap.WaitPolicy;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: корректировка опций
 */
@Component
public class S1_15a extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    WaitPolicy waitPolicy;

    private Log log = LogFactory.getLog(S1_15a.class);

    public S1_15a() {
        name = "s1-15a";
        nextStageName = "s1-16";
        msg = "Расчет стоимости страховки с дополнительными опциями";
        descr="корректировка опций и оценка стоимости";

    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String nextStageVar="";
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.contains("ПРАВИЛЬНО")) {
            nextStageVar="s1-16";
        }
        else if(txt.contains("ОШИБКИ")) {
            nextStageVar="s1-15";
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
        }
        if(!err) {
            StageInt next = stageList.getStage(nextStageVar);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextStageVar);     // запомнить след шаг для данного ChatID
            db.save(user);
        }
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId,"Расчет стоимости пакета с доп опциями");
        try {
            Future<String> res =  waitPolicy.getAnsw(tgbot,user);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            tgbot.sendMistake(chatId,"Ошибки в обработке запросов вычисления стоимости полисов, наберите команду /refresh");
        }

    }
}

