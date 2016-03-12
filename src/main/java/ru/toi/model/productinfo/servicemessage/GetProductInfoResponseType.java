
package ru.toi.model.productinfo.servicemessage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;
import ru.toi.model.productinfo.MotorProductInfoType;
import ru.toi.model.productinfo.ProductInfoType;


/**
 * <p>Java class for GetProductInfoResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProductInfoResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type"/>
 *         &lt;element name="ProductInfo" type="{http://toi.ru/model/productinfo}ProductInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MotorProductInfo" type="{http://toi.ru/model/productinfo}MotorProductInfo_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProductInfoResponse_Type", propOrder = {
    "header",
    "productInfo",
    "motorProductInfo"
})
public class GetProductInfoResponseType {

    @XmlElement(name = "Header", required = true)
    protected MessageHeaderType header;
    @XmlElement(name = "ProductInfo")
    protected List<ProductInfoType> productInfo;
    @XmlElement(name = "MotorProductInfo")
    protected MotorProductInfoType motorProductInfo;

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
     * Gets the value of the productInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfoType }
     * 
     * 
     */
    public List<ProductInfoType> getProductInfo() {
        if (productInfo == null) {
            productInfo = new ArrayList<ProductInfoType>();
        }
        return this.productInfo;
    }

    /**
     * Gets the value of the motorProductInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MotorProductInfoType }
     *     
     */
    public MotorProductInfoType getMotorProductInfo() {
        return motorProductInfo;
    }

    /**
     * Sets the value of the motorProductInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotorProductInfoType }
     *     
     */
    public void setMotorProductInfo(MotorProductInfoType value) {
        this.motorProductInfo = value;
    }

}
