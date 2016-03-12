
package ru.toi.model.gw.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.toi.model.common.CrossIDType;
import ru.toi.model.common.GenderType;
import ru.toi.model.gw.quote.property.CountriyCodeType;


/**
 * <p>Java class for ClientInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://toi.ru/model/common}CrossID_Type" minOccurs="0"/>
 *         &lt;element name="AccountRole" type="{http://toi.ru/model/gw/client}AccountRole_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccountType" type="{http://toi.ru/model/gw/client}AccountType_Type" minOccurs="0"/>
 *         &lt;element name="IsSelfEmployed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastNameEng" type="{http://toi.ru/model/gw/client}EngOnlyString_Type" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstNameEng" type="{http://toi.ru/model/gw/client}EngOnlyString_Type" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birthdate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://toi.ru/model/common}Email_Type" minOccurs="0"/>
 *         &lt;element name="EmailSecondary" type="{http://toi.ru/model/common}Email_Type" minOccurs="0"/>
 *         &lt;element name="MobilePhone" type="{http://toi.ru/model/common}Phone_Type" minOccurs="0"/>
 *         &lt;element name="MobilePhoneSecondary" type="{http://toi.ru/model/common}Phone_Type" minOccurs="0"/>
 *         &lt;element name="HomePhone" type="{http://toi.ru/model/common}Phone_Type" minOccurs="0"/>
 *         &lt;element name="OtherPhone" type="{http://toi.ru/model/common}Phone_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://toi.ru/model/common}Phone_Type" minOccurs="0"/>
 *         &lt;element name="ForeignPhone" type="{http://toi.ru/model/common}Phone_Type" minOccurs="0"/>
 *         &lt;element name="BirthCountry" type="{http://toi.ru/model/gw/quote/property}CountriyCode_Type" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://toi.ru/model/common}Gender_Type" minOccurs="0"/>
 *         &lt;element name="INN" type="{http://toi.ru/model/common}INN_Type" minOccurs="0"/>
 *         &lt;element name="Citizenship" type="{http://toi.ru/model/gw/quote/property}CountriyCode_Type" minOccurs="0"/>
 *         &lt;element name="SNILS" type="{http://toi.ru/model/common}SNILS_Type" minOccurs="0"/>
 *         &lt;element name="TypePrimaryPhone" type="{http://toi.ru/model/gw/client}TypePrimaryPhone_Type" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://toi.ru/model/common}Language_Type" minOccurs="0"/>
 *         &lt;element name="BusinessRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://toi.ru/model/gw/client}Address_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Document" type="{http://toi.ru/model/gw/client}Document_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://toi.ru/model/gw/client}ClientStatus_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IsPolicyParticipant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PhoneArray" type="{http://toi.ru/model/gw/client}PhoneArray_Type" minOccurs="0"/>
 *         &lt;element name="AccountArray" type="{http://toi.ru/model/gw/client}AccountArray_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientInfo_Type", propOrder = {
    "id",
    "accountRole",
    "accountType",
    "isSelfEmployed",
    "lastName",
    "lastNameEng",
    "firstName",
    "firstNameEng",
    "middleName",
    "birthdate",
    "email",
    "emailSecondary",
    "mobilePhone",
    "mobilePhoneSecondary",
    "homePhone",
    "otherPhone",
    "fax",
    "foreignPhone",
    "birthCountry",
    "gender",
    "inn",
    "citizenship",
    "snils",
    "typePrimaryPhone",
    "language",
    "businessRole",
    "address",
    "document",
    "status",
    "isPolicyParticipant",
    "phoneArray",
    "accountArray"
})
public class ClientInfoType {

    @XmlElement(name = "ID")
    protected CrossIDType id;
    @XmlElement(name = "AccountRole")
    protected List<AccountRoleType> accountRole;
    @XmlElement(name = "AccountType")
    protected AccountTypeType accountType;
    @XmlElement(name = "IsSelfEmployed")
    protected Boolean isSelfEmployed;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "LastNameEng")
    protected String lastNameEng;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "FirstNameEng")
    protected String firstNameEng;
    @XmlElement(name = "MiddleName")
    protected String middleName;
    @XmlElement(name = "Birthdate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthdate;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "EmailSecondary")
    protected String emailSecondary;
    @XmlElement(name = "MobilePhone")
    protected String mobilePhone;
    @XmlElement(name = "MobilePhoneSecondary")
    protected String mobilePhoneSecondary;
    @XmlElement(name = "HomePhone")
    protected String homePhone;
    @XmlElement(name = "OtherPhone")
    protected List<String> otherPhone;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "ForeignPhone")
    protected String foreignPhone;
    @XmlElement(name = "BirthCountry")
    protected CountriyCodeType birthCountry;
    @XmlElement(name = "Gender")
    protected GenderType gender;
    @XmlElement(name = "INN")
    protected String inn;
    @XmlElement(name = "Citizenship")
    protected CountriyCodeType citizenship;
    @XmlElement(name = "SNILS")
    protected String snils;
    @XmlElement(name = "TypePrimaryPhone")
    protected TypePrimaryPhoneType typePrimaryPhone;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "BusinessRole")
    protected String businessRole;
    @XmlElement(name = "Address")
    protected List<AddressType> address;
    @XmlElement(name = "Document")
    protected List<DocumentType> document;
    @XmlElement(name = "Status")
    protected List<String> status;
    @XmlElement(name = "IsPolicyParticipant")
    protected Boolean isPolicyParticipant;
    @XmlElement(name = "PhoneArray")
    protected PhoneArrayType phoneArray;
    @XmlElement(name = "AccountArray")
    protected AccountArrayType accountArray;

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
     * Gets the value of the accountRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountRoleType }
     * 
     * 
     */
    public List<AccountRoleType> getAccountRole() {
        if (accountRole == null) {
            accountRole = new ArrayList<AccountRoleType>();
        }
        return this.accountRole;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link AccountTypeType }
     *     
     */
    public AccountTypeType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountTypeType }
     *     
     */
    public void setAccountType(AccountTypeType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the isSelfEmployed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsSelfEmployed() {
        return isSelfEmployed;
    }

    /**
     * Sets the value of the isSelfEmployed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSelfEmployed(Boolean value) {
        this.isSelfEmployed = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the lastNameEng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNameEng() {
        return lastNameEng;
    }

    /**
     * Sets the value of the lastNameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNameEng(String value) {
        this.lastNameEng = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the firstNameEng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstNameEng() {
        return firstNameEng;
    }

    /**
     * Sets the value of the firstNameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstNameEng(String value) {
        this.firstNameEng = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthdate(XMLGregorianCalendar value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the emailSecondary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailSecondary() {
        return emailSecondary;
    }

    /**
     * Sets the value of the emailSecondary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailSecondary(String value) {
        this.emailSecondary = value;
    }

    /**
     * Gets the value of the mobilePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets the value of the mobilePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhone(String value) {
        this.mobilePhone = value;
    }

    /**
     * Gets the value of the mobilePhoneSecondary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilePhoneSecondary() {
        return mobilePhoneSecondary;
    }

    /**
     * Sets the value of the mobilePhoneSecondary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhoneSecondary(String value) {
        this.mobilePhoneSecondary = value;
    }

    /**
     * Gets the value of the homePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the value of the homePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomePhone(String value) {
        this.homePhone = value;
    }

    /**
     * Gets the value of the otherPhone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherPhone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherPhone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOtherPhone() {
        if (otherPhone == null) {
            otherPhone = new ArrayList<String>();
        }
        return this.otherPhone;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the foreignPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignPhone() {
        return foreignPhone;
    }

    /**
     * Sets the value of the foreignPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignPhone(String value) {
        this.foreignPhone = value;
    }

    /**
     * Gets the value of the birthCountry property.
     * 
     * @return
     *     possible object is
     *     {@link CountriyCodeType }
     *     
     */
    public CountriyCodeType getBirthCountry() {
        return birthCountry;
    }

    /**
     * Sets the value of the birthCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountriyCodeType }
     *     
     */
    public void setBirthCountry(CountriyCodeType value) {
        this.birthCountry = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link GenderType }
     *     
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderType }
     *     
     */
    public void setGender(GenderType value) {
        this.gender = value;
    }

    /**
     * Gets the value of the inn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINN() {
        return inn;
    }

    /**
     * Sets the value of the inn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINN(String value) {
        this.inn = value;
    }

    /**
     * Gets the value of the citizenship property.
     * 
     * @return
     *     possible object is
     *     {@link CountriyCodeType }
     *     
     */
    public CountriyCodeType getCitizenship() {
        return citizenship;
    }

    /**
     * Sets the value of the citizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountriyCodeType }
     *     
     */
    public void setCitizenship(CountriyCodeType value) {
        this.citizenship = value;
    }

    /**
     * Gets the value of the snils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNILS() {
        return snils;
    }

    /**
     * Sets the value of the snils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNILS(String value) {
        this.snils = value;
    }

    /**
     * Gets the value of the typePrimaryPhone property.
     * 
     * @return
     *     possible object is
     *     {@link TypePrimaryPhoneType }
     *     
     */
    public TypePrimaryPhoneType getTypePrimaryPhone() {
        return typePrimaryPhone;
    }

    /**
     * Sets the value of the typePrimaryPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypePrimaryPhoneType }
     *     
     */
    public void setTypePrimaryPhone(TypePrimaryPhoneType value) {
        this.typePrimaryPhone = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the businessRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRole() {
        return businessRole;
    }

    /**
     * Sets the value of the businessRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRole(String value) {
        this.businessRole = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressType }
     * 
     * 
     */
    public List<AddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getDocument() {
        if (document == null) {
            document = new ArrayList<DocumentType>();
        }
        return this.document;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStatus() {
        if (status == null) {
            status = new ArrayList<String>();
        }
        return this.status;
    }

    /**
     * Gets the value of the isPolicyParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsPolicyParticipant() {
        return isPolicyParticipant;
    }

    /**
     * Sets the value of the isPolicyParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPolicyParticipant(Boolean value) {
        this.isPolicyParticipant = value;
    }

    /**
     * Gets the value of the phoneArray property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneArrayType }
     *     
     */
    public PhoneArrayType getPhoneArray() {
        return phoneArray;
    }

    /**
     * Sets the value of the phoneArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneArrayType }
     *     
     */
    public void setPhoneArray(PhoneArrayType value) {
        this.phoneArray = value;
    }

    /**
     * Gets the value of the accountArray property.
     * 
     * @return
     *     possible object is
     *     {@link AccountArrayType }
     *     
     */
    public AccountArrayType getAccountArray() {
        return accountArray;
    }

    /**
     * Sets the value of the accountArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountArrayType }
     *     
     */
    public void setAccountArray(AccountArrayType value) {
        this.accountArray = value;
    }

}
