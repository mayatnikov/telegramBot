package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Age;
import mvn.tgBot.utils.CheckDates;
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
 * Stage: Ввод числа взрослых  если НЕ Шенген или Финнл-я
 */
@Component
public class S1_11 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    CheckDates checkDates;

    private Log log = LogFactory.getLog(S1_11.class);

    public S1_11() {
        name = "s1-11";
        nextStageName = "s1-12";
        msg = "Срок страхования с %s по %s. Количество дней поездки %s \n" +
                "Сколько человек "+  Age.get[0] +" от 12 до 60 лет едет?";
        descr="число взрослых не Шенген";

    }
    String[][] menu = {
            {"1","2","3","4","5"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String input = regexp.filterDigital(txt);
        int nu = Integer.parseInt(input);
        if(nu>=0 && nu<6 ) {
            user.setEnsuredNumber(Integer.parseInt(input));                      // !!!!!!
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId, "Неверные данные");
        }
        db.save(user);
    }

//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        String outMessage;
        outMessage = String.format(msg,user.getDateFrom(),user.getDateTo(),user.getDateDuration());
        tgbot.sendMenuON(chatId,outMessage,menu);
    }
}

