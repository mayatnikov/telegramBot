
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiscontType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DiscontType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="percentage"/>
 *     &lt;enumeration value="amount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiscontType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum DiscontTypeType {


    /**
     * Отсутствует
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * Скидка в процентах
     * 
     */
    @XmlEnumValue("percentage")
    PERCENTAGE("percentage"),

    /**
     * Фиксированная скидка
     * 
     */
    @XmlEnumValue("amount")
    AMOUNT("amount");
    private final String value;

    DiscontTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiscontTypeType fromValue(String v) {
        for (DiscontTypeType c: DiscontTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
