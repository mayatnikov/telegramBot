
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.AddressTypeType;
import ru.toi.model.common.CrossIDType;
import ru.toi.model.gw.quote.property.CountriyCodeType;


/**
 * <p>Java class for Address_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://toi.ru/model/common}CrossID_Type" minOccurs="0"/>
 *         &lt;element name="IsPrimary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ContactAddressXID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddressType" type="{http://toi.ru/model/common}AddressType_Type"/>
 *         &lt;element name="Country" type="{http://toi.ru/model/gw/quote/property}CountriyCode_Type" minOccurs="0"/>
 *         &lt;element name="PostCode" type="{http://toi.ru/model/common}PostCode_Type" minOccurs="0"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="District" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PopulatedCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Building" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Flat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KLADR1" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *         &lt;element name="KLADR2" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *         &lt;element name="KLADR3" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *         &lt;element name="KLADR4" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *         &lt;element name="KLADR5" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *         &lt;element name="KLADR6" type="{http://toi.ru/model/gw/client}KLADRType_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address_Type", propOrder = {
    "id",
    "isPrimary",
    "contactAddressXID",
    "isActive",
    "addressType",
    "country",
    "postCode",
    "region",
    "district",
    "city",
    "populatedCenter",
    "street",
    "building",
    "flat",
    "kladr1",
    "kladr2",
    "kladr3",
    "kladr4",
    "kladr5",
    "kladr6"
})
public class AddressType {

    @XmlElement(name = "ID")
    protected CrossIDType id;
    @XmlElement(name = "IsPrimary")
    protected Boolean isPrimary;
    @XmlElement(name = "ContactAddressXID")
    protected String contactAddressXID;
    @XmlElement(name = "IsActive")
    protected Boolean isActive;
    @XmlElement(name = "AddressType", required = true)
    protected AddressTypeType addressType;
    @XmlElement(name = "Country")
    protected CountriyCodeType country;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "District")
    protected String district;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "PopulatedCenter")
    protected String populatedCenter;
    @XmlElement(name = "Street")
    protected String street;
    @XmlElement(name = "Building")
    protected String building;
    @XmlElement(name = "Flat")
    protected String flat;
    @XmlElement(name = "KLADR1")
    protected String kladr1;
    @XmlElement(name = "KLADR2")
    protected String kladr2;
    @XmlElement(name = "KLADR3")
    protected String kladr3;
    @XmlElement(name = "KLADR4")
    protected String kladr4;
    @XmlElement(name = "KLADR5")
    protected String kladr5;
    @XmlElement(name = "KLADR6")
    protected String kladr6;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link CrossIDType }
     *     
     */
    public CrossIDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossIDType }
     *     
     */
    public void setID(CrossIDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the isPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the value of the isPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPrimary(Boolean value) {
        this.isPrimary = value;
    }

    /**
     * Gets the value of the contactAddressXID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactAddressXID() {
        return contactAddressXID;
    }

    /**
     * Sets the value of the contactAddressXID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactAddressXID(String value) {
        this.contactAddressXID = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsActive(Boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link AddressTypeType }
     *     
     */
    public AddressTypeType getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressTypeType }
     *     
     */
    public void setAddressType(AddressTypeType value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CountriyCodeType }
     *     
     */
    public CountriyCodeType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountriyCodeType }
     *     
     */
    public void setCountry(CountriyCodeType value) {
        this.country = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the populatedCenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPopulatedCenter() {
        return populatedCenter;
    }

    /**
     * Sets the value of the populatedCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPopulatedCenter(String value) {
        this.populatedCenter = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuilding(String value) {
        this.building = value;
    }

    /**
     * Gets the value of the flat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlat() {
        return flat;
    }

    /**
     * Sets the value of the flat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlat(String value) {
        this.flat = value;
    }

    /**
     * Gets the value of the kladr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR1() {
        return kladr1;
    }

    /**
     * Sets the value of the kladr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR1(String value) {
        this.kladr1 = value;
    }

    /**
     * Gets the value of the kladr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR2() {
        return kladr2;
    }

    /**
     * Sets the value of the kladr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR2(String value) {
        this.kladr2 = value;
    }

    /**
     * Gets the value of the kladr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR3() {
        return kladr3;
    }

    /**
     * Sets the value of the kladr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR3(String value) {
        this.kladr3 = value;
    }

    /**
     * Gets the value of the kladr4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR4() {
        return kladr4;
    }

    /**
     * Sets the value of the kladr4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR4(String value) {
        this.kladr4 = value;
    }

    /**
     * Gets the value of the kladr5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR5() {
        return kladr5;
    }

    /**
     * Sets the value of the kladr5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR5(String value) {
        this.kladr5 = value;
    }

    /**
     * Gets the value of the kladr6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR6() {
        return kladr6;
    }

    /**
     * Sets the value of the kladr6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR6(String value) {
        this.kladr6 = value;
    }

}
