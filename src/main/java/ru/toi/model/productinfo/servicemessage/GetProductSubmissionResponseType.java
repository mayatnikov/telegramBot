
package ru.toi.model.productinfo.servicemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.model.common.MessageHeaderType;
import ru.toi.model.productinfo.ProductTypeType;


/**
 * <p>Java class for GetProductSubmissionResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProductSubmissionResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://toi.ru/model/productinfo}ProductType_Type" minOccurs="0"/>
 *         &lt;element name="QuoteXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProductSubmissionResponse_Type", propOrder = {
    "header",
    "productType",
    "quoteXML"
})
public class GetProductSubmissionResponseType {

    @XmlElement(name = "Header")
    protected MessageHeaderType header;
    @XmlElement(name = "ProductType")
    protected ProductTypeType productType;
    @XmlElement(name = "QuoteXML")
    protected String quoteXML;

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
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTypeType }
     *     
     */
    public ProductTypeType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTypeType }
     *     
     */
    public void setProductType(ProductTypeType value) {
        this.productType = value;
    }

    /**
     * Gets the value of the quoteXML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteXML() {
        return quoteXML;
    }

    /**
     * Sets the value of the quoteXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteXML(String value) {
        this.quoteXML = value;
    }

}
