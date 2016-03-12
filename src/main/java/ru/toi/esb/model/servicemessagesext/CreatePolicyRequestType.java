
package ru.toi.esb.model.servicemessagesext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.example.paymentcommon.PaymentMethodType;
import ru.toi.model.common.DeliveryMethodType;
import ru.toi.model.common.MessageHeaderType;
import ru.toi.model.gw.client.ClientInfoType;
import ru.toi.model.productinfo.ProductOptionsType;


/**
 * Запрос на создание полиса
 * 
 * <p>Java class for CreatePolicyRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreatePolicyRequest_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductOptions" type="{http://toi.ru/model/productinfo}ProductOptions_Type" minOccurs="0"/>
 *         &lt;element name="ClientInfo" type="{http://toi.ru/model/gw/client}ClientInfo_Type" maxOccurs="unbounded"/>
 *         &lt;element name="DeliveryMethod" type="{http://toi.ru/model/common}DeliveryMethod_Type"/>
 *         &lt;element name="PaymentMethod" type="{http://www.example.org/PaymentCommon}PaymentMethod_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatePolicyRequest_Type", propOrder = {
    "header",
    "productName",
    "productOptions",
    "clientInfo",
    "deliveryMethod",
    "paymentMethod"
})
public class CreatePolicyRequestType {

    @XmlElement(name = "Header")
    protected MessageHeaderType header;
    @XmlElement(name = "ProductName", required = true)
    protected String productName;
    @XmlElement(name = "ProductOptions")
    protected ProductOptionsType productOptions;
    @XmlElement(name = "ClientInfo", required = true)
    protected List<ClientInfoType> clientInfo;
    @XmlElement(name = "DeliveryMethod", required = true)
    protected DeliveryMethodType deliveryMethod;
    @XmlElement(name = "PaymentMethod", required = true)
    protected PaymentMethodType paymentMethod;

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
     * Gets the value of the clientInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clientInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClientInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClientInfoType }
     * 
     * 
     */
    public List<ClientInfoType> getClientInfo() {
        if (clientInfo == null) {
            clientInfo = new ArrayList<ClientInfoType>();
        }
        return this.clientInfo;
    }

    /**
     * Gets the value of the deliveryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryMethodType }
     *     
     */
    public DeliveryMethodType getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the value of the deliveryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryMethodType }
     *     
     */
    public void setDeliveryMethod(DeliveryMethodType value) {
        this.deliveryMethod = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodType }
     *     
     */
    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodType }
     *     
     */
    public void setPaymentMethod(PaymentMethodType value) {
        this.paymentMethod = value;
    }

}
