
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeOfBuilding_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TypeOfBuilding_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="metalloremont"/>
 *     &lt;enumeration value="atelier"/>
 *     &lt;enumeration value="cafe"/>
 *     &lt;enumeration value="shop"/>
 *     &lt;enumeration value="workshop"/>
 *     &lt;enumeration value="office"/>
 *     &lt;enumeration value="warehouse"/>
 *     &lt;enumeration value="bath"/>
 *     &lt;enumeration value="second_home"/>
 *     &lt;enumeration value="garage"/>
 *     &lt;enumeration value="guest_house"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="kitchen"/>
 *     &lt;enumeration value="shed"/>
 *     &lt;enumeration value="hozblok"/>
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
 *     &lt;enumeration value="aptLoft"/>
 *     &lt;enumeration value="townhouse"/>
 *     &lt;enumeration value="condominium"/>
 *     &lt;enumeration value="room"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TypeOfBuilding_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum TypeOfBuildingType {


    /**
     * Metalloremont
     * 
     */
    @XmlEnumValue("metalloremont")
    METALLOREMONT("metalloremont"),

    /**
     * Ателье
     * 
     */
    @XmlEnumValue("atelier")
    ATELIER("atelier"),

    /**
     * Кафе/ресторан/закусочная
     * 
     */
    @XmlEnumValue("cafe")
    CAFE("cafe"),

    /**
     * Магазин
     * 
     */
    @XmlEnumValue("shop")
    SHOP("shop"),

    /**
     * Мастерская
     * 
     */
    @XmlEnumValue("workshop")
    WORKSHOP("workshop"),

    /**
     * Офис
     * 
     */
    @XmlEnumValue("office")
    OFFICE("office"),

    /**
     * Склад
     * 
     */
    @XmlEnumValue("warehouse")
    WAREHOUSE("warehouse"),

    /**
     * Баня
     * 
     */
    @XmlEnumValue("bath")
    BATH("bath"),

    /**
     * Второй дом
     * 
     */
    @XmlEnumValue("second_home")
    SECOND_HOME("second_home"),

    /**
     * Гараж
     * 
     */
    @XmlEnumValue("garage")
    GARAGE("garage"),

    /**
     * Гостевой дом
     * 
     */
    @XmlEnumValue("guest_house")
    GUEST_HOUSE("guest_house"),

    /**
     * Иное
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Кухня
     * 
     */
    @XmlEnumValue("kitchen")
    KITCHEN("kitchen"),

    /**
     * Сарай
     * 
     */
    @XmlEnumValue("shed")
    SHED("shed"),

    /**
     * Хозблок
     * 
     */
    @XmlEnumValue("hozblok")
    HOZBLOK("hozblok"),

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
     * Апартаменты
     * 
     */
    @XmlEnumValue("aptLoft")
    APT_LOFT("aptLoft"),

    /**
     * Квартира в таунхаусе
     * 
     */
    @XmlEnumValue("townhouse")
    TOWNHOUSE("townhouse"),

    /**
     * Квартира
     * 
     */
    @XmlEnumValue("condominium")
    CONDOMINIUM("condominium"),

    /**
     * Комната
     * 
     */
    @XmlEnumValue("room")
    ROOM("room");
    private final String value;

    TypeOfBuildingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeOfBuildingType fromValue(String v) {
        for (TypeOfBuildingType c: TypeOfBuildingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
