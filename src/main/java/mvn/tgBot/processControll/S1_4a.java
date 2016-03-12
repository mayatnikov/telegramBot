package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.product.CountryCodeUtils;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод названия страны
 */
@Component
public class S1_4a extends StageMaster implements StageInt {

@Autowired
    CountryCodeUtils countryCodeUtils;

    private Log log = LogFactory.getLog(S1_4a.class);

    public S1_4a() {
        name = "s1-4a";
        nextStageName="s1-6";
        msg =  "Укажите название страны, которую планируете посетить";
        descr="ввод названия страны";
    }
//    String[][] menu = {
//            {""},
//            {""}
//    };


    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        if(txt.length()>3 ) {
            String countryCode = countryCodeUtils.checkCountry(txt);
            if(countryCode!=null) {
                user.setCountryName(txt);                        // !!!!!!
                StageInt next = stageList.getStage(nextStageName);
                user.setCountryCode(countryCode);
                user.setRegionType(null);   // это одна страна
                next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
                user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            }
            else { // такой страны нет
//                tg.sendText(chatId,txt +"-код страны не найден, повторите ввод");
                tgbot.sendText(chatId,txt +"-код страны не найден, повторите ввод");

            }

        }
        else {  // короткий ввод
            log.error("stage:"+name+" ошибка ввода:"+txt);
//            tg.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - не менее 3-Х символов");
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - не менее 3-Х символов");
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//        tg.sendMenuOff(chatId,msg);
        tgbot.sendMenuOff(chatId,msg);
//        menuControl.menuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();

    }
}

