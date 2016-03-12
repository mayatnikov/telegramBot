
package ru.toi.model.productinfo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValueInfoType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValueInfoType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LIST"/>
 *     &lt;enumeration value="DATETIME"/>
 *     &lt;enumeration value="DECIMAL"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="STRING"/>
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="XID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValueInfoType_Type")
@XmlEnum
public enum ValueInfoTypeType {


    /**
     * Список допустимых значений
     * 
     */
    LIST,

    /**
     * Дата + время в формате yyyy-MM-ddTHH:mm:ssZ
     * 
     */
    DATETIME,

    /**
     * Decimal число
     * 
     */
    DECIMAL,

    /**
     * Целочисленное значение
     * 
     */
    INT,

    /**
     * Строковое значение
     * 
     */
    STRING,

    /**
     * Boolean значение
     * 
     */
    BOOLEAN,

    /**
     * Технический идентификатор
     * 
     */
    XID;

    public String value() {
        return name();
    }

    public static ValueInfoTypeType fromValue(String v) {
        return valueOf(v);
    }

}
