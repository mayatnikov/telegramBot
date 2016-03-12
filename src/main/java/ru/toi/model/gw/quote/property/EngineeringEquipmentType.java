
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EngineeringEquipment_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EngineeringEquipment_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="conditioning"/>
 *     &lt;enumeration value="boilers"/>
 *     &lt;enumeration value="ceiling_heating"/>
 *     &lt;enumeration value="electrical_equipment"/>
 *     &lt;enumeration value="fireplace"/>
 *     &lt;enumeration value="floor_heating"/>
 *     &lt;enumeration value="gas_meter"/>
 *     &lt;enumeration value="walls_heating"/>
 *     &lt;enumeration value="low_voltage"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="oven"/>
 *     &lt;enumeration value="pipes"/>
 *     &lt;enumeration value="heating_radiators"/>
 *     &lt;enumeration value="plumbing_equipment"/>
 *     &lt;enumeration value="power_supply"/>
 *     &lt;enumeration value="sauna"/>
 *     &lt;enumeration value="ventilation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EngineeringEquipment_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum EngineeringEquipmentType {


    /**
     * air Conditioning System
     * 
     */
    @XmlEnumValue("conditioning")
    CONDITIONING("conditioning"),

    /**
     * Boilers
     * 
     */
    @XmlEnumValue("boilers")
    BOILERS("boilers"),

    /**
     * Ceiling heating system
     * 
     */
    @XmlEnumValue("ceiling_heating")
    CEILING_HEATING("ceiling_heating"),

    /**
     * Electrical, gas, lighting, radio equipment and instruments
     * 
     */
    @XmlEnumValue("electrical_equipment")
    ELECTRICAL_EQUIPMENT("electrical_equipment"),

    /**
     * Fireplace
     * 
     */
    @XmlEnumValue("fireplace")
    FIREPLACE("fireplace"),

    /**
     * Floor heating system
     * 
     */
    @XmlEnumValue("floor_heating")
    FLOOR_HEATING("floor_heating"),

    /**
     * gas meter
     * 
     */
    @XmlEnumValue("gas_meter")
    GAS_METER("gas_meter"),

    /**
     * Heating system walls
     * 
     */
    @XmlEnumValue("walls_heating")
    WALLS_HEATING("walls_heating"),

    /**
     * Low-voltage communication
     * 
     */
    @XmlEnumValue("low_voltage")
    LOW_VOLTAGE("low_voltage"),

    /**
     * Other
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Oven
     * 
     */
    @XmlEnumValue("oven")
    OVEN("oven"),

    /**
     * Pipes (gas, water and sewer)
     * 
     */
    @XmlEnumValue("pipes")
    PIPES("pipes"),

    /**
     * Pipes and central heating radiators
     * 
     */
    @XmlEnumValue("heating_radiators")
    HEATING_RADIATORS("heating_radiators"),

    /**
     * Plumbing equipment
     * 
     */
    @XmlEnumValue("plumbing_equipment")
    PLUMBING_EQUIPMENT("plumbing_equipment"),

    /**
     * Power supply system (including electrical cables, wires, meters, etc.)
     * 
     */
    @XmlEnumValue("power_supply")
    POWER_SUPPLY("power_supply"),

    /**
     * Sauna
     * 
     */
    @XmlEnumValue("sauna")
    SAUNA("sauna"),

    /**
     * ventilation system
     * 
     */
    @XmlEnumValue("ventilation")
    VENTILATION("ventilation");
    private final String value;

    EngineeringEquipmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EngineeringEquipmentType fromValue(String v) {
        for (EngineeringEquipmentType c: EngineeringEquipmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
