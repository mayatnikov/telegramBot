
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WindowsType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WindowsType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="wooden_frames"/>
 *     &lt;enumeration value="aluminum"/>
 *     &lt;enumeration value="wood"/>
 *     &lt;enumeration value="plastic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WindowsType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum WindowsTypeType {


    /**
     * Деревянные рамы
     * 
     */
    @XmlEnumValue("wooden_frames")
    WOODEN_FRAMES("wooden_frames"),

    /**
     * Стеклопакеты алюминий
     * 
     */
    @XmlEnumValue("aluminum")
    ALUMINUM("aluminum"),

    /**
     * Стеклопакеты дерево
     * 
     */
    @XmlEnumValue("wood")
    WOOD("wood"),

    /**
     * Стеклопакеты пластик
     * 
     */
    @XmlEnumValue("plastic")
    PLASTIC("plastic");
    private final String value;

    WindowsTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WindowsTypeType fromValue(String v) {
        for (WindowsTypeType c: WindowsTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
