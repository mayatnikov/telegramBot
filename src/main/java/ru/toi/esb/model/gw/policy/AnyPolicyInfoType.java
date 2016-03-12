
package ru.toi.esb.model.gw.policy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnyPolicyInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnyPolicyInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="PolicyInfo" type="{http://toi.ru/esb/model/gw/policy}PolicyInfo_Type" minOccurs="0"/>
 *         &lt;element name="OSAGOPolicyInfo" type="{http://toi.ru/esb/model/gw/policy}OSAGOPolicyInfo_Type" minOccurs="0"/>
 *         &lt;element name="CASCOPolicyInfo" type="{http://toi.ru/esb/model/gw/policy}CASCOPolicyInfo_Type" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnyPolicyInfo_Type", propOrder = {
    "policyInfo",
    "osagoPolicyInfo",
    "cascoPolicyInfo"
})
public class AnyPolicyInfoType {

    @XmlElement(name = "PolicyInfo")
    protected PolicyInfoType policyInfo;
    @XmlElement(name = "OSAGOPolicyInfo")
    protected OSAGOPolicyInfoType osagoPolicyInfo;
    @XmlElement(name = "CASCOPolicyInfo")
    protected CASCOPolicyInfoType cascoPolicyInfo;

    /**
     * Gets the value of the policyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PolicyInfoType }
     *     
     */
    public PolicyInfoType getPolicyInfo() {
        return policyInfo;
    }

    /**
     * Sets the value of the policyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyInfoType }
     *     
     */
    public void setPolicyInfo(PolicyInfoType value) {
        this.policyInfo = value;
    }

    /**
     * Gets the value of the osagoPolicyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OSAGOPolicyInfoType }
     *     
     */
    public OSAGOPolicyInfoType getOSAGOPolicyInfo() {
        return osagoPolicyInfo;
    }

    /**
     * Sets the value of the osagoPolicyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSAGOPolicyInfoType }
     *     
     */
    public void setOSAGOPolicyInfo(OSAGOPolicyInfoType value) {
        this.osagoPolicyInfo = value;
    }

    /**
     * Gets the value of the cascoPolicyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CASCOPolicyInfoType }
     *     
     */
    public CASCOPolicyInfoType getCASCOPolicyInfo() {
        return cascoPolicyInfo;
    }

    /**
     * Sets the value of the cascoPolicyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CASCOPolicyInfoType }
     *     
     */
    public void setCASCOPolicyInfo(CASCOPolicyInfoType value) {
        this.cascoPolicyInfo = value;
    }

}
