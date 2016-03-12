
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingSeriesType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BuildingSeriesType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="block"/>
 *     &lt;enumeration value="brezhnevka"/>
 *     &lt;enumeration value="individual"/>
 *     &lt;enumeration value="monolith-brick"/>
 *     &lt;enumeration value="panel"/>
 *     &lt;enumeration value="stalinka"/>
 *     &lt;enumeration value="khruschevkas"/>
 *     &lt;enumeration value="dontknow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BuildingSeriesType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum BuildingSeriesTypeType {


    /**
     * Блочный
     * 
     */
    @XmlEnumValue("block")
    BLOCK("block"),

    /**
     * Брежневка
     * 
     */
    @XmlEnumValue("brezhnevka")
    BREZHNEVKA("brezhnevka"),

    /**
     * Индивидуальный
     * 
     */
    @XmlEnumValue("individual")
    INDIVIDUAL("individual"),

    /**
     * Монолит-кирпич
     * 
     */
    @XmlEnumValue("monolith-brick")
    MONOLITH_BRICK("monolith-brick"),

    /**
     * Панель
     * 
     */
    @XmlEnumValue("panel")
    PANEL("panel"),

    /**
     * Сталинка
     * 
     */
    @XmlEnumValue("stalinka")
    STALINKA("stalinka"),

    /**
     * Хрущевка
     * 
     */
    @XmlEnumValue("khruschevkas")
    KHRUSCHEVKAS("khruschevkas"),

    /**
     * Не знаю
     * 
     */
    @XmlEnumValue("dontknow")
    DONTKNOW("dontknow");
    private final String value;

    BuildingSeriesTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BuildingSeriesTypeType fromValue(String v) {
        for (BuildingSeriesTypeType c: BuildingSeriesTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
