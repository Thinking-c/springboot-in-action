
package com.chargedot.webservice.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chargedot.webservice.service package. 
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

    private final static QName _AddStudent_QNAME = new QName("http://service.webservice.chargedot.com/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://service.webservice.chargedot.com/", "addStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://service.webservice.chargedot.com/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://service.webservice.chargedot.com/", "getAllStudentsResponse");
    private final static QName _GetStudentById_QNAME = new QName("http://service.webservice.chargedot.com/", "getStudentById");
    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://service.webservice.chargedot.com/", "getStudentByIdResponse");
    private final static QName _GetStudentsByPrice_QNAME = new QName("http://service.webservice.chargedot.com/", "getStudentsByPrice");
    private final static QName _GetStudentsByPriceResponse_QNAME = new QName("http://service.webservice.chargedot.com/", "getStudentsByPriceResponse");
    private final static QName _SayHello_QNAME = new QName("http://service.webservice.chargedot.com/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://service.webservice.chargedot.com/", "sayHelloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chargedot.webservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse.Return }
     * 
     */
    public GetAllStudentsResponse.Return createGetAllStudentsResponseReturn() {
        return new GetAllStudentsResponse.Return();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByPrice }
     * 
     */
    public GetStudentsByPrice createGetStudentsByPrice() {
        return new GetStudentsByPrice();
    }

    /**
     * Create an instance of {@link GetStudentsByPriceResponse }
     * 
     */
    public GetStudentsByPriceResponse createGetStudentsByPriceResponse() {
        return new GetStudentsByPriceResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse.Return.Entry }
     * 
     */
    public GetAllStudentsResponse.Return.Entry createGetAllStudentsResponseReturnEntry() {
        return new GetAllStudentsResponse.Return.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getStudentsByPrice")
    public JAXBElement<GetStudentsByPrice> createGetStudentsByPrice(GetStudentsByPrice value) {
        return new JAXBElement<GetStudentsByPrice>(_GetStudentsByPrice_QNAME, GetStudentsByPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "getStudentsByPriceResponse")
    public JAXBElement<GetStudentsByPriceResponse> createGetStudentsByPriceResponse(GetStudentsByPriceResponse value) {
        return new JAXBElement<GetStudentsByPriceResponse>(_GetStudentsByPriceResponse_QNAME, GetStudentsByPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.chargedot.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

}
