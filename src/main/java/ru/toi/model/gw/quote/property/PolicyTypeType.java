
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PolicyType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aptLoft"/>
 *     &lt;enumeration value="townhouse"/>
 *     &lt;enumeration value="building"/>
 *     &lt;enumeration value="condominium"/>
 *     &lt;enumeration value="room"/>
 *     &lt;enumeration value="non_residential"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PolicyType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum PolicyTypeType {


    /**
     * Apartment/Loft
     * 
     */
    @XmlEnumValue("aptLoft")
    APT_LOFT("aptLoft"),

    /**
     * Townhouse
     * 
     */
    @XmlEnumValue("townhouse")
    TOWNHOUSE("townhouse"),

    /**
     * Building
     * 
     */
    @XmlEnumValue("building")
    BUILDING("building"),

    /**
     * Condominium
     * 
     */
    @XmlEnumValue("condominium")
    CONDOMINIUM("condominium"),

    /**
     * Комната
     * 
     */
    @XmlEnumValue("room")
    ROOM("room"),

    /**
     * Нежилое помещение
     * 
     */
    @XmlEnumValue("non_residential")
    NON_RESIDENTIAL("non_residential");
    private final String value;

    PolicyTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PolicyTypeType fromValue(String v) {
        for (PolicyTypeType c: PolicyTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
