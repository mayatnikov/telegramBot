
package ru.toi.esb.model.gw.policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.toi.model.common.CrossIDType;
import ru.toi.model.common.DeliveryMethodType;
import ru.toi.model.gw.client.AddressType;
import ru.toi.model.gw.client.ClientInfoType;


/**
 * <p>Java class for OSAGOPolicyInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSAGOPolicyInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://toi.ru/model/common}CrossID_Type" minOccurs="0"/>
 *         &lt;element name="AccHolderEmailAddress" type="{http://toi.ru/model/common}Email_Type" minOccurs="0"/>
 *         &lt;element name="AccHolderPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccHolderPostAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Canceled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeliveryMethod" type="{http://toi.ru/model/common}DeliveryMethod_Type" minOccurs="0"/>
 *         &lt;element name="DiscountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FirstPayment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FixedAmountDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IsMultipleDiscount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Issued" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="JobCloseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="JobSubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientInfo" type="{http://toi.ru/model/gw/client}ClientInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Offering" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PercentageDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PolicyLocation" type="{http://toi.ru/model/gw/client}Address_Type" minOccurs="0"/>
 *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyPublicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TermNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TermType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalCoveredAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TotalPremium" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VehicleID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSAGOPolicyInfo_Type", propOrder = {
    "id",
    "accHolderEmailAddress",
    "accHolderPhoneNumber",
    "accHolderPostAddress",
    "accountNumber",
    "actionTemplate",
    "canceled",
    "deliveryMethod",
    "discountType",
    "endDate",
    "firstPayment",
    "fixedAmountDiscount",
    "isMultipleDiscount",
    "issued",
    "jobCloseDate",
    "jobSubtype",
    "clientInfo",
    "offering",
    "payments",
    "percentageDiscount",
    "policyLocation",
    "policyNumber",
    "policyPublicId",
    "policyType",
    "product",
    "startDate",
    "status",
    "termNumber",
    "termType",
    "totalCoveredAmount",
    "totalPremium",
    "currency",
    "vehicleID"
})
public class OSAGOPolicyInfoType {

    @XmlElement(name = "ID")
    protected CrossIDType id;
    @XmlElement(name = "AccHolderEmailAddress")
    protected String accHolderEmailAddress;
    @XmlElement(name = "AccHolderPhoneNumber")
    protected String accHolderPhoneNumber;
    @XmlElement(name = "AccHolderPostAddress")
    protected String accHolderPostAddress;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "ActionTemplate")
    protected String actionTemplate;
    @XmlElement(name = "Canceled")
    protected Boolean canceled;
    @XmlElement(name = "DeliveryMethod")
    protected DeliveryMethodType deliveryMethod;
    @XmlElement(name = "DiscountType")
    protected String discountType;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "FirstPayment")
    protected BigDecimal firstPayment;
    @XmlElement(name = "FixedAmountDiscount")
    protected BigDecimal fixedAmountDiscount;
    @XmlElement(name = "IsMultipleDiscount")
    protected Boolean isMultipleDiscount;
    @XmlElement(name = "Issued")
    protected Boolean issued;
    @XmlElement(name = "JobCloseDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobCloseDate;
    @XmlElement(name = "JobSubtype")
    protected String jobSubtype;
    @XmlElement(name = "ClientInfo")
    protected List<ClientInfoType> clientInfo;
    @XmlElement(name = "Offering")
    protected String offering;
    @XmlElement(name = "Payments")
    protected String payments;
    @XmlElement(name = "PercentageDiscount")
    protected BigDecimal percentageDiscount;
    @XmlElement(name = "PolicyLocation")
    protected AddressType policyLocation;
    @XmlElement(name = "PolicyNumber")
    protected String policyNumber;
    @XmlElement(name = "PolicyPublicId")
    protected String policyPublicId;
    @XmlElement(name = "PolicyType")
    protected String policyType;
    @XmlElement(name = "Product")
    protected String product;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "TermNumber")
    protected String termNumber;
    @XmlElement(name = "TermType")
    protected String termType;
    @XmlElement(name = "TotalCoveredAmount")
    protected BigDecimal totalCoveredAmount;
    @XmlElement(name = "TotalPremium")
    protected BigDecimal totalPremium;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "VehicleID")
    protected String vehicleID;

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
     * Gets the value of the accHolderEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderEmailAddress() {
        return accHolderEmailAddress;
    }

    /**
     * Sets the value of the accHolderEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderEmailAddress(String value) {
        this.accHolderEmailAddress = value;
    }

    /**
     * Gets the value of the accHolderPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderPhoneNumber() {
        return accHolderPhoneNumber;
    }

    /**
     * Sets the value of the accHolderPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderPhoneNumber(String value) {
        this.accHolderPhoneNumber = value;
    }

    /**
     * Gets the value of the accHolderPostAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderPostAddress() {
        return accHolderPostAddress;
    }

    /**
     * Sets the value of the accHolderPostAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderPostAddress(String value) {
        this.accHolderPostAddress = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the actionTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionTemplate() {
        return actionTemplate;
    }

    /**
     * Sets the value of the actionTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionTemplate(String value) {
        this.actionTemplate = value;
    }

    /**
     * Gets the value of the canceled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCanceled() {
        return canceled;
    }

    /**
     * Sets the value of the canceled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanceled(Boolean value) {
        this.canceled = value;
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
     * Gets the value of the discountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Sets the value of the discountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountType(String value) {
        this.discountType = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the firstPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFirstPayment() {
        return firstPayment;
    }

    /**
     * Sets the value of the firstPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFirstPayment(BigDecimal value) {
        this.firstPayment = value;
    }

    /**
     * Gets the value of the fixedAmountDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFixedAmountDiscount() {
        return fixedAmountDiscount;
    }

    /**
     * Sets the value of the fixedAmountDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFixedAmountDiscount(BigDecimal value) {
        this.fixedAmountDiscount = value;
    }

    /**
     * Gets the value of the isMultipleDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsMultipleDiscount() {
        return isMultipleDiscount;
    }

    /**
     * Sets the value of the isMultipleDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMultipleDiscount(Boolean value) {
        this.isMultipleDiscount = value;
    }

    /**
     * Gets the value of the issued property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIssued() {
        return issued;
    }

    /**
     * Sets the value of the issued property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIssued(Boolean value) {
        this.issued = value;
    }

    /**
     * Gets the value of the jobCloseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobCloseDate() {
        return jobCloseDate;
    }

    /**
     * Sets the value of the jobCloseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobCloseDate(XMLGregorianCalendar value) {
        this.jobCloseDate = value;
    }

    /**
     * Gets the value of the jobSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobSubtype() {
        return jobSubtype;
    }

    /**
     * Sets the value of the jobSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobSubtype(String value) {
        this.jobSubtype = value;
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
     * Gets the value of the offering property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffering() {
        return offering;
    }

    /**
     * Sets the value of the offering property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffering(String value) {
        this.offering = value;
    }

    /**
     * Gets the value of the payments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayments() {
        return payments;
    }

    /**
     * Sets the value of the payments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayments(String value) {
        this.payments = value;
    }

    /**
     * Gets the value of the percentageDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentageDiscount() {
        return percentageDiscount;
    }

    /**
     * Sets the value of the percentageDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentageDiscount(BigDecimal value) {
        this.percentageDiscount = value;
    }

    /**
     * Gets the value of the policyLocation property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getPolicyLocation() {
        return policyLocation;
    }

    /**
     * Sets the value of the policyLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setPolicyLocation(AddressType value) {
        this.policyLocation = value;
    }

    /**
     * Gets the value of the policyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the value of the policyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNumber(String value) {
        this.policyNumber = value;
    }

    /**
     * Gets the value of the policyPublicId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyPublicId() {
        return policyPublicId;
    }

    /**
     * Sets the value of the policyPublicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyPublicId(String value) {
        this.policyPublicId = value;
    }

    /**
     * Gets the value of the policyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the value of the policyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyType(String value) {
        this.policyType = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

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
     * Gets the value of the termNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermNumber() {
        return termNumber;
    }

    /**
     * Sets the value of the termNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermNumber(String value) {
        this.termNumber = value;
    }

    /**
     * Gets the value of the termType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermType() {
        return termType;
    }

    /**
     * Sets the value of the termType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermType(String value) {
        this.termType = value;
    }

    /**
     * Gets the value of the totalCoveredAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCoveredAmount() {
        return totalCoveredAmount;
    }

    /**
     * Sets the value of the totalCoveredAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCoveredAmount(BigDecimal value) {
        this.totalCoveredAmount = value;
    }

    /**
     * Gets the value of the totalPremium property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPremium() {
        return totalPremium;
    }

    /**
     * Sets the value of the totalPremium property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPremium(BigDecimal value) {
        this.totalPremium = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

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

}
