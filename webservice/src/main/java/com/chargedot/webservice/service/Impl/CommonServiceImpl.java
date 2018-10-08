package com.chargedot.webservice.service.Impl;

import com.chargedot.webservice.domain.Student;
import com.chargedot.webservice.service.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/8/14
 */
@WebService(serviceName = "CommonService", //与接口置顶的name一致
        targetNamespace = "http://service.webservice.chargedot.com/",// 与接口中的命名空间一致，一般是接口的包
        endpointInterface = "com.chargedot.webservice.service.CommonService"//接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHello(String name) {
        return "hello," + name;
    }

    @Override
    public boolean addStudent(Student s) {
        System.out.println("server addStudent()" + s);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        System.out.println("server getStudentById()" + id);
        return new Student(id, "tutu", 1000);
    }

    @Override
    public List<Student> getStudentsByPrice(float price) {
        System.out.println("server getStudentsByPrice()" + price);
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "tutu1", price + 1));
        list.add(new Student(2, "tutu2", price + 2));
        list.add(new Student(3, "tutu3", price + 3));
        return list;
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
        System.out.println("server getAllStudents()");
        Map<Integer, Student> map = new HashMap();
        map.put(1, new Student(1, "tom1", 20000));
        map.put(2, new Student(2, "tom2", 22000));
        map.put(3, new Student(3, "tom3", 23000));
        map.put(4, new Student(3, "tom4", 24000));
        return map;
    }
}
