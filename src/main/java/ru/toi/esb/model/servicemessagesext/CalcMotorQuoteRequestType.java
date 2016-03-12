
package ru.toi.esb.model.servicemessagesext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;
import ru.toi.model.productinfo.PersonOptionsType;
import ru.toi.model.productinfo.ProductOptionsType;
import ru.toi.model.productinfo.VehicleOptionsType;


/**
 * <p>Java class for CalcMotorQuoteRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalcMotorQuoteRequest_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type"/>
 *         &lt;element name="ProductName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProductVersion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PolicyOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type"/>
 *         &lt;element name="VehicleOptions" type="{http://toi.ru/model/productinfo}VehicleOptions_Type" maxOccurs="unbounded"/>
 *         &lt;element name="ProductOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" maxOccurs="unbounded"/>
 *         &lt;element name="PersonOptions" type="{http://toi.ru/model/productinfo}PersonOptions_Type" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalcMotorQuoteRequest_Type", propOrder = {
    "header",
    "productName",
    "productVersion",
    "policyOptions",
    "vehicleOptions",
    "productOptions",
    "personOptions"
})
public class CalcMotorQuoteRequestType {

    @XmlElement(name = "Header", required = true)
    protected MessageHeaderType header;
    @XmlElement(name = "ProductName", required = true)
    protected String productName;
    @XmlElement(name = "ProductVersion")
    protected BigDecimal productVersion;
    @XmlElement(name = "PolicyOptions", required = true)
    protected ProductOptionsType policyOptions;
    @XmlElement(name = "VehicleOptions", required = true)
    protected List<VehicleOptionsType> vehicleOptions;
    @XmlElement(name = "ProductOptions", required = true)
    protected List<ProductOptionsType> productOptions;
    @XmlElement(name = "PersonOptions", required = true)
    protected List<PersonOptionsType> personOptions;

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
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
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
     * Gets the value of the policyOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOptionsType }
     *     
     */
    public ProductOptionsType getPolicyOptions() {
        return policyOptions;
    }

    /**
     * Sets the value of the policyOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOptionsType }
     *     
     */
    public void setPolicyOptions(ProductOptionsType value) {
        this.policyOptions = value;
    }

    /**
     * Gets the value of the vehicleOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleOptionsType }
     * 
     * 
     */
    public List<VehicleOptionsType> getVehicleOptions() {
        if (vehicleOptions == null) {
            vehicleOptions = new ArrayList<VehicleOptionsType>();
        }
        return this.vehicleOptions;
    }

    /**
     * Gets the value of the productOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductOptionsType }
     * 
     * 
     */
    public List<ProductOptionsType> getProductOptions() {
        if (productOptions == null) {
            productOptions = new ArrayList<ProductOptionsType>();
        }
        return this.productOptions;
    }

    /**
     * Gets the value of the personOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonOptionsType }
     * 
     * 
     */
    public List<PersonOptionsType> getPersonOptions() {
        if (personOptions == null) {
            personOptions = new ArrayList<PersonOptionsType>();
        }
        return this.personOptions;
    }

}
