
package ru.toi.esb.model.servicemessagesext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for PushLeadInfoRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushLeadInfoRequest_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type" minOccurs="0"/>
 *         &lt;element name="LeadInfo" type="{http://toi.ru/esb/model/serviceMessagesExt}LeadInfo_Type"/>
 *         &lt;element name="CalcInfo" type="{http://toi.ru/esb/model/serviceMessagesExt}CalcInfo_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushLeadInfoRequest_Type", propOrder = {
    "header",
    "leadInfo",
    "calcInfo"
})
public class PushLeadInfoRequestType {

    @XmlElement(name = "Header")
    protected MessageHeaderType header;
    @XmlElement(name = "LeadInfo", required = true)
    protected LeadInfoType leadInfo;
    @XmlElement(name = "CalcInfo", required = true)
    protected CalcInfoType calcInfo;

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
     * Gets the value of the leadInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LeadInfoType }
     *     
     */
    public LeadInfoType getLeadInfo() {
        return leadInfo;
    }

    /**
     * Sets the value of the leadInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeadInfoType }
     *     
     */
    public void setLeadInfo(LeadInfoType value) {
        this.leadInfo = value;
    }

    /**
     * Gets the value of the calcInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CalcInfoType }
     *     
     */
    public CalcInfoType getCalcInfo() {
        return calcInfo;
    }

    /**
     * Sets the value of the calcInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalcInfoType }
     *     
     */
    public void setCalcInfo(CalcInfoType value) {
        this.calcInfo = value;
    }

}
