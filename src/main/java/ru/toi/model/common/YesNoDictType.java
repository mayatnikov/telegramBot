
package ru.toi.model.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for YesNoDict_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="YesNoDict_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="yes"/>
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="dontknow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "YesNoDict_Type")
@XmlEnum
public enum YesNoDictType {


    /**
     * Yes
     * 
     */
    @XmlEnumValue("yes")
    YES("yes"),

    /**
     * No
     * 
     */
    @XmlEnumValue("no")
    NO("no"),

    /**
     * Don't know
     * 
     */
    @XmlEnumValue("dontknow")
    DONTKNOW("dontknow");
    private final String value;

    YesNoDictType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static YesNoDictType fromValue(String v) {
        for (YesNoDictType c: YesNoDictType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
