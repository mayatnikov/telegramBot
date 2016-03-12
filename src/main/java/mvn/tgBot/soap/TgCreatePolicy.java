package mvn.tgBot.soap;

import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgControl.Messenger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.paymentcommon.PaymentMethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import ru.toi.esb.model.servicemessagesext.CreatePolicyRequestType;
import ru.toi.esb.model.servicemessagesext.CreatePolicyResponseType;
import ru.toi.esb.model.servicemessagesext.GetPaymentLinkResponseType;
import ru.toi.model.common.DeliveryMethodType;
import ru.toi.model.gw.client.ClientInfoType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
@Service
public class TgCreatePolicy {
    private Log log = LogFactory.getLog(TgCreatePolicy.class);

    @Autowired
    TgMessageHeader hdr;

    @Autowired
    TgGetPaymentLink tgGetPaymentLink;

    @Autowired
    TgSoapService ss;

    String msg = "Полис для оплаты создан \n Счет: %s \n Номер полиса: %s\n Стоимость: %.2f \n ждите получения ссылки на оплату ...";

    public TgCreatePolicy() {
//        ss = new TgSoapService();
        log.debug("web-service created");
    }

    /**
     * Асинхронный запрос - получение расчета стоимости полиса
     *
     * @param tgbot
     * @param user
     * @param holidayType тип отдыха (спокойный опасный и т.п.)
     * @return
     */
    @Async
    public Future<CreatePolicyResponseType> getResponse(Messenger tgbot, User user, HolidayType holidayType) {

        CreatePolicyRequestType req = null;  //exception !
        CreatePolicyResponseType resp = null;
        try {
            req = createRequest(user, holidayType);
// ЗАПРОС
            if (log.isTraceEnabled()) {
                dumpRequest(req);
            }

            log.debug("Send soap request, wait response, id:" + req.getHeader().getIntegrationID());
            resp = ss.getPort().createPolicy(req);           // запрос к серверу
            log.debug("soap response id:" + resp.getHeader().getIntegrationID() + " Status:" + resp.getHeader().getResultInfo().getStatus());
            if (log.isTraceEnabled()) {
                dumpResponse(resp);
            }

            if (resp.getHeader().getResultInfo().getStatus().equals("OK")) {
                String accountNumber = resp.getAccountNumber();
                String policyNumber = resp.getPolicyNumber();
                BigDecimal totalPremium = resp.getTotalPremium();
                tgbot.sendText(user.getChatId(), String.format(msg, accountNumber, policyNumber, totalPremium));
                Future<GetPaymentLinkResponseType> answer = tgGetPaymentLink.getResponse(tgbot, user, policyNumber, totalPremium);
            } else {
                String status = resp.getHeader().getResultInfo().getStatus();
                String descr = resp.getHeader().getResultInfo().getErrorInfo().getDescr();
                String descr2 = resp.getHeader().getResultInfo().getNativeErrorInfo().getDescr();
                log.error("Error on CreatePolicy: Status=[" + status + "] description:[" + descr + "]");
                if (tgbot != null)
                    tgbot.sendText(user.getChatId(), "Получены ошибки от сервера, проверьте данные запроса (" + descr + ")(" + descr2 + ")");
            }
            // return new AsyncResult<User>(results);
        } catch (Exception e) {
            tgbot.sendText(user.getChatId(), "Ошибки при запросе к серверу:" + e.getMessage());
            e.printStackTrace();
        }
        log.debug("end request");
        return new AsyncResult<CreatePolicyResponseType>(resp);
    }

    /**
     * Запрос на создание полиса
     *
     * @param user
     * @return
     * @throws ParseException
     * @throws NullPointerException
     */
    private CreatePolicyRequestType createRequest(User user, HolidayType holidayType) throws ParseException, NullPointerException, DatatypeConfigurationException {

        CreatePolicyRequestType req = new CreatePolicyRequestType();

        if (hdr == null) log.error("hdr is NULL!");
        req.setHeader(hdr.getHeader());
        req.setProductName("PartnerTravelV2Box");

        TgProductOptions po = new TgProductOptions();
        req.setProductOptions(po.getProductOptions(user, holidayType));

        for (String key : user.getEnsured().keySet()) {
            if (key.startsWith("1")) {
                ClientInfoType cli = TgClientInfo.getAdultInfo(user, user.getEnsured().get(key));
                log.trace("add client ADULT:" + cli.getLastNameEng());
                req.getClientInfo().add(cli);
            } else if (key.startsWith("2")) {    // senior
                ClientInfoType cli = TgClientInfo.getSeniorInfo(user.getEnsured().get(key));
                log.trace("add client SENIOR:" + cli.getLastNameEng());
                req.getClientInfo().add(cli);
            } else if (key.startsWith("3")) {    //child
                ClientInfoType cli = TgClientInfo.getChildInfo(user.getEnsured().get(key));
                log.trace("add client CHILD:" + cli.getLastNameEng());
                req.getClientInfo().add(cli);
            }
        }

        req.setDeliveryMethod(DeliveryMethodType.EMAIL);
        req.setPaymentMethod(PaymentMethodType.NONE);

        return req;
    }

     private void dumpRequest(CreatePolicyRequestType req) {
        try {
            JAXBContext context = JAXBContext.newInstance(ru.toi.esb.model.servicemessagesext.CreatePolicyRequestType.class);
            Marshaller marshaller = context.createMarshaller();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            marshaller.marshal(new JAXBElement<CreatePolicyRequestType>(new QName("http://toi.ru/esb/model/serviceMessagesExt", "createPolicyRequest"), CreatePolicyRequestType.class, req), os);
            log.trace(">>>\n" + os.toString("UTF8") + "\n<<<<");
        }
          catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void dumpResponse(CreatePolicyResponseType resp) {
        try {
            JAXBContext context = JAXBContext.newInstance(ru.toi.esb.model.servicemessagesext.CreatePolicyResponseType.class);
            Marshaller marshaller = context.createMarshaller();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            marshaller.marshal(new JAXBElement<CreatePolicyResponseType>(new QName("http://toi.ru/esb/model/serviceMessagesExt", "createPolicyResponse"), CreatePolicyResponseType.class, resp), os);
            log.trace(">>>\n" + os.toString("UTF8") + "\n<<<<");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}