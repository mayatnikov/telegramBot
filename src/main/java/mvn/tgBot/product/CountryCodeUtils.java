package mvn.tgBot.product;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.toi.model.productinfo.DisplaibleValueType;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryCodeUtils implements CommandLineRunner {
    private static Log log = LogFactory.getLog(CountryCodeUtils.class);


    @Autowired
    ProductInfoRepository db;
    @Autowired
    CountryCodeRepository db2;

    ProductInfo pi;

    List<CountryCode> countryList;

    public void run(String... args) throws Exception {
        log.info("start of bean creation");
        pi = db.findById("A001");
        if (pi != null) {
            log.debug("Country code for product:" + pi.getRegName());
            updateCountryCode();
            log.info("end of bean creation");
        } else log.error("Country code array not initialized!");
    }

    /**
     * поиск кода страны в справочнике
     * @param checkName название страны
     * @return код страны
     */

    public String checkCountry (String checkName) {
        String retCode = null;
        for(CountryCode c1: countryList ) {
            if( c1.getName().contains(checkName.toUpperCase()) ) {    //.equals(checkName.toUpperCase())) {
               retCode =c1.getCountryCode();
            }
        }
        return retCode;
    }


    public void updateCountryCode() {

        if(countryList == null) countryList = new ArrayList<CountryCode>();

        List<DisplaibleValueType> lst  =
                pi.getProduct().getOption().get(0).getOption().get(0).getValueInfo().get(0).getAvailableValue();
       int tik=0;
        log.debug("Country code table size="+lst.size());
        for( DisplaibleValueType cv: lst ) {
//            log.trace((tik++)+") code:"+cv.getValue()+" name:"+cv.getDisplay());
            CountryCode co =  new CountryCode(cv.getValue(),cv.getValue(),cv.getDisplay());
            countryList.add(co);
            db2.save(co);
        }
    }
}
