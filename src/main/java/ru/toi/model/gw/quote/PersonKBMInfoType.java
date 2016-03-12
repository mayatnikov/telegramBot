
package ru.toi.model.gw.quote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonKBMInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonKBMInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KBMInfo" type="{http://toi.ru/model/gw/quote}KBMInfo_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonKBMInfo_Type", propOrder = {
    "personID",
    "kbmInfo"
})
public class PersonKBMInfoType {

    @XmlElement(name = "PersonID")
    protected String personID;
    @XmlElement(name = "KBMInfo")
    protected KBMInfoType kbmInfo;

    /**
     * Gets the value of the personID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * Sets the value of the personID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonID(String value) {
        this.personID = value;
    }

    /**
     * Gets the value of the kbmInfo property.
     * 
     * @return
     *     possible object is
     *     {@link KBMInfoType }
     *     
     */
    public KBMInfoType getKBMInfo() {
        return kbmInfo;
    }

    /**
     * Sets the value of the kbmInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link KBMInfoType }
     *     
     */
    public void setKBMInfo(KBMInfoType value) {
        this.kbmInfo = value;
    }

}
