
package ru.toi.model.gw.quote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KBMInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KBMInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolicyKBMClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyKBMValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KBMInfo_Type", propOrder = {
    "policyKBMClass",
    "policyKBMValue"
})
public class KBMInfoType {

    @XmlElement(name = "PolicyKBMClass")
    protected String policyKBMClass;
    @XmlElement(name = "PolicyKBMValue")
    protected String policyKBMValue;

    /**
     * Gets the value of the policyKBMClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyKBMClass() {
        return policyKBMClass;
    }

    /**
     * Sets the value of the policyKBMClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyKBMClass(String value) {
        this.policyKBMClass = value;
    }

    /**
     * Gets the value of the policyKBMValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyKBMValue() {
        return policyKBMValue;
    }

    /**
     * Sets the value of the policyKBMValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyKBMValue(String value) {
        this.policyKBMValue = value;
    }

}
