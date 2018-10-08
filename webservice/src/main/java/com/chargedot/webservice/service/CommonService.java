package com.chargedot.webservice.service;

import com.chargedot.webservice.domain.Student;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.*;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/8/14
 */
@WebService(name = "CommonService", //暴露服务名称
        targetNamespace = "http://service.webservice.chargedot.com/" //命名空间，一般是接口的包名倒序
)
public interface CommonService {

    @WebMethod
    @WebResult(name = "String")
    String sayHello(@WebParam(name = "username") String name);

    @WebMethod
    boolean addStudent(Student s);

    @WebMethod
    Student getStudentById(int id);

    @WebMethod
    List<Student> getStudentsByPrice(float price);

    @WebMethod
    Map<Integer, Student> getAllStudents();


}
