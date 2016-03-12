package mvn.tgBot.soap;

import mvn.tgBot.db.User;
import mvn.tgBot.tgControl.Messenger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import ru.toi.esb.model.servicemessagesext.GetPaymentLinkRequestType;
import ru.toi.esb.model.servicemessagesext.GetPaymentLinkResponseType;

import java.math.BigDecimal;
import java.util.concurrent.Future;


@Service
public class TgGetPaymentLink {
    private Log log = LogFactory.getLog(TgGetPaymentLink.class);

    @Autowired
    TgMessageHeader hdr;

    @Autowired
    TgSoapService ss;

    public TgGetPaymentLink() {
//        ss = new TgSoapService();
        log.debug("service created");
    }

    /**
     * Получить ссылку на оплату сервиса
     * @param tgbot
     * @param user
     * @param policyNumber
     * @param total
     * @return
     */
    @Async
    public Future<GetPaymentLinkResponseType> getResponse(Messenger tgbot, User user, String policyNumber, BigDecimal total ) {
        GetPaymentLinkRequestType req = new GetPaymentLinkRequestType();
        req.setHeader(hdr.getHeader());
        req.setClientIP("127.0.0.1");
        req.setClientPhone(user.getPhone());
        req.setPolicyNumber(policyNumber);
        req.setTotalPremium(total);
        GetPaymentLinkResponseType response=null;
        try {
// ЗАПРОС
        log.debug("Send soap request, wait response ...");
        response = ss.getPort().getPaymentLink(req);           // запрос к серверу
        log.debug("soap response");
        String status = response.getHeader().getResultInfo().getStatus();
        if(status.equals("OK")) {
            String url = response.getPaymentLink();
            tgbot.sendText(user.getChatId(),"Для оплаты полиса перейдите по ссылке: "+url);
            tgbot.sendHtml(user.getChatId(),"Получен ответ:\n <a href='"+url+"'>[ЭТО ССЫЛКА ДЛЯ ОПЛАТЫ ПОЛИСА]</a> ");

        }
        else {
            String descr = response.getHeader().getResultInfo().getErrorInfo().getDescr();
            log.error("Error on CalcQuote: Status=["+status+"] descr:["+descr+"]");
            if(tgbot!=null) tgbot.sendText(user.getChatId(),"Получены ошибки от сервера, проверьте данные запроса ("+descr+")");
        }
        // return new AsyncResult<User>(results);
        } catch (Exception e) {
            tgbot.sendText(user.getChatId(),"Ошибка при получении ссылки на оплату полиса ....");
            e.printStackTrace();
        }
        log.debug("end request");
        return new AsyncResult<GetPaymentLinkResponseType>(response);
    }
}


/*

    <soapenv:Body>
        <ser:getPaymentLinkRequest>
            <ser:Header>
                <user>telegram</user>
                <password>qIQqu873KE</password>
            </ser:Header>
            <ser:PolicyNumber>7172301359</ser:PolicyNumber>
            <ser:TotalPremium>10567.00</ser:TotalPremium>
            <ser:ClientIP>127.0.0.1</ser:ClientIP>
            <ser:ClientPhone>79165894332</ser:ClientPhone>
        </ser:getPaymentLinkRequest>
    </soapenv:Body>

 */