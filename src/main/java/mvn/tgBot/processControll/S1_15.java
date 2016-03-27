package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuranceOptType;
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
 * Stage: опции страхования
 */
@Component
public class S1_15 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_15.class);

    public S1_15() {
        name = "s1-15";
        nextStageName = "?";
        msg = "Выберите опции страхования:";
        descr="опции страхования";

    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        boolean err=false;
        String nextStageVar="s1-15";
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();

        if(txt.contains("КВАРТИРЫ")) {
            if(user.getEnsuranceOpt1() != null) user.setEnsuranceOpt1(null);
            else user.setEnsuranceOpt1(EnsuranceOptType.APARTMENT);                      // !!!!!!
        }
        else if(txt.contains("НЕСЧАСТ")) {
            if(user.getEnsuranceOpt2() != null) user.setEnsuranceOpt2(null);
            else user.setEnsuranceOpt2(EnsuranceOptType.ACCIDENT);                       // !!!!!!
        }
        else if(txt.contains("БАГАЖ")) {
            if(user.getEnsuranceOpt3() != null) user.setEnsuranceOpt3(null);
            else user.setEnsuranceOpt3(EnsuranceOptType.BAGGAGE);                       // !!!!!!
        }
        else if(txt.contains("ОТМЕНА")) {
            if(user.getEnsuranceOpt4() != null) user.setEnsuranceOpt4(null);
            else user.setEnsuranceOpt4(EnsuranceOptType.TRIPCANCEL);                       // !!!!!!
        }
        else if(txt.contains("OK")) {
            nextStageVar="s1-16";
        }
        else {
            err=true;
            log.error("stage:"+name+" ошибка ввода:"+txt);
            tgbot.sendMistake(chatId);
        }
        if(!err) {
            log.trace(name+": Display stage:"+ nextStageVar);
            StageInt next = stageList.getStage(nextStageVar);
            next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
            //TODO сделать обработку response
            //        rs.getStatusCode().getReasonPhrase();
            user.setWait4Stage(nextStageVar);     // запомнить след шаг для данного ChatID
            db.save(user);
        }
    }
//        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        String[][] menu = {
                {"?"},        // 2                  [1][0]
                {"?"},        // 3                   [2][0]
                {"?"},        // 4 [3][0]
                {"OK, оформляем"}
        };

        String[][] menuUnMarket = {
//                {"Страхование квартиры на время поездки"},   // 1
                {"Страхование от несчастного случая"},       // 2
                {"Багаж"},                                   // 3
                {"Отмена поездки"},                          // 4
                {"OK, оформляем"}
        };
        String[][] menuMarket = {
//                {"√ Страхование квартиры на время поездки"},   // 1
                {"√ Страхование от несчастного случая"},       // 2
                {"√ Багаж"},                                   // 3
                {"√ Отмена поездки"},                          // 4
                {"OK, оформляем"}
        };
        if(user.getEnsuranceOpt2() != null) menu[0][0]=menuMarket[0][0];
            else   menu[0][0]=menuUnMarket[0][0];
        if(user.getEnsuranceOpt3() != null) menu[1][0]=menuMarket[1][0];
            else   menu[1][0]=menuUnMarket[1][0];
        if(user.getEnsuranceOpt4() != null) menu[2][0]=menuMarket[2][0];
            else   menu[2][0]=menuUnMarket[2][0];
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId,msg,menu);
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
    }
}
