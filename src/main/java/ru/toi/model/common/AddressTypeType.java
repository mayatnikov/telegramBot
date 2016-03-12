
package ru.toi.model.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Billing"/>
 *     &lt;enumeration value="Business"/>
 *     &lt;enumeration value="Home"/>
 *     &lt;enumeration value="Post"/>
 *     &lt;enumeration value="Property"/>
 *     &lt;enumeration value="Registration"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressType_Type")
@XmlEnum
public enum AddressTypeType {


    /**
     * Адрес доставки Billing
     * 
     */
    @XmlEnumValue("Billing")
    BILLING("Billing"),

    /**
     * Адрес фактического местонахождения Business
     * 
     */
    @XmlEnumValue("Business")
    BUSINESS("Business"),

    /**
     * Адрес фактического проживания Home
     * 
     */
    @XmlEnumValue("Home")
    HOME("Home"),

    /**
     * Адрес почтового отправления Post
     * 
     */
    @XmlEnumValue("Post")
    POST("Post"),

    /**
     * Адрес имущества Property
     * 
     */
    @XmlEnumValue("Property")
    PROPERTY("Property"),

    /**
     * Адрес регистрации Registration
     * 
     */
    @XmlEnumValue("Registration")
    REGISTRATION("Registration");
    private final String value;

    AddressTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressTypeType fromValue(String v) {
        for (AddressTypeType c: AddressTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
