
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WallsType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WallsType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="blocks"/>
 *     &lt;enumeration value="wood"/>
 *     &lt;enumeration value="wood_brick"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="brick"/>
 *     &lt;enumeration value="monolith"/>
 *     &lt;enumeration value="panel"/>
 *     &lt;enumeration value="dontknow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WallsType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum WallsTypeType {


    /**
     * Блоки	Каменный
     * 
     */
    @XmlEnumValue("blocks")
    BLOCKS("blocks"),

    /**
     * Дерево	Деревянный
     * 
     */
    @XmlEnumValue("wood")
    WOOD("wood"),

    /**
     * Дерево, кирпич	Смешанный
     * 
     */
    @XmlEnumValue("wood_brick")
    WOOD_BRICK("wood_brick"),

    /**
     * Иное	
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Кирпич	Каменный
     * 
     */
    @XmlEnumValue("brick")
    BRICK("brick"),

    /**
     * Монолит	Каменный
     * 
     */
    @XmlEnumValue("monolith")
    MONOLITH("monolith"),

    /**
     * Панель	Каменный
     * 
     */
    @XmlEnumValue("panel")
    PANEL("panel"),

    /**
     * Не знаю
     * 
     */
    @XmlEnumValue("dontknow")
    DONTKNOW("dontknow");
    private final String value;

    WallsTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WallsTypeType fromValue(String v) {
        for (WallsTypeType c: WallsTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
