package mvn.tgBot.processControll;

import mvn.tgBot.db.RegionType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: выбор региона
 */
@Component
public class S1_4c extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_4c.class);

    public S1_4c() {
        name = "s1-4c";
        nextStageName="s1-6";
        msg =  "Выберите территорию страхования:";
        descr="выбор территории";
    }
    String[][] menu = {
            {"Весь мир"},
            {"Азия"},
            {"Шенген"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        boolean err=false;
//  если регионы то ни списка стран ни одна или много быть не может
        user.setCountryType(null);
        user.setCountryName(null);
//
        if(txt.contains("ВЕСЬ") ) {
            user.setRegionType(RegionType.WORLDWIDE);                        // !!!!!!
        }
        else if(txt.contains("АЗИЯ") ) {
            user.setRegionType(RegionType.ASIA);                        // !!!!!!
        }
        else if(txt.contains("ШЕНГ") ) {
            user.setRegionType(RegionType.SHENGEN);                        // !!!!!!
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - не менее 7 символов!");
        }
       if(!err) {
           StageInt next = stageList.getStage(nextStageName);
           next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
           user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
           db.save(user);
       }
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//            tg.sendText(chatId,msg);
//        menuControl.menuON(chatId,msg,menu);
        tgbot.sendMenuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();

    }
}

