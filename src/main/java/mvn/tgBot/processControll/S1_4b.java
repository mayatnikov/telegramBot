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
 * Stage: ввод списка стран
 */
@Component
public class S1_4b extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_4b.class);

    @Autowired
    CountryCodeUtils countryCodeUtils;

    public S1_4b() {
        name = "s1-4b";
        nextStageName="s1-6";
        msg =  "Укажите страны, которые планируете посетить через запятую в формате «Австрия,Финляндия,США»";
        descr="ввод списка стран";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        if(txt.length()>7 ) {
            if(checkCountryList(txt)) {
                user.setCountryName(txt);                        // !!!!!!
                user.setRegionType(null);
                StageInt next = stageList.getStage(nextStageName);
                next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
                user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            } else {
                log.error("stage:"+name+" ошибка ввода:"+txt+ "- не все страны в списке");
                tgbot.sendText(chatId, "проверка не прошла - проверьте список стран!");
            }
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
//            tg.sendText(chatId, " ошибка ввода - не менее 7 символов!");
            tgbot.sendText(chatId, " ошибка ввода - не менее 7 символов!");
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//            tg.sendMenuOff(chatId,msg);
        tgbot.sendMenuOff(chatId,msg);
//        menuControl.menuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
    }

    private boolean checkCountryList(String lst) {
        String[] sm = lst.split(","); //   new RegExp("\\s+"));
      boolean ret =true;
        for(int tik=0;tik<sm.length;tik++) {
            log.trace(sm[tik]);
            if(countryCodeUtils.checkCountry(sm[tik]) == null) ret = false;
        }
      return ret;
    }

}

