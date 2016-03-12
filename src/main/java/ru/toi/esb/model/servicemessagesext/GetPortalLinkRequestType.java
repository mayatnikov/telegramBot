
package ru.toi.esb.model.servicemessagesext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for GetPortalLinkRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPortalLinkRequest_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type" minOccurs="0"/>
 *         &lt;element name="CalcID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPortalLinkRequest_Type", propOrder = {
    "header",
    "calcID"
})
public class GetPortalLinkRequestType {

    @XmlElement(name = "Header")
    protected MessageHeaderType header;
    @XmlElement(name = "CalcID", required = true)
    protected String calcID;

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
