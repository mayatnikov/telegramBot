package mvn.tgBot.processControll;

import mvn.tgBot.db.HistoryRepository;
import mvn.tgBot.db.User;
import mvn.tgBot.soap.TgCreatePolicy;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toi.esb.model.servicemessagesext.CreatePolicyResponseType;
import java.util.concurrent.Future;


/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: доступ к оплате
 */
@Component
public class S1_26 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;
    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    TgCreatePolicy tgCreatePolicy;

    private Log log = LogFactory.getLog(S1_26.class);

    private String nextStageVar="";
    public S1_26() {
        name = "s1-26";
        nextStageName = "s1-1";
   //     msg = "Супер! Полис мы уже подготовили, для оплаты перейдите по ссылке или оплатить полис можно из Личного кабинета на tinkoffinsurance.ru (вход по смс-коду на указанный вами телефон)";
        msg = "Отправлен запрос на создание полиса.\n" +
                "Пожалуйста ожидайте сообщения о создании полиса и ссылки на оплату.\n" +
                "Если что то пойдет не так введите /refresh";
        descr="пошли платить";
    }


    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();

        StageInt next = stageList.getStage("s1-1");
        next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
        //TODO сделать обработку response
        //        rs.getStatusCode().getReasonPhrase();
        user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
        db.save(user);
    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();

        /*
                Future<QuoteType> quote = tgCalcQuote.getResponse(tg, user,user.getHolidayType(),true);
        log.debug("wait soap response ...");

         */
        Future<CreatePolicyResponseType> resp = tgCreatePolicy.getResponse(tgbot,user,user.getHolidayType());


        tgbot.sendMenuOff(chatId,msg);

    }
}

