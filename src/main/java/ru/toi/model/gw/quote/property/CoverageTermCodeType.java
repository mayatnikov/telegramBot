
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoverageTermCode_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CoverageTermCode_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TP_StructElemLimit_TOI"/>
 *     &lt;enumeration value="TP_DeductibleAmountSE_TOI"/>
 *     &lt;enumeration value="TP_DeductiblePercentageSE_TOI"/>
 *     &lt;enumeration value="TP_TrimLimit_TOI"/>
 *     &lt;enumeration value="TP_TrimDeductibleAmount_TOI"/>
 *     &lt;enumeration value="TP_TrimDeductiblePerc_TOI"/>
 *     &lt;enumeration value="TP_EngEquipLimit_TOI"/>
 *     &lt;enumeration value="TP_DeductibleAmountEE_TOI"/>
 *     &lt;enumeration value="TP_DeductiblePerctEE_TOI"/>
 *     &lt;enumeration value="TP_HomCompLimit_TOI"/>
 *     &lt;enumeration value="TP_HomComplexDeductibleAmount_TOI"/>
 *     &lt;enumeration value="TP_HomComplexDeductiblePerc_TOI"/>
 *     &lt;enumeration value="TP_EquipLimit_TOI"/>
 *     &lt;enumeration value="TP_OSLimit_TOI"/>
 *     &lt;enumeration value="TP_PAComplexLimit_TOI"/>
 *     &lt;enumeration value="TP_GlassBreakageLimit_TOI"/>
 *     &lt;enumeration value="TP_GlassBreakageDeductibleAmount_TOI"/>
 *     &lt;enumeration value="TP_GlassBreakageDeductiblePerc_TOI"/>
 *     &lt;enumeration value="TP_CivilLiabilityLimit_TOI"/>
 *     &lt;enumeration value="TP_CivilLiabCMRLimit_TOI"/>
 *     &lt;enumeration value="TP_CivilLimit_TOI"/>
 *     &lt;enumeration value="TP_LossOfRentLimit_TOI"/>
 *     &lt;enumeration value="TP_RentExpensesLimit_TOI"/>
 *     &lt;enumeration value="TP_DoorLocksReplacExpLimit_TOI"/>
 *     &lt;enumeration value="TP_ReturnFromTripLimit_TOI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CoverageTermCode_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum CoverageTermCodeType {


    /**
     * Конструктивные элементы: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_StructElemLimit_TOI")
    TP_STRUCT_ELEM_LIMIT_TOI("TP_StructElemLimit_TOI"),

    /**
     * Конструктивные элементы: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_DeductibleAmountSE_TOI")
    TP_DEDUCTIBLE_AMOUNT_SE_TOI("TP_DeductibleAmountSE_TOI"),

    /**
     * Конструктивные элементы: Тип франшизы (%,$)
     * 
     */
    @XmlEnumValue("TP_DeductiblePercentageSE_TOI")
    TP_DEDUCTIBLE_PERCENTAGE_SE_TOI("TP_DeductiblePercentageSE_TOI"),

    /**
     * Внутренняя отделка: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_TrimLimit_TOI")
    TP_TRIM_LIMIT_TOI("TP_TrimLimit_TOI"),

    /**
     * Внутренняя отделка: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_TrimDeductibleAmount_TOI")
    TP_TRIM_DEDUCTIBLE_AMOUNT_TOI("TP_TrimDeductibleAmount_TOI"),

    /**
     * Внутренняя отделка: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_TrimDeductiblePerc_TOI")
    TP_TRIM_DEDUCTIBLE_PERC_TOI("TP_TrimDeductiblePerc_TOI"),

    /**
     * Инженерное оборудование: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_EngEquipLimit_TOI")
    TP_ENG_EQUIP_LIMIT_TOI("TP_EngEquipLimit_TOI"),

    /**
     * Инженерное оборудование: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_DeductibleAmountEE_TOI")
    TP_DEDUCTIBLE_AMOUNT_EE_TOI("TP_DeductibleAmountEE_TOI"),

    /**
     * Инженерное оборудование: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_DeductiblePerctEE_TOI")
    TP_DEDUCTIBLE_PERCT_EE_TOI("TP_DeductiblePerctEE_TOI"),

    /**
     * Движимое имущество: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_HomCompLimit_TOI")
    TP_HOM_COMP_LIMIT_TOI("TP_HomCompLimit_TOI"),

    /**
     * Движимое имущество: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_HomComplexDeductibleAmount_TOI")
    TP_HOM_COMPLEX_DEDUCTIBLE_AMOUNT_TOI("TP_HomComplexDeductibleAmount_TOI"),

    /**
     * Движимое имущество: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_HomComplexDeductiblePerc_TOI")
    TP_HOM_COMPLEX_DEDUCTIBLE_PERC_TOI("TP_HomComplexDeductiblePerc_TOI"),

    /**
     * Non-residential buildings and ancillaries (Нежилые и вспомогательные постройки): Insured Sum
     * 
     */
    @XmlEnumValue("TP_EquipLimit_TOI")
    TP_EQUIP_LIMIT_TOI("TP_EquipLimit_TOI"),

    /**
     * Прочие сооружения (Забор, ландшафт, бассейн, колодец и др.): Страховая сумма
     * 
     */
    @XmlEnumValue("TP_OSLimit_TOI")
    TP_OS_LIMIT_TOI("TP_OSLimit_TOI"),

    /**
     * Несчастный случай: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_PAComplexLimit_TOI")
    TP_PA_COMPLEX_LIMIT_TOI("TP_PAComplexLimit_TOI"),

    /**
     * Бой стекол: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_GlassBreakageLimit_TOI")
    TP_GLASS_BREAKAGE_LIMIT_TOI("TP_GlassBreakageLimit_TOI"),

    /**
     * Бой стекол: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_GlassBreakageDeductibleAmount_TOI")
    TP_GLASS_BREAKAGE_DEDUCTIBLE_AMOUNT_TOI("TP_GlassBreakageDeductibleAmount_TOI"),

    /**
     * Бой стекол: Размер франшизы
     * 
     */
    @XmlEnumValue("TP_GlassBreakageDeductiblePerc_TOI")
    TP_GLASS_BREAKAGE_DEDUCTIBLE_PERC_TOI("TP_GlassBreakageDeductiblePerc_TOI"),

    /**
     * Причинение вреда 3-м лицам при эксплуатации квартиры (строения), за исключением причинения вреда при проведении строительно-монтажных работ: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_CivilLiabilityLimit_TOI")
    TP_CIVIL_LIABILITY_LIMIT_TOI("TP_CivilLiabilityLimit_TOI"),

    /**
     * Причинение вреда 3-м лицам при эксплуатации квартиры (строения) при проведении строительно-монтажных работ: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_CivilLiabCMRLimit_TOI")
    TP_CIVIL_LIAB_CMR_LIMIT_TOI("TP_CivilLiabCMRLimit_TOI"),

    /**
     * Причинение вреда имуществу собственника квартиры (строения), переданного Страхователю в пользование по договору аренды: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_CivilLimit_TOI")
    TP_CIVIL_LIMIT_TOI("TP_CivilLimit_TOI"),

    /**
     * Расходы от потери арендной платы: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_LossOfRentLimit_TOI")
    TP_LOSS_OF_RENT_LIMIT_TOI("TP_LossOfRentLimit_TOI"),

    /**
     * Расходы по найму: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_RentExpensesLimit_TOI")
    TP_RENT_EXPENSES_LIMIT_TOI("TP_RentExpensesLimit_TOI"),

    /**
     * Расходы по замене дверных замков: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_DoorLocksReplacExpLimit_TOI")
    TP_DOOR_LOCKS_REPLAC_EXP_LIMIT_TOI("TP_DoorLocksReplacExpLimit_TOI"),

    /**
     * Расходы по досрочному возвращению: Страховая сумма
     * 
     */
    @XmlEnumValue("TP_ReturnFromTripLimit_TOI")
    TP_RETURN_FROM_TRIP_LIMIT_TOI("TP_ReturnFromTripLimit_TOI");
    private final String value;

    CoverageTermCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CoverageTermCodeType fromValue(String v) {
        for (CoverageTermCodeType c: CoverageTermCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
