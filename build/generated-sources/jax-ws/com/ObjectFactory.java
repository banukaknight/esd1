
package com;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com package. 
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

    private final static QName _CalculateTotal_QNAME = new QName("http://wspackage/", "calculateTotal");
    private final static QName _CalculateTotalResponse_QNAME = new QName("http://wspackage/", "calculateTotalResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateTotal }
     * 
     */
    public CalculateTotal createCalculateTotal() {
        return new CalculateTotal();
    }

    /**
     * Create an instance of {@link CalculateTotalResponse }
     * 
     */
    public CalculateTotalResponse createCalculateTotalResponse() {
        return new CalculateTotalResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateTotal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspackage/", name = "calculateTotal")
    public JAXBElement<CalculateTotal> createCalculateTotal(CalculateTotal value) {
        return new JAXBElement<CalculateTotal>(_CalculateTotal_QNAME, CalculateTotal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateTotalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspackage/", name = "calculateTotalResponse")
    public JAXBElement<CalculateTotalResponse> createCalculateTotalResponse(CalculateTotalResponse value) {
        return new JAXBElement<CalculateTotalResponse>(_CalculateTotalResponse_QNAME, CalculateTotalResponse.class, null, value);
    }

}
