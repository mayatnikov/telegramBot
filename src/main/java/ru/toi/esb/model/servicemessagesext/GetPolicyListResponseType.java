
package ru.toi.esb.model.servicemessagesext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.esb.model.gw.policy.AnyPolicyInfoType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for GetPolicyListResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyListResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type"/>
 *         &lt;element name="PolicyInfo" type="{http://toi.ru/esb/model/gw/policy}AnyPolicyInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPolicyListResponse_Type", propOrder = {
    "header",
    "policyInfo"
})
public class GetPolicyListResponseType {

    @XmlElement(name = "Header", required = true)
    protected MessageHeaderType header;
    @XmlElement(name = "PolicyInfo")
    protected List<AnyPolicyInfoType> policyInfo;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnyPolicyInfoType }
     * 
     * 
     */
    public List<AnyPolicyInfoType> getPolicyInfo() {
        if (policyInfo == null) {
            policyInfo = new ArrayList<AnyPolicyInfoType>();
        }
        return this.policyInfo;
    }

}
