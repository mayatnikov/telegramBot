
package ru.toi.esb.model.servicemessagesext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for CalcMotorQuickQuoteMultiRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalcMotorQuickQuoteMultiRequest_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type" minOccurs="0"/>
 *         &lt;element name="item" type="{http://toi.ru/esb/model/serviceMessagesExt}CalcMotorQuickQuoteRequest_Type" maxOccurs="30"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalcMotorQuickQuoteMultiRequest_Type", propOrder = {
    "header",
    "item"
})
public class CalcMotorQuickQuoteMultiRequestType {

    @XmlElement(name = "Header")
    protected MessageHeaderType header;
    @XmlElement(required = true)
    protected List<CalcMotorQuickQuoteRequestType> item;

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
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalcMotorQuickQuoteRequestType }
     * 
     * 
     */
    public List<CalcMotorQuickQuoteRequestType> getItem() {
        if (item == null) {
            item = new ArrayList<CalcMotorQuickQuoteRequestType>();
        }
        return this.item;
    }

}