
package ru.toi.model.gw.quote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Покрытие
 * 
 * <p>Java class for Coverage_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Coverage_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CoverageActualAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CoverageName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Coverage_Type", propOrder = {
    "coverageActualAmount",
    "coverageName"
})
public class CoverageType {

    @XmlElement(name = "CoverageActualAmount", required = true)
    protected String coverageActualAmount;
    @XmlElement(name = "CoverageName", required = true)
    protected String coverageName;

    /**
     * Gets the value of the coverageActualAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageActualAmount() {
        return coverageActualAmount;
    }

    /**
     * Sets the value of the coverageActualAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageActualAmount(String value) {
        this.coverageActualAmount = value;
    }

    /**
     * Gets the value of the coverageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageName() {
        return coverageName;
    }

    /**
     * Sets the value of the coverageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageName(String value) {
        this.coverageName = value;
    }

}
