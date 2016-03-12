
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductCode_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProductCode_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TPTinkoffProperty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProductCode_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum ProductCodeType {


    /**
     * ???
     * 
     */
    @XmlEnumValue("TPTinkoffProperty")
    TP_TINKOFF_PROPERTY("TPTinkoffProperty");
    private final String value;

    ProductCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductCodeType fromValue(String v) {
        for (ProductCodeType c: ProductCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
