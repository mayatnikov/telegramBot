package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: Согласие на обработку перс данных
 */
@Component
public class S1_16 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_16.class);

    public S1_16() {
        name = "s1-16";
        nextStageName = "s1-17";
        msg = "Для того, чтобы оформить страховку нам требуется Ваше согласие на обработку персональных данных согласно ФЗ 152 и с правилами страхования";
        descr="согл. на обр-ку";

    }
    String[][] menu1 = {
            {"Принимаю"},
            {"Не принимаю"}
    };
    String[][] menu2 = {
            {"Все верно"},
            {"Изменить"}
    };


    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        if(txt.startsWith("ПРИНИ") || txt.contains("YES") || txt.contains("ДА") || txt.contains("ИЗМЕН") ) {
            user.setRoolesAccept(true);                      // !!!!!!
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        }
        else if(txt.contains("ВЕРНО")) {

            // внести пользователя в список страхуемых первым  если его там еще нет
            // !!! ТОЖЕ САМОЕ ЕСТЬ НА ШАГЕ 1-23
            // --- !!! ----
            HashMap<String, EnsuredType> hm = user.getEnsured();
            if(hm == null) hm = new HashMap();
            if(hm.get("1_0") == null ) hm.put("1_0",new EnsuredType(user.getFirstNameEng(), user.getLastNameEng(), user.getBirthday(),user.getPassport(),"1_0"));
            user.setEnsured(hm);

            StageInt next = stageList.getStage("s1-24");
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage("s1-24");     // запомнить след шаг для данного ChatID
         }
        else {
            log.trace("ОТКАЗ");
            user.setWait4Stage("s1-1");
            tgbot.sendMenuOff(chatId, "Отказ от оформления, вы можете возобновить работу, введенные данные сохранились");
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        String msgOut;
        String [][] mm;
        if(user.isValid()) {
            msgOut = "Проверьте перс. данные:"+
                    "\nФамилия: "+user.getLastName()+
                    "\nИмя:     "+user.getFirstName()+
                    "\nОтчество:"+user.getSecondName()+
                    "\nПол:     "+user.getSex()     +
                    "\nДень р-я:"+user.getBirthday() +
                    "\n№ тел-на:"+ user.getPhone()+
                    "\nАдрес-1: "+user.getAddress1()+
                    "\nАдрес-2: "+user.getAddress2()+
                    "\nE-Mail:  "+user.getEmail()
            ;
            mm = menu2;
        }
        else {
            msgOut = msg;
            mm = menu1;
        }
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId,msgOut,mm);
    }
}

