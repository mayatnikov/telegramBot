package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод даты отъезда
 */
@Component
public class S1_6 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;

    private Log log = LogFactory.getLog(S1_6.class);

    public S1_6() {
        name = "s1-6";
        nextStageName="s1-7";
        msg =  "Когда уезжаете? \nВведите дату в виде ДД/ММ/ГГГГ";
        descr = "дата отъезда";
    }

    String errMessage="Ошибка в формате даты, необходимо вводит ДД ММ ГГГГ, дата не может быть меньше текущего дня и позднее 1 года от текущего времени";

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String input = regexp.filterDate(txt);
        try {
            if(checkDates.checkDateStart(input) ) {
                user.setDateFrom(input);                        // !!!!!!
                StageInt next = stageList.getStage(nextStageName);
                next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
                //TODO сделать обработку response
                //        rs.getStatusCode().getReasonPhrase();
                user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            }
            else {
                log.error("stage:"+name+" ошибка ввода:"+txt);
                tgbot.sendText(chatId, errMessage);
            }
        } catch (ParseException e) {
            tgbot.sendText(chatId, errMessage);
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId,msg);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();

    }
}

