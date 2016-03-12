
package ru.toi.model.gw.quote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MotorQuote_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MotorQuote_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Coverage" type="{http://toi.ru/model/gw/quote}Coverage_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalCoveredAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="KBMInfo" type="{http://toi.ru/model/gw/quote}KBMInfo_Type" minOccurs="0"/>
 *         &lt;element name="VehicleInfo" type="{http://toi.ru/model/gw/quote}VehicleInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CalcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MotorQuote_Type", propOrder = {
    "coverage",
    "totalCost",
    "totalCoveredAmount",
    "kbmInfo",
    "vehicleInfo",
    "calcID"
})
public class MotorQuoteType {

    @XmlElement(name = "Coverage")
    protected List<CoverageType> coverage;
    @XmlElement(name = "TotalCost", required = true)
    protected BigDecimal totalCost;
    @XmlElement(name = "TotalCoveredAmount")
    protected BigDecimal totalCoveredAmount;
    @XmlElement(name = "KBMInfo")
    protected KBMInfoType kbmInfo;
    @XmlElement(name = "VehicleInfo")
    protected List<VehicleInfoType> vehicleInfo;
    @XmlElement(name = "CalcID")
    protected String calcID;

    /**
     * Gets the value of the coverage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coverage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoverage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoverageType }
     * 
     * 
     */
    public List<CoverageType> getCoverage() {
        if (coverage == null) {
            coverage = new ArrayList<CoverageType>();
        }
        return this.coverage;
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

    /**
     * Gets the value of the kbmInfo property.
     * 
     * @return
     *     possible object is
     *     {@link KBMInfoType }
     *     
     */
    public KBMInfoType getKBMInfo() {
        return kbmInfo;
    }

    /**
     * Sets the value of the kbmInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link KBMInfoType }
     *     
     */
    public void setKBMInfo(KBMInfoType value) {
        this.kbmInfo = value;
    }

    /**
     * Gets the value of the vehicleInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleInfoType }
     * 
     * 
     */
    public List<VehicleInfoType> getVehicleInfo() {
        if (vehicleInfo == null) {
            vehicleInfo = new ArrayList<VehicleInfoType>();
        }
        return this.vehicleInfo;
    }

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

}
