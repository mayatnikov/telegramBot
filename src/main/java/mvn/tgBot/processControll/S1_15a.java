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
 * Stage: корректировка опций
 */
@Component
public class S1_15a extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_15a.class);

    public S1_15a() {
        name = "s1-15a";
        nextStageName = "s1-16";
        msg = "Стоимость страховки, пакет «%s», дополнительные опции: %s составит %d рублей.";
        descr="корректировка опций и оценка стоимости";

    }
    String[][] menu = {
            {"OK, оформляем"},
            {"Добавить еще"},
            {"Убрать дополнительные опции"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String nextStageVar="";
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.startsWith("ОК")) {
            nextStageVar="s1-16";
        }
        else if(txt.contains("ДОБАВ")) {
            nextStageVar="s1-15";
        }
        else if(txt.contains("УБРАТ")) {
            user.setEnsuranceOptEnable(false);                       // !!!!!!
            user.setEnsuranceOpt1(null);                       // !!!!!!
            user.setEnsuranceOpt2(null);                       // !!!!!!
            user.setEnsuranceOpt3(null);                       // !!!!!!
            user.setEnsuranceOpt4(null);                       // !!!!!!
            nextStageVar="s1-16";
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - неправильная команда!");
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
        StringBuffer ol= new StringBuffer();
        Long amount = 0L;

        if(user.getEnsuranceOpt1() != null )   ol.append("квартиры,");
        if(user.getEnsuranceOpt2() != null )   ol.append("несчастный случай,");
        if(user.getEnsuranceOpt3() != null )   ol.append("утеря багажа,");
        if(user.getEnsuranceOpt4() != null )   ol.append("отмена поездки,");
        String outMessage = String.format(msg,user.getHolidayType(),ol, amount);
        tgbot.sendMenuON(chatId,outMessage,menu);
    }
}

