//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.10 at 05:00:38 PM MSK 
//


package com.abbyy.result;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rotationTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rotationTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="noRotation"/>
 *     &lt;enumeration value="clockwise"/>
 *     &lt;enumeration value="counterclockwise"/>
 *     &lt;enumeration value="upsideDown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "rotationTypeEnum")
@XmlEnum
public enum RotationTypeEnum {

    @XmlEnumValue("noRotation")
    NO_ROTATION("noRotation"),
    @XmlEnumValue("clockwise")
    CLOCKWISE("clockwise"),
    @XmlEnumValue("counterclockwise")
    COUNTERCLOCKWISE("counterclockwise"),
    @XmlEnumValue("upsideDown")
    UPSIDE_DOWN("upsideDown");
    private final String value;

    RotationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RotationTypeEnum fromValue(String v) {
        for (RotationTypeEnum c: RotationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
