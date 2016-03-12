
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RedevelopmentType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RedevelopmentType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="not_obtained"/>
 *     &lt;enumeration value="obtained"/>
 *     &lt;enumeration value="no"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RedevelopmentType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum RedevelopmentTypeType {


    /**
     * Да, согласование не получено
     * 
     */
    @XmlEnumValue("not_obtained")
    NOT_OBTAINED("not_obtained"),

    /**
     * Да, согласование получено
     * 
     */
    @XmlEnumValue("obtained")
    OBTAINED("obtained"),

    /**
     * Нет
     * 
     */
    @XmlEnumValue("no")
    NO("no");
    private final String value;

    RedevelopmentTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RedevelopmentTypeType fromValue(String v) {
        for (RedevelopmentTypeType c: RedevelopmentTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
