
package ru.toi.esb.model.gw.policy;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.toi.esb.model.gw.policy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.toi.esb.model.gw.policy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnyPolicyInfoType }
     * 
     */
    public AnyPolicyInfoType createAnyPolicyInfoType() {
        return new AnyPolicyInfoType();
    }

    /**
     * Create an instance of {@link UnderwritingIssueType }
     * 
     */
    public UnderwritingIssueType createUnderwritingIssueType() {
        return new UnderwritingIssueType();
    }

    /**
     * Create an instance of {@link PolicyInfoType }
     * 
     */
    public PolicyInfoType createPolicyInfoType() {
        return new PolicyInfoType();
    }

    /**
     * Create an instance of {@link CovTermType }
     * 
     */
    public CovTermType createCovTermType() {
        return new CovTermType();
    }

    /**
     * Create an instance of {@link CASCOPolicyInfoType }
     * 
     */
    public CASCOPolicyInfoType createCASCOPolicyInfoType() {
        return new CASCOPolicyInfoType();
    }

    /**
     * Create an instance of {@link CoverageType }
     * 
     */
    public CoverageType createCoverageType() {
        return new CoverageType();
    }

    /**
     * Create an instance of {@link OSAGOPolicyInfoType }
     * 
     */
    public OSAGOPolicyInfoType createOSAGOPolicyInfoType() {
        return new OSAGOPolicyInfoType();
    }

}
