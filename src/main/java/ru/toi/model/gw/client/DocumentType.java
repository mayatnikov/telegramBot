
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.toi.model.common.CrossIDType;
import ru.toi.model.common.DocumentTypeType;


/**
 * 
 *     			Документ удостоверяющий личность
 *     		
 * 
 * <p>Java class for Document_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://toi.ru/model/common}CrossID_Type" minOccurs="0"/>
 *         &lt;element name="DocumentType" type="{http://toi.ru/model/common}DocumentType_Type"/>
 *         &lt;element name="Series" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IssuedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateIssue" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateValid" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SubdivisionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document_Type", propOrder = {
    "id",
    "documentType",
    "series",
    "number",
    "issuedBy",
    "dateIssue",
    "dateValid",
    "subdivisionCode",
    "isActive"
})
public class DocumentType {

    @XmlElement(name = "ID")
    protected CrossIDType id;
    @XmlElement(name = "DocumentType", required = true)
    protected DocumentTypeType documentType;
    @XmlElement(name = "Series", required = true)
    protected String series;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "IssuedBy")
    protected String issuedBy;
    @XmlElement(name = "DateIssue")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateIssue;
    @XmlElement(name = "DateValid")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateValid;
    @XmlElement(name = "SubdivisionCode")
    protected String subdivisionCode;
    @XmlElement(name = "IsActive")
    protected boolean isActive;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link CrossIDType }
     *     
     */
    public CrossIDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossIDType }
     *     
     */
    public void setID(CrossIDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentTypeType }
     *     
     */
    public DocumentTypeType getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentTypeType }
     *     
     */
    public void setDocumentType(DocumentTypeType value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the issuedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuedBy() {
        return issuedBy;
    }

    /**
     * Sets the value of the issuedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuedBy(String value) {
        this.issuedBy = value;
    }

    /**
     * Gets the value of the dateIssue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIssue() {
        return dateIssue;
    }

    /**
     * Sets the value of the dateIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIssue(XMLGregorianCalendar value) {
        this.dateIssue = value;
    }

    /**
     * Gets the value of the dateValid property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValid() {
        return dateValid;
    }

    /**
     * Sets the value of the dateValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValid(XMLGregorianCalendar value) {
        this.dateValid = value;
    }

    /**
     * Gets the value of the subdivisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubdivisionCode() {
        return subdivisionCode;
    }

    /**
     * Sets the value of the subdivisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubdivisionCode(String value) {
        this.subdivisionCode = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

}
