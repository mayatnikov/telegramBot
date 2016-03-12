
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdjustmentType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdjustmentType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="amount"/>
 *     &lt;enumeration value="percentage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdjustmentType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum AdjustmentTypeType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("amount")
    AMOUNT("amount"),
    @XmlEnumValue("percentage")
    PERCENTAGE("percentage");
    private final String value;

    AdjustmentTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdjustmentTypeType fromValue(String v) {
        for (AdjustmentTypeType c: AdjustmentTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
