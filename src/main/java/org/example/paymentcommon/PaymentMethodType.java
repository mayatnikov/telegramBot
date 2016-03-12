
package org.example.paymentcommon;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethod_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethod_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLATRON_GETLINK"/>
 *     &lt;enumeration value="PLATRON_SENDLINK_EMAIL"/>
 *     &lt;enumeration value="PLATRON_SENDLINK_SMS"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethod_Type", namespace = "http://www.example.org/PaymentCommon")
@XmlEnum
public enum PaymentMethodType {


    /**
     * Оплата с использованием Platron. Получить платежныю ссылку Platron
     * 
     */
    PLATRON_GETLINK,

    /**
     * Оплата с использованием Platron. Получить платежныю по почте
     * 
     */
    PLATRON_SENDLINK_EMAIL,

    /**
     * Оплата с использованием Platron. Получить платежныю по sms
     * 
     */
    PLATRON_SENDLINK_SMS,

    /**
     * Без оплаты 
     * 
     */
    NONE;

    public String value() {
        return name();
    }

    public static PaymentMethodType fromValue(String v) {
        return valueOf(v);
    }

}
