
package ru.toi.esb.model.servicemessagesext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.toi.esb.model.gw.policy.CASCOPolicyInfoType;
import ru.toi.esb.model.gw.policy.OSAGOPolicyInfoType;
import ru.toi.esb.model.gw.policy.UnderwritingIssueType;
import ru.toi.model.common.MessageHeaderType;


/**
 * <p>Java class for CreateMotorSubmissionResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateMotorSubmissionResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://toi.ru/model/common}MessageHeader_Type"/>
 *         &lt;element name="OSAGOPolicyInfo" type="{http://toi.ru/esb/model/gw/policy}OSAGOPolicyInfo_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CASCOPolicyInfo" type="{http://toi.ru/esb/model/gw/policy}CASCOPolicyInfo_Type" minOccurs="0"/>
 *         &lt;element name="UnderwritingIssue" type="{http://toi.ru/esb/model/gw/policy}UnderwritingIssue_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateMotorSubmissionResponse_Type", propOrder = {
    "header",
    "osagoPolicyInfo",
    "cascoPolicyInfo",
    "underwritingIssue"
})
public class CreateMotorSubmissionResponseType {

    @XmlElement(name = "Header", required = true)
    protected MessageHeaderType header;
    @XmlElement(name = "OSAGOPolicyInfo")
    protected List<OSAGOPolicyInfoType> osagoPolicyInfo;
    @XmlElement(name = "CASCOPolicyInfo")
    protected CASCOPolicyInfoType cascoPolicyInfo;
    @XmlElement(name = "UnderwritingIssue")
    protected List<UnderwritingIssueType> underwritingIssue;

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
     * Gets the value of the osagoPolicyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osagoPolicyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOSAGOPolicyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OSAGOPolicyInfoType }
     * 
     * 
     */
    public List<OSAGOPolicyInfoType> getOSAGOPolicyInfo() {
        if (osagoPolicyInfo == null) {
            osagoPolicyInfo = new ArrayList<OSAGOPolicyInfoType>();
        }
        return this.osagoPolicyInfo;
    }

    /**
     * Gets the value of the cascoPolicyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CASCOPolicyInfoType }
     *     
     */
    public CASCOPolicyInfoType getCASCOPolicyInfo() {
        return cascoPolicyInfo;
    }

    /**
     * Sets the value of the cascoPolicyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CASCOPolicyInfoType }
     *     
     */
    public void setCASCOPolicyInfo(CASCOPolicyInfoType value) {
        this.cascoPolicyInfo = value;
    }

    /**
     * Gets the value of the underwritingIssue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the underwritingIssue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnderwritingIssue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnderwritingIssueType }
     * 
     * 
     */
    public List<UnderwritingIssueType> getUnderwritingIssue() {
        if (underwritingIssue == null) {
            underwritingIssue = new ArrayList<UnderwritingIssueType>();
        }
        return this.underwritingIssue;
    }

}
