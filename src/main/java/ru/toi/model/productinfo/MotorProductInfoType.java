
package ru.toi.model.productinfo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *     			Информация о страховом продукте Motor
 *     		
 * 
 * <p>Java class for MotorProductInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MotorProductInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductType" type="{http://toi.ru/model/productinfo}ProductType_Type"/>
 *         &lt;element name="ProductVersion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ShortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FullDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyQuickQuoteOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" minOccurs="0"/>
 *         &lt;element name="PolicyQuoteOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" minOccurs="0"/>
 *         &lt;element name="PolicySubmissionOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" minOccurs="0"/>
 *         &lt;element name="VehicleQuickQuoteOptions" type="{http://toi.ru/model/productinfo}VehicleOptions_Type" minOccurs="0"/>
 *         &lt;element name="VehicleQuoteOptions" type="{http://toi.ru/model/productinfo}VehicleOptions_Type" minOccurs="0"/>
 *         &lt;element name="VehicleSubmissionOptions" type="{http://toi.ru/model/productinfo}VehicleOptions_Type" minOccurs="0"/>
 *         &lt;element name="ProductOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" minOccurs="0"/>
 *         &lt;element name="PersonOptions" type="{http://toi.ru/model/productinfo}PersonOptions_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MotorProductInfo_Type", propOrder = {
    "name",
    "productType",
    "productVersion",
    "shortDescription",
    "fullDescription",
    "policyQuickQuoteOptions",
    "policyQuoteOptions",
    "policySubmissionOptions",
    "vehicleQuickQuoteOptions",
    "vehicleQuoteOptions",
    "vehicleSubmissionOptions",
    "productOptions",
    "personOptions"
})
public class MotorProductInfoType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ProductType", required = true)
    protected ProductTypeType productType;
    @XmlElement(name = "ProductVersion")
    protected BigDecimal productVersion;
    @XmlElement(name = "ShortDescription")
    protected String shortDescription;
    @XmlElement(name = "FullDescription")
    protected String fullDescription;
    @XmlElement(name = "PolicyQuickQuoteOptions")
    protected ProductOptionsType policyQuickQuoteOptions;
    @XmlElement(name = "PolicyQuoteOptions")
    protected ProductOptionsType policyQuoteOptions;
    @XmlElement(name = "PolicySubmissionOptions")
    protected ProductOptionsType policySubmissionOptions;
    @XmlElement(name = "VehicleQuickQuoteOptions")
    protected VehicleOptionsType vehicleQuickQuoteOptions;
    @XmlElement(name = "VehicleQuoteOptions")
    protected VehicleOptionsType vehicleQuoteOptions;
    @XmlElement(name = "VehicleSubmissionOptions")
    protected VehicleOptionsType vehicleSubmissionOptions;
    @XmlElement(name = "ProductOptions")
    protected ProductOptionsType productOptions;
    @XmlElement(name = "PersonOptions")
    protected PersonOptionsType personOptions;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTypeType }
     *     
     */
    public ProductTypeType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTypeType }
     *     
     */
    public void setProductType(ProductTypeType value) {
        this.productType = value;
    }

    /**
     * Gets the value of the productVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProductVersion() {
        return productVersion;
    }

    /**
     * Sets the value of the productVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProductVersion(BigDecimal value) {
        this.productVersion = value;
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Gets the value of the fullDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * Sets the value of the fullDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullDescription(String value) {
        this.fullDescription = value;
    }

    /**
     * Gets the value of the policyQuickQuoteOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOptionsType }
     *     
     */
    public ProductOptionsType getPolicyQuickQuoteOptions() {
        return policyQuickQuoteOptions;
    }

    /**
     * Sets the value of the policyQuickQuoteOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOptionsType }
     *     
     */
    public void setPolicyQuickQuoteOptions(ProductOptionsType value) {
        this.policyQuickQuoteOptions = value;
    }

    /**
     * Gets the value of the policyQuoteOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOptionsType }
     *     
     */
    public ProductOptionsType getPolicyQuoteOptions() {
        return policyQuoteOptions;
    }

    /**
     * Sets the value of the policyQuoteOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOptionsType }
     *     
     */
    public void setPolicyQuoteOptions(ProductOptionsType value) {
        this.policyQuoteOptions = value;
    }

    /**
     * Gets the value of the policySubmissionOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOptionsType }
     *     
     */
    public ProductOptionsType getPolicySubmissionOptions() {
        return policySubmissionOptions;
    }

    /**
     * Sets the value of the policySubmissionOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOptionsType }
     *     
     */
    public void setPolicySubmissionOptions(ProductOptionsType value) {
        this.policySubmissionOptions = value;
    }

    /**
     * Gets the value of the vehicleQuickQuoteOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleOptionsType }
     *     
     */
    public VehicleOptionsType getVehicleQuickQuoteOptions() {
        return vehicleQuickQuoteOptions;
    }

    /**
     * Sets the value of the vehicleQuickQuoteOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleOptionsType }
     *     
     */
    public void setVehicleQuickQuoteOptions(VehicleOptionsType value) {
        this.vehicleQuickQuoteOptions = value;
    }

    /**
     * Gets the value of the vehicleQuoteOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleOptionsType }
     *     
     */
    public VehicleOptionsType getVehicleQuoteOptions() {
        return vehicleQuoteOptions;
    }

    /**
     * Sets the value of the vehicleQuoteOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleOptionsType }
     *     
     */
    public void setVehicleQuoteOptions(VehicleOptionsType value) {
        this.vehicleQuoteOptions = value;
    }

    /**
     * Gets the value of the vehicleSubmissionOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleOptionsType }
     *     
     */
    public VehicleOptionsType getVehicleSubmissionOptions() {
        return vehicleSubmissionOptions;
    }

    /**
     * Sets the value of the vehicleSubmissionOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleOptionsType }
     *     
     */
    public void setVehicleSubmissionOptions(VehicleOptionsType value) {
        this.vehicleSubmissionOptions = value;
    }

    /**
     * Gets the value of the productOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOptionsType }
     *     
     */
    public ProductOptionsType getProductOptions() {
        return productOptions;
    }

    /**
     * Sets the value of the productOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOptionsType }
     *     
     */
    public void setProductOptions(ProductOptionsType value) {
        this.productOptions = value;
    }

    /**
     * Gets the value of the personOptions property.
     * 
     * @return
     *     possible object is
     *     {@link PersonOptionsType }
     *     
     */
    public PersonOptionsType getPersonOptions() {
        return personOptions;
    }

    /**
     * Sets the value of the personOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonOptionsType }
     *     
     */
    public void setPersonOptions(PersonOptionsType value) {
        this.personOptions = value;
    }

}
