
package ru.toi.model.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PASSPORT_RUS"/>
 *     &lt;enumeration value="PASSPORT_FRN"/>
 *     &lt;enumeration value="BIRTH_CERT"/>
 *     &lt;enumeration value="DRIVER_LICENCE_RUS"/>
 *     &lt;enumeration value="DRIVER_LICENCE_FRN"/>
 *     &lt;enumeration value="EXT_PASSPORT_RUS"/>
 *     &lt;enumeration value="MILIT_CARD"/>
 *     &lt;enumeration value="DIPL_PASSPORT"/>
 *     &lt;enumeration value="SEA_PASSPORT"/>
 *     &lt;enumeration value="RESID_PERMIT"/>
 *     &lt;enumeration value="MIRG_CARD"/>
 *     &lt;enumeration value="REGIS_CERT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocumentType_Type")
@XmlEnum
public enum DocumentTypeType {


    /**
     * Паспорт гражданина РФ
     * 
     */
    PASSPORT_RUS,

    /**
     * Паспорт иностранного гражданина
     * 
     */
    PASSPORT_FRN,

    /**
     * Свидетельство о рождении
     * 
     */
    BIRTH_CERT,

    /**
     * Водительское удостоверение РФ
     * 
     */
    DRIVER_LICENCE_RUS,

    /**
     * Водительское удостоверение иностранного государства
     * 
     */
    DRIVER_LICENCE_FRN,

    /**
     * Загранпаспорт
     * 
     */
    EXT_PASSPORT_RUS,

    /**
     * Военный билет
     * 
     */
    MILIT_CARD,

    /**
     * Дипломатический паспорт
     * 
     */
    DIPL_PASSPORT,

    /**
     * Паспорт моряка
     * 
     */
    SEA_PASSPORT,

    /**
     * Вид на жительство
     * 
     */
    RESID_PERMIT,

    /**
     * Миграционная карта
     * 
     */
    MIRG_CARD,

    /**
     * Свидетельство о регистрации
     * 
     */
    REGIS_CERT;

    public String value() {
        return name();
    }

    public static DocumentTypeType fromValue(String v) {
        return valueOf(v);
    }

}
