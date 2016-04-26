package mvn.tgBot.soap;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.utils.CheckDates;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import ru.toi.esb.model.servicemessagesext.CalcQuoteRequestType;
import ru.toi.esb.model.servicemessagesext.CalcQuoteResponseType;
import ru.toi.model.gw.quote.QuoteType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
@Service
public class TgCalcQuote {
    private Log log = LogFactory.getLog(TgCalcQuote.class);

    private static String tgMessage1="Страховка для спокойного отдыха "+"\ud83c\udf34"+" без занятий спортом за %.0f рублей";
    private static String tgMessage2="Страховка для активного отдыха "+"\ud83d\udeb4" +" (например, с велопрогулками) за %.0f рублей";
    private static String tgMessage3="Страховка для активного отдыха включая опасные виды спорта "+"\ud83c\udfc2"+" (например, горные лыжи или дайвинг) за %.0f рублей";
    private static String tgMessage = "Итоговая стоимость полиса с учетом выбранных опций %.0f рублей";


    @Autowired
    TgMessageHeader hdr;
    @Autowired
    TgSoapService ss;

    @Value("${soap.prodName}")
    String prodName;


    public TgCalcQuote() {
//        ss = new TgSoapService();
        log.debug("web-service created");
    }

    /**
     *  Асинхронный запрос - получение расчета стоимости полиса
     * @param tgbot
     * @param user
     * @param holidayType
     * @param lastCalc
     * @return
     */
    @Async
    public Future<QuoteType> getResponse(Messenger tgbot, User user, HolidayType holidayType, boolean lastCalc ) {  // true - это расчет стоимости

        // шаблон для строки с сообщением о стоимости
        log.debug("Calc quote holiday type:"+holidayType);
        String outFormat;
        if(!lastCalc) {
            if (holidayType == HolidayType.ACTIVE) outFormat = tgMessage2;
            else if (holidayType == HolidayType.DANGEROUS) outFormat = tgMessage3;
            else outFormat = tgMessage1;
        } else outFormat = tgMessage;

        CalcQuoteRequestType req = null;  //exception !
        QuoteType quoteAnswer= null;
        try {
            req = createRequest(user,holidayType);

// ЗАПРОС
               if (log.isTraceEnabled()) {
                   dumpRequest(req);
               }
               log.debug("SOAP request, wait response...id:" + req.getHeader().getIntegrationID());
               CalcQuoteResponseType hndl = ss.getPort().calcQuote(req);           // запрос к серверу
               log.debug("SOAP response id:" + hndl.getHeader().getIntegrationID() + " Status:" + hndl.getHeader().getResultInfo().getStatus());
               if (log.isTraceEnabled()) {
                   dumpResponse(hndl);
               }

// формирование сообщения со стоимостью
        CheckDates checkDates = new CheckDates();

        quoteAnswer = hndl.getQuote();
        if(quoteAnswer!= null) {
            Long chatId = user.getChatId();
            Long diff = null;
            try {
                diff = checkDates.diffDays(user.getDateFrom(), user.getDateTo());
            } catch (ParseException e) {
                diff = 0L;
            }
            StringBuffer userList = new StringBuffer();
            HashMap<String, EnsuredType> es = user.getEnsured();
            if (es != null) {
                for (String key : es.keySet()) {
                    EnsuredType us = es.get(key);
                    userList.append(us.getLastName() + ", " + us.getFirstName() + ", " + us.getBirthday() + ", " + us.getPasport() + "\n");
                }
            }
            else userList.append("?");
// сделать сообщение по шаблону
            String outMessage = String.format(outFormat, quoteAnswer.getTotalCost() );
            log.debug(outMessage);
            if(tgbot!=null) tgbot.sendText(chatId, outMessage);  // отправить сообщение
        }
        else {
            String status = hndl.getHeader().getResultInfo().getStatus();
            String descr = hndl.getHeader().getResultInfo().getErrorInfo().getDescr();
            log.error("Error on CalcQuote: Status=["+status+"] descr:["+descr+"]");
            if(tgbot!=null) tgbot.sendText(user.getChatId(),"Получены ошибки от сервера, проверьте данные запроса ("+descr+")");
        }
        // return new AsyncResult<User>(results);
        } catch (ParseException e) {
            tgbot.sendText(user.getChatId(),"Ошибки в данных или недостаточно данных для расчета ....");
            e.printStackTrace();
        }
        log.debug("end request");

        return new AsyncResult<QuoteType>(quoteAnswer);
    }

    /**
     *  Создать запрос на подсчет стоимости
     * @param user
     * @return
     * @throws ParseException
     * @throws java.lang.NullPointerException
     */
    private synchronized CalcQuoteRequestType createRequest(User user, HolidayType holidayType) throws ParseException, java.lang.NullPointerException {

        CalcQuoteRequestType req = new CalcQuoteRequestType();

        if (hdr == null) log.error("hdr is NULL!");
        req.setHeader(hdr.getHeader());
        req.setProductName(prodName);

        TgProductOptions po = new TgProductOptions();
        req.setProductOptions(po.getProductOptions(user,holidayType));
        return req;
    }

private void dumpRequest(CalcQuoteRequestType req) {
    try {
        JAXBContext context = JAXBContext.newInstance(ru.toi.esb.model.servicemessagesext.CalcQuoteRequestType.class);
        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(new JAXBElement<CalcQuoteRequestType>(new QName("http://toi.ru/esb/model/serviceMessagesExt","calcQuoteRequest"), CalcQuoteRequestType.class, req), os);
        log.trace(">>>\n"+os.toString("UTF8")+"\n<<<<");
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
}
private void dumpResponse(CalcQuoteResponseType resp) {
    try {
        JAXBContext context = JAXBContext.newInstance(ru.toi.esb.model.servicemessagesext.CalcQuoteResponseType.class);
        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(new JAXBElement<CalcQuoteResponseType>(new QName("http://toi.ru/esb/model/serviceMessagesExt","calcQuoteResponse"), CalcQuoteResponseType.class, resp), os);
        log.trace(">>>\n"+os.toString("UTF8")+"\n<<<<");
    } catch (JAXBException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

}

}
