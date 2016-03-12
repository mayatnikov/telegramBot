
package ru.toi.model.gw.quote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehicleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TechnicalMaintenanceMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VehicleOSAGOQuoteInfo" type="{http://toi.ru/model/gw/quote}VehicleOSAGOQuoteInfo_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleInfo_Type", propOrder = {
    "vehicleID",
    "technicalMaintenanceMessage",
    "vehicleOSAGOQuoteInfo"
})
public class VehicleInfoType {

    @XmlElement(name = "VehicleID", required = true)
    protected String vehicleID;
    @XmlElement(name = "TechnicalMaintenanceMessage")
    protected List<String> technicalMaintenanceMessage;
    @XmlElement(name = "VehicleOSAGOQuoteInfo")
    protected VehicleOSAGOQuoteInfoType vehicleOSAGOQuoteInfo;

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
     * Gets the value of the technicalMaintenanceMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalMaintenanceMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalMaintenanceMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTechnicalMaintenanceMessage() {
        if (technicalMaintenanceMessage == null) {
            technicalMaintenanceMessage = new ArrayList<String>();
        }
        return this.technicalMaintenanceMessage;
    }

    /**
     * Gets the value of the vehicleOSAGOQuoteInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleOSAGOQuoteInfoType }
     *     
     */
    public VehicleOSAGOQuoteInfoType getVehicleOSAGOQuoteInfo() {
        return vehicleOSAGOQuoteInfo;
    }

    /**
     * Sets the value of the vehicleOSAGOQuoteInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleOSAGOQuoteInfoType }
     *     
     */
    public void setVehicleOSAGOQuoteInfo(VehicleOSAGOQuoteInfoType value) {
        this.vehicleOSAGOQuoteInfo = value;
    }

}
