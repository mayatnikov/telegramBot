
package ru.toi.model.productinfo.servicemessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.toi.model.productinfo.servicemessage package. 
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

    private final static QName _GetProductQuoteRequest_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductQuoteRequest");
    private final static QName _GetProductSubmissionResponse_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductSubmissionResponse");
    private final static QName _GetProductListRequest_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductListRequest");
    private final static QName _GetProductQuoteResponse_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductQuoteResponse");
    private final static QName _GetProductSubmissionRequest_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductSubmissionRequest");
    private final static QName _GetProductInfoResponse_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductInfoResponse");
    private final static QName _GetProductListResponse_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductListResponse");
    private final static QName _GetProductInfoRequest_QNAME = new QName("http://toi.ru/model/productinfo/servicemessage", "getProductInfoRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.toi.model.productinfo.servicemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductInfoRequestType }
     * 
     */
    public GetProductInfoRequestType createGetProductInfoRequestType() {
        return new GetProductInfoRequestType();
    }

    /**
     * Create an instance of {@link GetProductListRequestType }
     * 
     */
    public GetProductListRequestType createGetProductListRequestType() {
        return new GetProductListRequestType();
    }

    /**
     * Create an instance of {@link GetProductQuoteResponseType }
     * 
     */
    public GetProductQuoteResponseType createGetProductQuoteResponseType() {
        return new GetProductQuoteResponseType();
    }

    /**
     * Create an instance of {@link GetProductSubmissionResponseType }
     * 
     */
    public GetProductSubmissionResponseType createGetProductSubmissionResponseType() {
        return new GetProductSubmissionResponseType();
    }

    /**
     * Create an instance of {@link GetProductQuoteRequestType }
     * 
     */
    public GetProductQuoteRequestType createGetProductQuoteRequestType() {
        return new GetProductQuoteRequestType();
    }

    /**
     * Create an instance of {@link GetProductInfoResponseType }
     * 
     */
    public GetProductInfoResponseType createGetProductInfoResponseType() {
        return new GetProductInfoResponseType();
    }

    /**
     * Create an instance of {@link GetProductListResponseType }
     * 
     */
    public GetProductListResponseType createGetProductListResponseType() {
        return new GetProductListResponseType();
    }

    /**
     * Create an instance of {@link GetProductSubmissionRequestType }
     * 
     */
    public GetProductSubmissionRequestType createGetProductSubmissionRequestType() {
        return new GetProductSubmissionRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductQuoteRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductQuoteRequest")
    public JAXBElement<GetProductQuoteRequestType> createGetProductQuoteRequest(GetProductQuoteRequestType value) {
        return new JAXBElement<GetProductQuoteRequestType>(_GetProductQuoteRequest_QNAME, GetProductQuoteRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductSubmissionResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductSubmissionResponse")
    public JAXBElement<GetProductSubmissionResponseType> createGetProductSubmissionResponse(GetProductSubmissionResponseType value) {
        return new JAXBElement<GetProductSubmissionResponseType>(_GetProductSubmissionResponse_QNAME, GetProductSubmissionResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductListRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductListRequest")
    public JAXBElement<GetProductListRequestType> createGetProductListRequest(GetProductListRequestType value) {
        return new JAXBElement<GetProductListRequestType>(_GetProductListRequest_QNAME, GetProductListRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductQuoteResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductQuoteResponse")
    public JAXBElement<GetProductQuoteResponseType> createGetProductQuoteResponse(GetProductQuoteResponseType value) {
        return new JAXBElement<GetProductQuoteResponseType>(_GetProductQuoteResponse_QNAME, GetProductQuoteResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductSubmissionRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductSubmissionRequest")
    public JAXBElement<GetProductSubmissionRequestType> createGetProductSubmissionRequest(GetProductSubmissionRequestType value) {
        return new JAXBElement<GetProductSubmissionRequestType>(_GetProductSubmissionRequest_QNAME, GetProductSubmissionRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductInfoResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductInfoResponse")
    public JAXBElement<GetProductInfoResponseType> createGetProductInfoResponse(GetProductInfoResponseType value) {
        return new JAXBElement<GetProductInfoResponseType>(_GetProductInfoResponse_QNAME, GetProductInfoResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductListResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductListResponse")
    public JAXBElement<GetProductListResponseType> createGetProductListResponse(GetProductListResponseType value) {
        return new JAXBElement<GetProductListResponseType>(_GetProductListResponse_QNAME, GetProductListResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toi.ru/model/productinfo/servicemessage", name = "getProductInfoRequest")
    public JAXBElement<GetProductInfoRequestType> createGetProductInfoRequest(GetProductInfoRequestType value) {
        return new JAXBElement<GetProductInfoRequestType>(_GetProductInfoRequest_QNAME, GetProductInfoRequestType.class, null, value);
    }

}
