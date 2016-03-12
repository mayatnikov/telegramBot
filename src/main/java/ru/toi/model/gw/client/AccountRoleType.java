
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountRole_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountRole_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="primaryinsured"/>
 *     &lt;enumeration value="spouse"/>
 *     &lt;enumeration value="child"/>
 *     &lt;enumeration value="Senior"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="InsuredPerson"/>
 *     &lt;enumeration value="Insurant"/>
 *     &lt;enumeration value="Beneficiary"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountRole_Type")
@XmlEnum
public enum AccountRoleType {


    /**
     * Страхователь
     * 
     */
    @XmlEnumValue("primaryinsured")
    PRIMARYINSURED("primaryinsured"),

    /**
     * Супруг
     * 
     */
    @XmlEnumValue("spouse")
    SPOUSE("spouse"),

    /**
     * Ребенок
     * 
     */
    @XmlEnumValue("child")
    CHILD("child"),

    /**
     * Senior
     * 
     */
    @XmlEnumValue("Senior")
    SENIOR("Senior"),

    /**
     * Other
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("InsuredPerson")
    INSURED_PERSON("InsuredPerson"),
    @XmlEnumValue("Insurant")
    INSURANT("Insurant"),
    @XmlEnumValue("Beneficiary")
    BENEFICIARY("Beneficiary");
    private final String value;

    AccountRoleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountRoleType fromValue(String v) {
        for (AccountRoleType c: AccountRoleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
