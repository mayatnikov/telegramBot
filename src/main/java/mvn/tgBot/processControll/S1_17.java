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
 * Stage: Номер телефона
 */
@Component
public class S1_17 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_17.class);

    @Autowired
    Regexp regexpl;

    public S1_17() {
        name = "s1-17";
        nextStageName="s1-18";
        msg =  "*Ваш номер телефона?* \nПо номеру телефона вы получите доступ к Личному кабинету на http://Tinkoffinsurance.ru";
        descr="Номер тел.";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        txt = regexpl.filterPhone(txt);
        Long chatId = user.getChatId();
        if(txt.length()>=10) {
            user.setPhone(txt);
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "Введен [" +txt+"] - это не номер телефона должно быть не менее 10 цифр, \n" +
                    " например так:9115674433 \n или так:8 911 5674433 \n или так:8(916)1112233 \n или даже так: +7 911 211 88 66");
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
                {"?"}        // 1                  [0][0]
        };
    Long chatId = user.getChatId();

    if(user.getPhone()!=null && user.getPhone().length()>=7) { // отобразить кнопку с телефоном если он есть в профиле
        menu[0][0] =   user.getPhone();
        tgbot.sendMenuON(chatId, msg, menu);
    }
    else
        tgbot.sendMenuOff(chatId,msg);
    }
}
