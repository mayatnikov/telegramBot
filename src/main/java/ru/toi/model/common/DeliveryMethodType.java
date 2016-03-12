
package ru.toi.model.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryMethod_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryMethod_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Mail"/>
 *     &lt;enumeration value="SMS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryMethod_Type")
@XmlEnum
public enum DeliveryMethodType {


    /**
     * Email
     * 
     */
    @XmlEnumValue("Email")
    EMAIL("Email"),

    /**
     * Mail
     * 
     */
    @XmlEnumValue("Mail")
    MAIL("Mail"),

    /**
     * SMS
     * 
     */
    SMS("SMS");
    private final String value;

    DeliveryMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeliveryMethodType fromValue(String v) {
        for (DeliveryMethodType c: DeliveryMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
