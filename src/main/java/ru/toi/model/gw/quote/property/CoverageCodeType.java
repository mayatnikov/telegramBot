
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoverageCode_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CoverageCode_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TP_GlassBreakageComplex_TOI"/>
 *     &lt;enumeration value="TP_Trim_TOI"/>
 *     &lt;enumeration value="TP_HomesteadComplex_TOI"/>
 *     &lt;enumeration value="TP_Flood_TOI"/>
 *     &lt;enumeration value="TP_ExtFlood_TOI"/>
 *     &lt;enumeration value="TP_EngEquip_TOI"/>
 *     &lt;enumeration value="TP_StructElems_TOI"/>
 *     &lt;enumeration value="TP_MecDam_TOI"/>
 *     &lt;enumeration value="TP_Equipment_TOI"/>
 *     &lt;enumeration value="TP_ElecNetDown_TOI"/>
 *     &lt;enumeration value="TP_PAComplex_TOI"/>
 *     &lt;enumeration value="TP_Fire_TOI"/>
 *     &lt;enumeration value="TP_CivilCMR_TOI"/>
 *     &lt;enumeration value="TP_CivilLiability_TOI"/>
 *     &lt;enumeration value="TP_Civil2_TOI"/>
 *     &lt;enumeration value="TP_Vandalism_TOI"/>
 *     &lt;enumeration value="TP_OtherStructure_TOI"/>
 *     &lt;enumeration value="TP_LossOfRent_TOI"/>
 *     &lt;enumeration value="TP_ReturnFromTrip_TOI"/>
 *     &lt;enumeration value="TP_DoorLocksReplacement_TOI"/>
 *     &lt;enumeration value="TP_RentExpenses_TOI"/>
 *     &lt;enumeration value="TP_Repair_TOI"/>
 *     &lt;enumeration value="TP_GlassRisk_TOI"/>
 *     &lt;enumeration value="TP_ActofGod_TOI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CoverageCode_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum CoverageCodeType {


    /**
     * Бой стекол
     * 
     */
    @XmlEnumValue("TP_GlassBreakageComplex_TOI")
    TP_GLASS_BREAKAGE_COMPLEX_TOI("TP_GlassBreakageComplex_TOI"),

    /**
     * Внутренняя отделка
     * 
     */
    @XmlEnumValue("TP_Trim_TOI")
    TP_TRIM_TOI("TP_Trim_TOI"),

    /**
     * Движимое имущество
     * 
     */
    @XmlEnumValue("TP_HomesteadComplex_TOI")
    TP_HOMESTEAD_COMPLEX_TOI("TP_HomesteadComplex_TOI"),

    /**
     * Залив
     * 
     */
    @XmlEnumValue("TP_Flood_TOI")
    TP_FLOOD_TOI("TP_Flood_TOI"),

    /**
     * Залив+
     * 
     */
    @XmlEnumValue("TP_ExtFlood_TOI")
    TP_EXT_FLOOD_TOI("TP_ExtFlood_TOI"),

    /**
     * Инженерное оборудование
     * 
     */
    @XmlEnumValue("TP_EngEquip_TOI")
    TP_ENG_EQUIP_TOI("TP_EngEquip_TOI"),

    /**
     * Конструктивные элементы 
     * 
     */
    @XmlEnumValue("TP_StructElems_TOI")
    TP_STRUCT_ELEMS_TOI("TP_StructElems_TOI"),

    /**
     * Механические повреждения
     * 
     */
    @XmlEnumValue("TP_MecDam_TOI")
    TP_MEC_DAM_TOI("TP_MecDam_TOI"),

    /**
     * Нежилые и вспомогательные постройки
     * 
     */
    @XmlEnumValue("TP_Equipment_TOI")
    TP_EQUIPMENT_TOI("TP_Equipment_TOI"),

    /**
     * Неисправность сетей
     * 
     */
    @XmlEnumValue("TP_ElecNetDown_TOI")
    TP_ELEC_NET_DOWN_TOI("TP_ElecNetDown_TOI"),

    /**
     * Несчастный случай
     * 
     */
    @XmlEnumValue("TP_PAComplex_TOI")
    TP_PA_COMPLEX_TOI("TP_PAComplex_TOI"),

    /**
     * Пожар, Взрыв, Удар молнии
     * 
     */
    @XmlEnumValue("TP_Fire_TOI")
    TP_FIRE_TOI("TP_Fire_TOI"),

    /**
     * Причинение вреда 3-м лицам при эксплуатации квартиры (строения) при проведении строительно-монтажных работ
     * 
     */
    @XmlEnumValue("TP_CivilCMR_TOI")
    TP_CIVIL_CMR_TOI("TP_CivilCMR_TOI"),

    /**
     * Причинение вреда 3-м лицам при эксплуатации квартиры (строения), за исключением причинения вреда при проведении строительно-монтажных работ
     * 
     */
    @XmlEnumValue("TP_CivilLiability_TOI")
    TP_CIVIL_LIABILITY_TOI("TP_CivilLiability_TOI"),

    /**
     * Причинение вреда имуществу собственника квартиры (строения), переданного Страхователю в пользование по договору аренды
     * 
     */
    @XmlEnumValue("TP_Civil2_TOI")
    TP_CIVIL_2_TOI("TP_Civil2_TOI"),

    /**
     * Противоправные действия третьих лиц
     * 
     */
    @XmlEnumValue("TP_Vandalism_TOI")
    TP_VANDALISM_TOI("TP_Vandalism_TOI"),

    /**
     * Прочие сооружения (Забор, ландшафт, бассейн, колодец и др.)
     * 
     */
    @XmlEnumValue("TP_OtherStructure_TOI")
    TP_OTHER_STRUCTURE_TOI("TP_OtherStructure_TOI"),

    /**
     * Расходы от потери арендной платы
     * 
     */
    @XmlEnumValue("TP_LossOfRent_TOI")
    TP_LOSS_OF_RENT_TOI("TP_LossOfRent_TOI"),

    /**
     * Расходы по досрочному возвращению
     * 
     */
    @XmlEnumValue("TP_ReturnFromTrip_TOI")
    TP_RETURN_FROM_TRIP_TOI("TP_ReturnFromTrip_TOI"),

    /**
     * Расходы по замене дверных замков
     * 
     */
    @XmlEnumValue("TP_DoorLocksReplacement_TOI")
    TP_DOOR_LOCKS_REPLACEMENT_TOI("TP_DoorLocksReplacement_TOI"),

    /**
     * Расходы по найму
     * 
     */
    @XmlEnumValue("TP_RentExpenses_TOI")
    TP_RENT_EXPENSES_TOI("TP_RentExpenses_TOI"),

    /**
     * Ремонт
     * 
     */
    @XmlEnumValue("TP_Repair_TOI")
    TP_REPAIR_TOI("TP_Repair_TOI"),

    /**
     * Стеклянные элементы
     * 
     */
    @XmlEnumValue("TP_GlassRisk_TOI")
    TP_GLASS_RISK_TOI("TP_GlassRisk_TOI"),

    /**
     * Стихийные бедствия
     * 
     */
    @XmlEnumValue("TP_ActofGod_TOI")
    TP_ACTOF_GOD_TOI("TP_ActofGod_TOI");
    private final String value;

    CoverageCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CoverageCodeType fromValue(String v) {
        for (CoverageCodeType c: CoverageCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
