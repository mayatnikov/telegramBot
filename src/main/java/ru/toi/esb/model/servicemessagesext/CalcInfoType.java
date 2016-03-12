
package ru.toi.esb.model.servicemessagesext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalcInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalcInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CalcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CalcDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExtOrderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalcInfo_Type", propOrder = {
    "calcID",
    "calcDetails",
    "productType",
    "comment",
    "extOrderID"
})
public class CalcInfoType {

    @XmlElement(name = "CalcID")
    protected String calcID;
    @XmlElement(name = "CalcDetails")
    protected String calcDetails;
    @XmlElement(name = "ProductType", required = true)
    protected String productType;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "ExtOrderID")
    protected String extOrderID;

    /**
     * Gets the value of the calcID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalcID() {
        return calcID;
    }

    /**
     * Sets the value of the calcID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalcID(String value) {
        this.calcID = value;
    }

    /**
     * Gets the value of the calcDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalcDetails() {
        return calcDetails;
    }

    /**
     * Sets the value of the calcDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalcDetails(String value) {
        this.calcDetails = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductType(String value) {
        this.productType = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the extOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtOrderID() {
        return extOrderID;
    }

    /**
     * Sets the value of the extOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtOrderID(String value) {
        this.extOrderID = value;
    }

}
