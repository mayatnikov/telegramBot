package mvn.tgBot.soap;

import mvn.tgBot.db.HolidayType;
import mvn.tgBot.db.User;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.toi.model.productinfo.ProductOptionType;
import ru.toi.model.productinfo.ProductOptionsType;
import ru.toi.model.productinfo.ValueInfoType;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 05/03/16
 * Time: 09:21
 */
public class TgProductOptions {

    private Log log = LogFactory.getLog(TgProductOptions.class);

    public TgProductOptions() {
        log.debug("CalcQute soap service - created");
    }


    ProductOptionsType getProductOptions(User us, HolidayType holidayType) throws ParseException {

        ProductOptionsType retOpt = new ProductOptionsType();

        Pot quoteReq = new Pot(retOpt,"QuoteRequest");
//        Pot assLvl = new Pot(quoteReq,"AssistanceLevel");
        log.trace("Area="+us.getRegionType().toString().toLowerCase());
        quoteReq.addValInfo( "AssistanceLevel", "Basic")
                .addValInfo("Area", us.getRegionType().toString().toLowerCase())
                .addValInfo( "QuantityChildren", "" + us.getChildNumber())
                .addValInfo( "QuantityAdults", "" + us.getEnsuredNumber())
                .addValInfo( "QuantitySeniors", "" + us.getOldNumber())
                .addValInfo( "Currency", "eur");
        Pot coverages = new Pot(quoteReq,"Coverages");
        Pot medicOpt = new Pot(coverages,"TravelMedicine");
        medicOpt.addValInfo("TravelMedicineLimit", "30000");
// APARTMENT, ACCIDENT, BAGGAGE, TRIPCANCEL
// TheftProperty     страхование квартиры
        if (us.getEnsuranceOpt1() != null) {      // квартира
            (new Pot(coverages,"TheftProperty"))
                    .addValInfo( "PropertyLimit", "15000")
                    .addValInfo( "PropertyAddress", us.getAddress1());
        }
// PersonalAccident
        if (us.getEnsuranceOpt2() != null) {
            (new Pot(coverages,"PersonalAccident"))
                    .addValInfo("PersonalAccidentLimit", "5000");              // 17000 5000 замечание
        }
        if (us.getEnsuranceOpt3() != null) {
            new Pot(coverages,"Luggage");
        }
        if (us.getEnsuranceOpt4() != null) {
            new Pot(coverages,"TripOptions");
        }  // отмена поездки

// LeisureType
        Pot leisure = new Pot(quoteReq,"LeisureType");
        if (holidayType == HolidayType.ACTIVE) {
            Pot pp = new Pot(leisure, "ActiveLeisure");
            pp.addValInfo("isActiveLeasure","true");
        }
        else if (holidayType == HolidayType.DANGEROUS){
            Pot pp =new Pot(leisure, "ActiveLeisure");
            pp.addValInfo("IsExtremeSport","true");
        }

//  TripDuration    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        Pot tripDuration = new Pot(quoteReq,"TripDuration");
        Pot singleTrip =new Pot(tripDuration, "SingleTrip");
        CheckDates utils = new CheckDates();
        Regexp regexp = new Regexp();
        String d1 = regexp.filterDate(us.getDateFrom());
        singleTrip
                .addValInfo("TripStartDate", utils.getUnixTimeStamp(regexp.filterDate(us.getDateFrom())))
                .addValInfo("TripEndDate", utils.getUnixTimeStamp(regexp.filterDate(us.getDateTo())));
// Country
        if(us.getRegionType() == null) {
            Pot countryList = new Pot(quoteReq, "Country");
// @TODO СДЕЛАТЬ ДОБАВЛЕНИЕ СПИСКА СТРАН С УЧЕТОМ СПРАВОЧНИКА ПО ПРОДУКТУ
            countryList.addValInfo("Country", "RU");
        }
    return retOpt;
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
            val1.setValue(val);
            this.getValueInfo().add(val1);
            return this;
        }
    }


}
