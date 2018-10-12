package mvn.tgBot.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.xxx.esb.model.servicemessagesext.CalcQuoteRequestType;
import ru.xxx.model.productinfo.ProductOptionType;
import ru.xxx.model.productinfo.ProductOptionsType;
import ru.xxx.model.productinfo.ValueInfoType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
@Component
public class CreateQuoteReq {
    private Log log = LogFactory.getLog(CreateQuoteReq.class);

@Autowired
TgMessageHeader hdr;

    @Value("${soap.prodName}")
    String prodName;


    public CreateQuoteReq() {
        log.debug("created");
    }


    public  CalcQuoteRequestType  getQUote() {
        CalcQuoteRequestType req =new CalcQuoteRequestType();

        if(hdr==null) log.error("hdr is NULL!");
        req.setHeader(hdr.getHeader());
        req.setProductName(prodName);
        req.setProductOptions(new ProductOptionsType());

        List <ProductOptionType> optionList = req.getProductOptions().getOption();
        {
            ProductOptionType quoteReqOption = new ProductOptionType();
            quoteReqOption.setCode("QuoteRequest");
            optionList.add(quoteReqOption);
            List<ValueInfoType> valInfoList = quoteReqOption.getValueInfo();
            {
                addValueInfo(valInfoList, "AssistanceLevel", "Basic");
                addValueInfo(valInfoList, "Area", "shengen");
                addValueInfo(valInfoList, "QuantityChildren", "0");
                addValueInfo(valInfoList, "QuantityAdults", "1");
                addValueInfo(valInfoList, "QuantitySeniors", "0");
                addValueInfo(valInfoList, "Currency", "eur");
            }
            {
                List<ProductOptionType> valOptionList = quoteReqOption.getOption();
                ProductOptionType coveragesOpt = new ProductOptionType();
                coveragesOpt.setCode("Coverages");
                valOptionList.add(coveragesOpt);
                {
                    List<ProductOptionType> coverOptionList = coveragesOpt.getOption();
                    ProductOptionType medicOpt = new ProductOptionType();
                    medicOpt.setCode("TravelMedicine");
                    {
                        List<ValueInfoType> valInfoMedic = medicOpt.getValueInfo();
                        addValueInfo(valInfoMedic, "TravelMedicineLimit", "15000");
                    }
                    coverOptionList.add(medicOpt);
                    addOptionCode(coverOptionList, "TripOptions");
                    addOptionCode(coverOptionList, "TripOptionsRet");
                    addOptionCode(coverOptionList, "JuridicalHelp");
                    addOptionCode(coverOptionList, "DocumentsLoss");
                    addOptionCode(coverOptionList, "Luggage");
// TheftProperty
                    ProductOptionType TheftPropertyOpt = new ProductOptionType();
                    TheftPropertyOpt.setCode("TheftProperty");
                    coverOptionList.add(TheftPropertyOpt);
                    {
                        List<ValueInfoType> valTheftProperty = TheftPropertyOpt.getValueInfo();
                        addValueInfo(valTheftProperty, "PropertyLimit", "15000");
                        addValueInfo(valTheftProperty, "PropertyAddress", "Any address 27");
                    }
                    addOptionCode(coverOptionList, "PhotoVideo");
                    addOptionCode(coverOptionList, "SportEquipment");
// CivilLiability
                    ProductOptionType CivilLiabilityOpt = new ProductOptionType();
                    CivilLiabilityOpt.setCode("CivilLiability");
                    coverOptionList.add(CivilLiabilityOpt);
                    {
                        List<ValueInfoType> CivilLiabilityList = CivilLiabilityOpt.getValueInfo();
                        addValueInfo(CivilLiabilityList, "CivilLiabilityLimit", "2700");
                    }
// PersonalAccident
                    ProductOptionType PersonalAccidentOpt = new ProductOptionType();
                    PersonalAccidentOpt.setCode("PersonalAccident");
                    coverOptionList.add(PersonalAccidentOpt);
                    {
                        List<ValueInfoType> PersonalAccidentList = PersonalAccidentOpt.getValueInfo();
                        addValueInfo(PersonalAccidentList, "PersonalAccidentLimit", "17000");
                    }
                }
// LeisureType
                ProductOptionType LeisureTypeOpt = new ProductOptionType();
                LeisureTypeOpt.setCode("LeisureType");
                valOptionList.add(LeisureTypeOpt);
                {
                    List<ProductOptionType> leisureTypeOptionList = quoteReqOption.getOption();
                    addOptionCode(leisureTypeOptionList,"ActiveLeisure");
                }
//  TripDuration
                ProductOptionType tripDurationOpt = new ProductOptionType();
                tripDurationOpt.setCode("TripDuration");
                valOptionList.add(tripDurationOpt);
                {
                    List <ProductOptionType>  tripDurationOptList = tripDurationOpt.getOption();
                    {
                        ProductOptionType  tripDurationOptOpt = new ProductOptionType();
                        tripDurationOptOpt.setCode("SingleTrip");
                        tripDurationOptList.add(tripDurationOptOpt);
                        {
                            List<ValueInfoType> tripDates = tripDurationOptOpt.getValueInfo();
                            addValueInfo(tripDates, "TripStartDate", "2016-08-23T00:00:00+03:00");
                            addValueInfo(tripDates, "TripEndDate", "2016-09-23T00:00:00+03:00");
                        }
                    }
                }
// Country
                ProductOptionType countryOpt = new ProductOptionType();
                countryOpt.setCode("Country");
                valOptionList.add(countryOpt);
                {
                    List<ValueInfoType> countryList = countryOpt.getValueInfo();
                    addValueInfo(countryList, "Country", "RU");
                    addValueInfo(countryList, "Country", "AR");
                    addValueInfo(countryList, "Country", "GV");
                }
            }
        }
        return req;
    }

    private void addValueInfo(List<ValueInfoType> lst,String code,String val) {
        ValueInfoType valueInfo = new ValueInfoType();
        valueInfo.setCode(code);
        valueInfo.setValue(val);  // <---- SET
        lst.add(valueInfo);
    }
    private void addOptionCode(List<ProductOptionType> lst,String code) {
        ProductOptionType opt1 = new ProductOptionType();
        opt1.setCode(code);
        lst.add(opt1);
    }
}
