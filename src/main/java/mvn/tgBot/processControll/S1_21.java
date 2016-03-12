package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод День Рождения
 */
@Component
public class S1_21 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_18.class);

    public S1_21() {
        name = "s1-21";
        nextStageName="s1-22";
        msg =  "День рождения (ДД/ММ/ГГГГ)";
        descr="ДР";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        String birthday =Regexp.filterDate(txt);
        try {
            if(isCorrectBirthday(birthday)) {
                user.setBirthday(birthday);
                StageInt next = stageList.getStage(nextStageName);
                next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
                //TODO сделать обработку response
                //        rs.getStatusCode().getReasonPhrase();
                user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            }
            else {
                log.error("stage:"+name+" ошибка ввода:"+txt);
                tgbot.sendText(chatId, "Ошибка ввода Дня Рождения: ваш возраст должен быть от 18 до 60 лет");
            }
        } catch (ParseException e) {
            log.error("Error birthday input:"+txt);
            tgbot.sendText(chatId,"Ошибка: неправильный формат даты ДР");
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

        if(user.getBirthday()!=null && user.getBirthday().length()>=10) { // отобразить кнопку с ДР если он есть в профиле
            menu[0][0] =   user.getBirthday();
            tgbot.sendMenuON(chatId, msg, menu);
        }
        else
            tgbot.sendMenuOff(chatId,msg);
    }

    private boolean isCorrectBirthday( String birthday) throws ParseException {
        boolean ok=false;
        int age = CheckDates.getAge(Regexp.filterDate(birthday));
            ok = (age>18 && age < 61);
        return ok;
    }


}
