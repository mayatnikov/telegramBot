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
 * Stage:   ВВод даты подачи в посольство Финляндии
 */
@Component
public class S1_8 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;


    private Log log = LogFactory.getLog(S1_8.class);

    public S1_8() {
        name = "s1-8";
        nextStageName="s1-10";
        msg =  "По требованию посольства Финляндии, " +
                "полис должен действовать на момент подачи " +
                "документов на получение визы.\n" +
                "Поэтому прошу Вас указать дату подачи документов на визу, дата должна быть в формате ДД/ММ/ГГГГ";
        descr="дата подачи заявления Финляндия";
    }
    String errMessage="Ошибка ввода даты, дата должна быть в формате ДД/ММ/ГГГГ, дата подачи не может быть в прошлом";

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        log.trace("input text="+txt);
        Long chatId = user.getChatId();
        String dateReg = regexp.filterDate(txt);
        try {
            if( checkDates.checkDateStart(dateReg) ) {
                user.setDateReg(dateReg);                        // !!!!!!
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
            log.error(e.getMessage());
        }  catch (java.util.IllegalFormatConversionException e) {
            log.error(e.getMessage());
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId,msg);
    }
}

