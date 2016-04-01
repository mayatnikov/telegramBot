package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import mvn.tgBot.utils.Transliterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод ФИО
 */
@Component
public class S1_19 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_18.class);

    @Autowired
    Transliterator tr;

    public S1_19() {
        name = "s1-19";
        nextStageName="s1-20";
        msg =  "Фамилия Имя Отчество";
        descr="ФИО";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        log.trace(name+"-processor started");
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        String[] fio = Regexp.parseWorlds(txt);
        log.trace("FIO input world count="+fio.length);
        if(fio!= null && fio.length>=2 && fio[0].length()>=2 && fio[1].length()>=2) {
            user.setLastName(fio[0]);
            user.setFirstName(fio[1]);
            user.setSecondName((fio.length>2) ? fio[2] : "");
//            user.setLastNameEng(tr.transliterate(fio[0]).toUpperCase());
//            user.setFirstNameEng(tr.transliterate(fio[1]).toUpperCase());
            user.setUserName(txt);
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else {
            tgbot.sendMistake(chatId, "ошибка в формате данных");
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

        if(user.getUserName()!=null && user.getUserName().length()>=5) { // отобразить кнопку с ФИО если он есть в профиле
            menu[0][0] =   user.getUserName();
            tgbot.sendMenuON(chatId, msg, menu);
        }
        else
            tgbot.sendMenuOff(chatId,msg);
    }
}
