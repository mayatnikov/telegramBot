
package ru.toi.esb.model.servicemessagesext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtRequestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo_Type", propOrder = {
    "extRequestID"
})
public class PaymentInfoType {

    @XmlElement(name = "ExtRequestID")
    protected String extRequestID;

    /**
     * Gets the value of the extRequestID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtRequestID() {
        return extRequestID;
    }

    /**
     * Sets the value of the extRequestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtRequestID(String value) {
        this.extRequestID = value;
    }

}
