
package ru.toi.model.productinfo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.toi.model.productinfo package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.toi.model.productinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValueInfoType }
     * 
     */
    public ValueInfoType createValueInfoType() {
        return new ValueInfoType();
    }

    /**
     * Create an instance of {@link ProductInfoType }
     * 
     */
    public ProductInfoType createProductInfoType() {
        return new ProductInfoType();
    }

    /**
     * Create an instance of {@link ProductOptionsType }
     * 
     */
    public ProductOptionsType createProductOptionsType() {
        return new ProductOptionsType();
    }

    /**
     * Create an instance of {@link ProductOptionType }
     * 
     */
    public ProductOptionType createProductOptionType() {
        return new ProductOptionType();
    }

    /**
     * Create an instance of {@link MotorProductInfoType }
     * 
     */
    public MotorProductInfoType createMotorProductInfoType() {
        return new MotorProductInfoType();
    }

    /**
     * Create an instance of {@link PersonOptionsType }
     * 
     */
    public PersonOptionsType createPersonOptionsType() {
        return new PersonOptionsType();
    }

    /**
     * Create an instance of {@link DisplaibleValueType }
     * 
     */
    public DisplaibleValueType createDisplaibleValueType() {
        return new DisplaibleValueType();
    }

    /**
     * Create an instance of {@link VehicleOptionsType }
     * 
     */
    public VehicleOptionsType createVehicleOptionsType() {
        return new VehicleOptionsType();
    }

}
