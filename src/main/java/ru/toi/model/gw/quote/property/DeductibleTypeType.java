
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeductibleType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeductibleType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Percentage_TOI"/>
 *     &lt;enumeration value="Amount_TOI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeductibleType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum DeductibleTypeType {


    /**
     * Percentage
     * 
     */
    @XmlEnumValue("Percentage_TOI")
    PERCENTAGE_TOI("Percentage_TOI"),

    /**
     * Amount
     * 
     */
    @XmlEnumValue("Amount_TOI")
    AMOUNT_TOI("Amount_TOI");
    private final String value;

    DeductibleTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeductibleTypeType fromValue(String v) {
        for (DeductibleTypeType c: DeductibleTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
