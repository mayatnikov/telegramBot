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
 * Stage: ввод Адрес проживания
 */
@Component
public class S1_23 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_23.class);

    public S1_23() {
        name = "s1-23";
        nextStageName = "s1-24";
        msg = "Адрес проживания?";
        descr="адр. прописки";

    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        if(txt.startsWith("СОВП") ) {
            user.setAddress2(user.getAddress1());                     // !!!!!!
        }
        else {
            user.setAddress2(txt);                     // !!!!!!
        }
        StageInt next = stageList.getStage(nextStageName);
        user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID

        // внести пользователя в список страхуемых первым  если его там еще нет
//        HashMap<String, EnsuredType> hm = user.getEnsured();
//        if(hm == null) hm = new HashMap();
//        if(hm.get("1_0") == null ) hm.put("1_0",new EnsuredType(user.getFirstNameEng(), user.getLastNameEng(), user.getBirthday(),user.getPassport(),"1_0"));
//        else {
//            for(String key : hm.keySet()) {
//                log.trace(key+" "+ hm.get(key) );
//            }
//        }

        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        String[][] menu = {
                {"Совпадает с адресом регистрации"},
                {"?"}
        };
        Long chatId = user.getChatId();
        if(user.getAddress2()!=null && user.getAddress2().length()>=10) { // отобразить кнопку с Адрес проживания если он есть в профиле
            menu[1][0] = user.getAddress2();
        }
        else
            menu[1][0]="?";
        tgbot.sendMenuON(chatId, msg, menu);
    }
}

