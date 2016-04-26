package mvn.tgBot.soap;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.db.UserRepository;
import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import ru.toi.esb.model.servicemessagesext.CalcQuoteRequestType;
import ru.toi.esb.model.servicemessagesext.CalcQuoteResponseType;
import ru.toi.model.gw.quote.QuoteType;
import ru.toi.model.productinfo.ProductOptionType;
import ru.toi.model.productinfo.ProductOptionsType;
import ru.toi.model.productinfo.ValueInfoType;

import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
// @Service
public class TgCalcQuote_new {
    private Log log = LogFactory.getLog(TgCalcQuote_new.class);

    private static String tgMessage = "Давайте проверим:\n" +
            "«%s», «%s», «%s - %s», «на %d дней» \n" +
            "Страхователь: «%s», «%s», «%s %s», «%s %s»\n" +
            "Застрахованные:\n" +
            "%s\n" +
            "Страховое покрытие 30 000 EUR\n" +
            "Стоимость полиса %.2f рублей\n" +
            "Оплачиваем?";
    private static String[][] tgMenu = {
            {"все правильно"},
            {"есть ошибки"}
    };

    @Autowired
    TgMessageHeader hdr;

    @Autowired
    TgSoapService ss;

    @Value("${soap.prodName}")
    String prodName;


    public TgCalcQuote_new() {
        ss = new TgSoapService();
        log.debug("CalcQute soap service - created");
    }

    @Async
    public Future<QuoteType> getResponse(UserRepository db, Messenger tg, User user) {

        CalcQuoteRequestType req = null;  //exception !
        QuoteType quoteAnswer= null;
        try {
            req = createRequest(user);
          CalcQuoteResponseType hndl = ss.getPort().calcQuote(req);           // запрос к серверу

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
            String outMessage = String.format(tgMessage,
                    user.getPolicyType(),
                    user.getRegionType(),
                    user.getDateFrom(), user.getDateTo(), diff,
                    user.getUserName(),
                    user.getBirthday(), user.getPhone(), user.getEmail(), user.getAddress1(), user.getAddress2(),
                    userList.toString(),
                    quoteAnswer.getTotalCost()
            );
            log.debug(outMessage);
            if(tg!=null) tg.sendMenuON(chatId, outMessage, tgMenu);  // отправить сообщение
        }
        else {
            String status = hndl.getHeader().getResultInfo().getStatus();
            String descr = hndl.getHeader().getResultInfo().getErrorInfo().getDescr();
            log.error("Error on CalcQuote: Status=["+status+"] descr:["+descr+"]");
            if(tg!=null) tg.sendText(user.getChatId(),"Получены ошибки от сервера, проверьте данные запроса ("+descr+")");
        }
        // return new AsyncResult<User>(results);
        } catch (ParseException e) {
            tg.sendText(user.getChatId(),"Ошибки в данных или недостаточно данных для расчета ....");
            e.printStackTrace();
        }
        return new AsyncResult<QuoteType>(quoteAnswer);
    }
//@TODO это ужасно, переделать createRequest на иерархию классов
    private CalcQuoteRequestType createRequest(User user) throws ParseException, NullPointerException {

        CalcQuoteRequestType req = new CalcQuoteRequestType();

        if (hdr == null) log.error("hdr is NULL!");
        req.setHeader(hdr.getHeader());
        req.setProductName(prodName);
        ProductOptionsType p1 = new ProductOptionsType();
        req.setProductOptions(p1);

        Pot quoteReq = new Pot(req.getProductOptions(),"QuoteRequest");
            Pot assLvl = new Pot(quoteReq,"AssistanceLevel");
            assLvl.addValInfo( "AssistanceLevel", "Basic")
                .addValInfo("Area", user.getRegionType().toString().toLowerCase())
                .addValInfo( "QuantityChildren", "" + user.getChildNumber())
                .addValInfo( "QuantityAdults", "" + user.getEnsuredNumber())
                .addValInfo( "QuantitySeniors", "" + user.getOldNumber())
                .addValInfo( "Currency", "eur");
            Pot coverages = new Pot(quoteReq,"Coverages");
                Pot medicOpt = new Pot(coverages,"TravelMedicine");
                    medicOpt.addValInfo("TravelMedicineLimit", "30000");
// APARTMENT, ACCIDENT, BAGGAGE, TRIPCANCEL
// TheftProperty     страхование квартиры
                if (user.getEnsuranceOpt1() != null) {      // квартира
                    (new Pot(coverages,"TheftProperty"))
                      .addValInfo( "PropertyLimit", "15000")
                      .addValInfo( "PropertyAddress", user.getAddress1());
                }
// PersonalAccident
                if (user.getEnsuranceOpt2() != null) {
                     (new Pot(coverages,"PersonalAccident"))
                             .addValInfo("PersonalAccidentLimit", "17000");
                    }
                if (user.getEnsuranceOpt3() != null) {
                        new Pot(coverages,"Luggage");
                }
                if (user.getEnsuranceOpt4() != null) {
                        new Pot(coverages,"TripOptions");
                }  // отмена поездки

// LeisureType
            Pot leisure = new Pot(quoteReq,"LeisureType");
                if (user.getHolidayType() == HolidayType.ACTIVE)
                            new Pot(leisure, "ActiveLeisure");
                else if (user.getHolidayType() == HolidayType.DANGEROUS)
                            new Pot(leisure, "IsExtremeSport");
//  TripDuration    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
             Pot tripDuration = new Pot(quoteReq,"TripDuration");
                new Pot(tripDuration, "SingleTrip");
                CheckDates utils = new CheckDates();
                Regexp regexp = new Regexp();
                String d1 = regexp.filterDate(user.getDateFrom());
                tripDuration
                        .addValInfo("TripStartDate", utils.getUnixTimeStamp(regexp.filterDate(user.getDateFrom())))
                        .addValInfo("TripEndDate", utils.getUnixTimeStamp(regexp.filterDate(user.getDateTo())));
// Country
                    Pot countryList  = new Pot(quoteReq,"Country");
// @TODO СДЕЛАТЬ ДОБАВЛЕНИЕ СПИСКА СТРАН С УЧЕТОМ СПРАВОЧНИКА ПО ПРОДУКТУ
                    countryList .addValInfo( "Country", "RU");
        return req;
    }


// ---------------------
class Pot extends ProductOptionType {

    public Pot(ProductOptionsType parent, String code) {
        super();
        this.setCode(code);
        parent.getOption().add(this);
    }

    public Pot(Pot parent, String code) {
        super();
        this.setCode(code);
        parent.getOption().add(this);
    }


    public Pot addValInfo(String code, String val) {
        ValueInfoType val1 = new ValueInfoType();
        val1.setCode(code);
        this.getValueInfo().add(val1);
        return this;
    }
}


}
