
package ru.toi.model.gw.quote;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.toi.model.gw.quote package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetQuoteResponse_QNAME = new QName("http://toi.ru/model/gw/quote", "getQuoteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.toi.model.gw.quote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VehicleOSAGOQuoteInfoType }
     * 
     */
    public VehicleOSAGOQuoteInfoType createVehicleOSAGOQuoteInfoType() {
        return new VehicleOSAGOQuoteInfoType();
    }

    /**
     * Create an instance of {@link KBMInfoType }
     * 
     */
    public KBMInfoType createKBMInfoType() {
        return new KBMInfoType();
    }

    /**
     * Create an instance of {@link QuoteType }
     * 
     */
    public QuoteType createQuoteType() {
        return new QuoteType();
    }

    /**
     * Create an instance of {@link CoverageType }
     * 
     */
    public CoverageType createCoverageType() {
        return new CoverageType();
    }

    /**
     * Create an instance of {@link MotorQuoteType }
     * 
     */
    public MotorQuoteType createMotorQuoteType() {
        return new MotorQuoteType();
    }

    /**
     * Create an instance of {@link TechInspectionInfoType }
     * 
     */
    public TechInspectionInfoType createTechInspectionInfoType() {
        return new TechInspectionInfoType();
    }

    /**
     * Create an instance of {@link VehicleInfoType }
     * 
     */
    public VehicleInfoType createVehicleInfoType() {
        return new VehicleInfoType();
    }

    /**
     * Create an instance of {@link PersonKBMInfoType }
     * 
     */
    public PersonKBMInfoType createPersonKBMInfoType() {
        return new PersonKBMInfoType();
    }

    /**
     * Create an instance of {@link QuoteResponseType }
     * 
     */
    public QuoteResponseType createQuoteResponseType() {
        return new QuoteResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuoteResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/gw/quote", name = "getQuoteResponse")
    public JAXBElement<QuoteResponseType> createGetQuoteResponse(QuoteResponseType value) {
        return new JAXBElement<QuoteResponseType>(_GetQuoteResponse_QNAME, QuoteResponseType.class, null, value);
    }

}
