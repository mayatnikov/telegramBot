
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeatedFloorType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HeatedFloorType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="water"/>
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="electric"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HeatedFloorType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum HeatedFloorTypeType {


    /**
     * Водяной
     * 
     */
    @XmlEnumValue("water")
    WATER("water"),

    /**
     * Нет
     * 
     */
    @XmlEnumValue("no")
    NO("no"),

    /**
     * Электрический
     * 
     */
    @XmlEnumValue("electric")
    ELECTRIC("electric");
    private final String value;

    HeatedFloorTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HeatedFloorTypeType fromValue(String v) {
        for (HeatedFloorTypeType c: HeatedFloorTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
