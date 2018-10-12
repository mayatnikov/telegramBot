package mvn.tgBot.processControll;

import mvn.tgBot.db.CountryType;
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
 * Stage: выбор списка стран или одной
 */
@Component
public class S1_3 extends StageMaster implements StageInt {
    private Log log = LogFactory.getLog(S1_3.class);

    public S1_3() {
        name = "s1-3";
        nextStageName="?";

        msg="Ммм...планируете отпуск? " +
                "Или, может быть, романтичный уик энд?\n" +
                "Неужели по работе? Куда отправляетесь на этот раз?\n" +
                "Можем рассчитать страховку для поездки в одну страну или несколько,\n" +
                "если в путешествии вы планируете переезжать из одной в другую\n" +
                "Выберите из:";
        descr="выбор списка/одной/регион страны";
    }
    String[][] menu = {
            {"Несколько стран"},
            {"Территория страхования"},
            {"Одна страна"}
    };

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        boolean err=false;
        String nextName = "";
        if(txt.startsWith("НЕСК") ) {
            user.setCountryType(CountryType.MANY);
            nextName="s1-4b";
        }
        else if(txt.startsWith("ТЕРР") ) {
            user.setCountryType(CountryType.REGION);                        // !!!!!!
            nextName="s1-4c";
        }
        else if(txt.startsWith("ОДНА") ) {
            user.setCountryType(CountryType.ONE);                        // !!!!!!
            nextName="s1-4a";
        }
        else {
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
            err=true;
        }

        if(!err) {
            StageInt next = stageList.getStage(nextName);
            next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextName);     // запомнить след шаг для данного ChatID
            db.save(user);
            log.info ("end of stage user:"+chatId);
        }
    }


    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
//        menuControl.menuON(chatId,msg,menu);
        tgbot.sendMenuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
    }
}


