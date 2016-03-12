
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingCompleteProgress_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BuildingCompleteProgress_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="presence"/>
 *     &lt;enumeration value="notpresence"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BuildingCompleteProgress_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum BuildingCompleteProgressType {


    /**
     * Незавершенное строительство (в наличии фундамент, стены, крыша, окна, двери
     * 
     */
    @XmlEnumValue("presence")
    PRESENCE("presence"),

    /**
     * Незавершенное строительство (нет хотя бы одного из элементов: фундамент, стены, крыша, окна, двери)
     * 
     */
    @XmlEnumValue("notpresence")
    NOTPRESENCE("notpresence");
    private final String value;

    BuildingCompleteProgressType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BuildingCompleteProgressType fromValue(String v) {
        for (BuildingCompleteProgressType c: BuildingCompleteProgressType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
