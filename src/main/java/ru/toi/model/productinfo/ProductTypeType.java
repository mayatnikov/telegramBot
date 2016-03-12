
package ru.toi.model.productinfo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProductType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRAVEL"/>
 *     &lt;enumeration value="PROPERTY"/>
 *     &lt;enumeration value="ACCIDENT"/>
 *     &lt;enumeration value="OSAGO"/>
 *     &lt;enumeration value="CASCO"/>
 *     &lt;enumeration value="TRAVEL_V2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProductType_Type")
@XmlEnum
public enum ProductTypeType {


    /**
     * 
     *     					Страхование при поездках
     *     				
     * 
     */
    TRAVEL("TRAVEL"),

    /**
     * 
     *     					Страхование недвижимого имущества
     *     				
     * 
     */
    PROPERTY("PROPERTY"),

    /**
     * 
     *     					Страхование жизни и здоровья
     *     				
     * 
     */
    ACCIDENT("ACCIDENT"),

    /**
     * 
     *     					Страхование ОСАГО
     *     				
     * 
     */
    OSAGO("OSAGO"),

    /**
     * 
     *     					Страхование КАСКО
     *     				
     * 
     */
    CASCO("CASCO"),
    @XmlEnumValue("TRAVEL_V2")
    TRAVEL_V_2("TRAVEL_V2");
    private final String value;

    ProductTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductTypeType fromValue(String v) {
        for (ProductTypeType c: ProductTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
