
package ru.toi.model.gw.quote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleOSAGOQuoteInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleOSAGOQuoteInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehicleID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyKBM" type="{http://toi.ru/model/gw/quote}KBMInfo_Type" minOccurs="0"/>
 *         &lt;element name="PersonKBM" type="{http://toi.ru/model/gw/quote}PersonKBMInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TechnicalInspectionInfo" type="{http://toi.ru/model/gw/quote}TechInspectionInfo_Type" minOccurs="0"/>
 *         &lt;element name="TotalCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TotalCoveredAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleOSAGOQuoteInfo_Type", propOrder = {
    "vehicleID",
    "policyKBM",
    "personKBM",
    "technicalInspectionInfo",
    "totalCost",
    "totalCoveredAmount"
})
public class VehicleOSAGOQuoteInfoType {

    @XmlElement(name = "VehicleID")
    protected String vehicleID;
    @XmlElement(name = "PolicyKBM")
    protected KBMInfoType policyKBM;
    @XmlElement(name = "PersonKBM")
    protected List<PersonKBMInfoType> personKBM;
    @XmlElement(name = "TechnicalInspectionInfo")
    protected TechInspectionInfoType technicalInspectionInfo;
    @XmlElement(name = "TotalCost")
    protected BigDecimal totalCost;
    @XmlElement(name = "TotalCoveredAmount")
    protected BigDecimal totalCoveredAmount;

    /**
     * Gets the value of the vehicleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleID() {
        return vehicleID;
    }

    /**
     * Sets the value of the vehicleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleID(String value) {
        this.vehicleID = value;
    }

    /**
     * Gets the value of the policyKBM property.
     * 
     * @return
     *     possible object is
     *     {@link KBMInfoType }
     *     
     */
    public KBMInfoType getPolicyKBM() {
        return policyKBM;
    }

    /**
     * Sets the value of the policyKBM property.
     * 
     * @param value
     *     allowed object is
     *     {@link KBMInfoType }
     *     
     */
    public void setPolicyKBM(KBMInfoType value) {
        this.policyKBM = value;
    }

    /**
     * Gets the value of the personKBM property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personKBM property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonKBM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonKBMInfoType }
     * 
     * 
     */
    public List<PersonKBMInfoType> getPersonKBM() {
        if (personKBM == null) {
            personKBM = new ArrayList<PersonKBMInfoType>();
        }
        return this.personKBM;
    }

    /**
     * Gets the value of the technicalInspectionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TechInspectionInfoType }
     *     
     */
    public TechInspectionInfoType getTechnicalInspectionInfo() {
        return technicalInspectionInfo;
    }

    /**
     * Sets the value of the technicalInspectionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechInspectionInfoType }
     *     
     */
    public void setTechnicalInspectionInfo(TechInspectionInfoType value) {
        this.technicalInspectionInfo = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCost(BigDecimal value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the totalCoveredAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCoveredAmount() {
        return totalCoveredAmount;
    }

    /**
     * Sets the value of the totalCoveredAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCoveredAmount(BigDecimal value) {
        this.totalCoveredAmount = value;
    }

}
