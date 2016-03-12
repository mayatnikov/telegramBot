
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TermType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TermType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Annual"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TermType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum TermTypeType {


    /**
     * Annual
     * 
     */
    @XmlEnumValue("Annual")
    ANNUAL("Annual"),

    /**
     * Monthly
     * 
     */
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),

    /**
     * Other
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    TermTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TermTypeType fromValue(String v) {
        for (TermTypeType c: TermTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
