
package ru.toi.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *     			Operation result
 *     		
 * 
 * <p>Java class for Result_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Result_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="OK"/>
 *               &lt;enumeration value="ERROR"/>
 *               &lt;enumeration value="BUSINESS_ERROR"/>
 *               &lt;enumeration value="WARNING"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="errorInfo" type="{http://toi.ru/model/common}ErrorInfo_Type" minOccurs="0"/>
 *         &lt;element name="nativeErrorInfo" type="{http://toi.ru/model/common}ErrorInfo_Type" minOccurs="0"/>
 *         &lt;element name="businessError" type="{http://toi.ru/model/common}ErrorInfo_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Result_Type", propOrder = {
    "status",
    "errorInfo",
    "nativeErrorInfo",
    "businessError"
})
public class ResultType {

    @XmlElement(required = true)
    protected String status;
    protected ErrorInfoType errorInfo;
    protected ErrorInfoType nativeErrorInfo;
    protected ErrorInfoType businessError;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the errorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfoType }
     *     
     */
    public ErrorInfoType getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets the value of the errorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfoType }
     *     
     */
    public void setErrorInfo(ErrorInfoType value) {
        this.errorInfo = value;
    }

    /**
     * Gets the value of the nativeErrorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfoType }
     *     
     */
    public ErrorInfoType getNativeErrorInfo() {
        return nativeErrorInfo;
    }

    /**
     * Sets the value of the nativeErrorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfoType }
     *     
     */
    public void setNativeErrorInfo(ErrorInfoType value) {
        this.nativeErrorInfo = value;
    }

    /**
     * Gets the value of the businessError property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfoType }
     *     
     */
    public ErrorInfoType getBusinessError() {
        return businessError;
    }

    /**
     * Sets the value of the businessError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfoType }
     *     
     */
    public void setBusinessError(ErrorInfoType value) {
        this.businessError = value;
    }

}
