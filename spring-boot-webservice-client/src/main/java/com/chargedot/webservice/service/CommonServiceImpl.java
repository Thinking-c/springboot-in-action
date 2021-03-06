package com.chargedot.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-08-16T11:40:20.317+08:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://service.webservice.chargedot.com/", name = "CommonServiceImpl")
@XmlSeeAlso({ObjectFactory.class})
public interface CommonServiceImpl {

    @WebMethod
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.AddStudentResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean addStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        com.chargedot.webservice.service.Student arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentsByPrice", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetStudentsByPrice")
    @ResponseWrapper(localName = "getStudentsByPriceResponse", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetStudentsByPriceResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.chargedot.webservice.service.Student> getStudentsByPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0
    );

    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.SayHelloResponse")
    @WebResult(name = "String", targetNamespace = "")
    public java.lang.String sayHello(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentById", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetStudentById")
    @ResponseWrapper(localName = "getStudentByIdResponse", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetStudentByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.chargedot.webservice.service.Student getStudentById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getAllStudents", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetAllStudents")
    @ResponseWrapper(localName = "getAllStudentsResponse", targetNamespace = "http://service.webservice.chargedot.com/", className = "com.chargedot.webservice.service.GetAllStudentsResponse")
    @WebResult(name = "_return", targetNamespace = "")
    public com.chargedot.webservice.service.GetAllStudentsResponse.Return getAllStudents();
}
