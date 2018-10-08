package com.chargedot.webservice;

import com.chargedot.webservice.service.CommonService;
import com.chargedot.webservice.service.CommonService;
import com.chargedot.webservice.service.GetAllStudentsResponse;
import com.chargedot.webservice.service.Impl.CommonServiceImpl;
import com.chargedot.webservice.service.Student;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.List;
import java.util.Map;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/8/14
 */
public class CxfClientTest {

    public static void main(String[] args) {
        //client1();
        client2();
    }

    /**
     * 方式1：代理类工厂的方式，需要拿到服务端的接口
     */
    public static void client1() {

        try {
            //接口地址
            String address = "http://localhost:8080/services/CommonService?wsdl";
            //代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            //设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            //设置接口的类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            //创建一个代理接口实现
            CommonService commonService = (CommonService) jaxWsProxyFactoryBean.create();
            //客户端参数准备
            String userName = "Tom";
            //调用代理接口的方法调用并返回结果
//            String result = commonService.sayHello(userName);
//            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用方式
     */
    public static void client2() {
        //创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8543/services/CentralSystemService?wsdl");

        //需要密码的情况需要加上用户名和密码
        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));

        try {
            //invoke("方法名", 参数1,参数2,参数3......)
            Object[] objects = client.invoke("authorize", "BoB");
            System.out.println(objects.length);
            System.out.println(objects[0]);

//            Object[] objects1 = client.invoke("addStudent", new Student(12, "Tom", 1000));
//            for (int i = 0; i < objects1.length; i++) {
//                System.out.println(objects1[i]);
//            }
//
//            Object[] objects2 = client.invoke("getAllStudents", 24);
//            for (int i = 0; i < objects2.length; i++) {
//                GetAllStudentsResponse.Return allStudent = (GetAllStudentsResponse.Return) objects2[i];
//                List<GetAllStudentsResponse.Return.Entry> entries = allStudent.getEntry();
//                for (GetAllStudentsResponse.Return.Entry entry : entries) {
//                    System.out.println(entry.getKey() + "_" + entry.getValue());
//                }
//            }
//
//            Object[] objects3 = client.invoke("getStudentById", 20);
//            for(int i = 0; i < objects3.length; i++){
//                System.out.println(((Student)objects3[i]).toString());
//            }
//
//            Object[] objects4 = client.invoke("getStudentsByPrice", 30);
//            for(int i = 0; i < objects4.length; i++){
//                System.out.println(objects4[i]);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
