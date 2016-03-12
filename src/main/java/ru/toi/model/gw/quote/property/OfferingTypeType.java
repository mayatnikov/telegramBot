
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfferingType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OfferingType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TPComplex_TOI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OfferingType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum OfferingTypeType {


    /**
     * Complex Product
     * 
     */
    @XmlEnumValue("TPComplex_TOI")
    TP_COMPLEX_TOI("TPComplex_TOI");
    private final String value;

    OfferingTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OfferingTypeType fromValue(String v) {
        for (OfferingTypeType c: OfferingTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
