
package ru.toi.model.gw.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.toi.model.gw.client package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.toi.model.gw.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientInfoType }
     * 
     */
    public ClientInfoType createClientInfoType() {
        return new ClientInfoType();
    }

    /**
     * Create an instance of {@link AccountArrayType }
     * 
     */
    public AccountArrayType createAccountArrayType() {
        return new AccountArrayType();
    }

    /**
     * Create an instance of {@link PhoneArrayEntryType }
     * 
     */
    public PhoneArrayEntryType createPhoneArrayEntryType() {
        return new PhoneArrayEntryType();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link AccountArrayEntryType }
     * 
     */
    public AccountArrayEntryType createAccountArrayEntryType() {
        return new AccountArrayEntryType();
    }

    /**
     * Create an instance of {@link PhoneArrayType }
     * 
     */
    public PhoneArrayType createPhoneArrayType() {
        return new PhoneArrayType();
    }

}
