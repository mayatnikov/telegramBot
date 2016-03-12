
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConstructionType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConstructionType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="arbor"/>
 *     &lt;enumeration value="canopy"/>
 *     &lt;enumeration value="enclosure"/>
 *     &lt;enumeration value="fence"/>
 *     &lt;enumeration value="hole"/>
 *     &lt;enumeration value="landscape"/>
 *     &lt;enumeration value="pool"/>
 *     &lt;enumeration value="sanblok"/>
 *     &lt;enumeration value="septic"/>
 *     &lt;enumeration value="shower"/>
 *     &lt;enumeration value="utilities"/>
 *     &lt;enumeration value="water_tower"/>
 *     &lt;enumeration value="well"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConstructionType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum ConstructionTypeType {


    /**
     * Беседка
     * 
     */
    @XmlEnumValue("arbor")
    ARBOR("arbor"),

    /**
     * Навес
     * 
     */
    @XmlEnumValue("canopy")
    CANOPY("canopy"),

    /**
     * Ограда
     * 
     */
    @XmlEnumValue("enclosure")
    ENCLOSURE("enclosure"),

    /**
     * Забор
     * 
     */
    @XmlEnumValue("fence")
    FENCE("fence"),

    /**
     * Скважина
     * 
     */
    @XmlEnumValue("hole")
    HOLE("hole"),

    /**
     * Ландшафтные сооружения
     * 
     */
    @XmlEnumValue("landscape")
    LANDSCAPE("landscape"),

    /**
     * Бассейн
     * 
     */
    @XmlEnumValue("pool")
    POOL("pool"),

    /**
     * Санблок
     * 
     */
    @XmlEnumValue("sanblok")
    SANBLOK("sanblok"),

    /**
     * Септик
     * 
     */
    @XmlEnumValue("septic")
    SEPTIC("septic"),

    /**
     * Душ
     * 
     */
    @XmlEnumValue("shower")
    SHOWER("shower"),

    /**
     * Подземные коммуникации
     * 
     */
    @XmlEnumValue("utilities")
    UTILITIES("utilities"),

    /**
     * Водонапорная вышка
     * 
     */
    @XmlEnumValue("water_tower")
    WATER_TOWER("water_tower"),

    /**
     * Колодец
     * 
     */
    @XmlEnumValue("well")
    WELL("well"),

    /**
     * Другое
     * 
     */
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ConstructionTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConstructionTypeType fromValue(String v) {
        for (ConstructionTypeType c: ConstructionTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
