
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypePrimaryPhone_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TypePrimaryPhone_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MOBILE_MAIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TypePrimaryPhone_Type")
@XmlEnum
public enum TypePrimaryPhoneType {


    /**
     * ???
     * 
     */
    MOBILE_MAIN;

    public String value() {
        return name();
    }

    public static TypePrimaryPhoneType fromValue(String v) {
        return valueOf(v);
    }

}
