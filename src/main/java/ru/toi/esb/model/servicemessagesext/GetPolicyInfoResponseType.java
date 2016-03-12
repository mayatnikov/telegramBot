
package ru.toi.esb.model.servicemessagesext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.esb.model.gw.policy.AnyPolicyInfoType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for GetPolicyInfoResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyInfoResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type"/>
 *         &lt;element name="PolicyInfo" type="{http://toi.ru/esb/model/gw/policy}AnyPolicyInfo_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPolicyInfoResponse_Type", propOrder = {
    "header",
    "policyInfo"
})
public class GetPolicyInfoResponseType {

    @XmlElement(name = "Header", required = true)
    protected MessageHeaderType header;
    @XmlElement(name = "PolicyInfo")
    protected AnyPolicyInfoType policyInfo;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setHeader(MessageHeaderType value) {
        this.header = value;
    }

    /**
     * Gets the value of the policyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AnyPolicyInfoType }
     *     
     */
    public AnyPolicyInfoType getPolicyInfo() {
        return policyInfo;
    }

    /**
     * Sets the value of the policyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyPolicyInfoType }
     *     
     */
    public void setPolicyInfo(AnyPolicyInfoType value) {
        this.policyInfo = value;
    }

}
