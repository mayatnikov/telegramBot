
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Personal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountType_Type")
@XmlEnum
public enum AccountTypeType {


    /**
     * ???
     * 
     */
    @XmlEnumValue("Personal")
    PERSONAL("Personal");
    private final String value;

    AccountTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountTypeType fromValue(String v) {
        for (AccountTypeType c: AccountTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
