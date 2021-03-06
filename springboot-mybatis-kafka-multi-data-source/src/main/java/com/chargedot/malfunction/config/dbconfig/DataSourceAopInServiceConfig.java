package com.chargedot.malfunction.config.dbconfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2018/1/4
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@Component
public class DataSourceAopInServiceConfig implements PriorityOrdered{

    public static Logger LOG = LoggerFactory.getLogger(DataSourceAopInServiceConfig.class);

    @Before("execution(* com.chargedot.malfunction.service..*.*(..))"
            + " && @annotation(com.chargedot.malfunction.annotation.ReadDataSource)")
    public void setReadDataSourceType(){
        DataSourceContextHolder.setRead();
    }

    @Before("execution(* com.chargedot.malfunction.service..*.*(..))"
            + "&& @annotation(com.chargedot.malfunction.annotation.WriteDataSource)")
    public void setWriteDataSourceType(){
        DataSourceContextHolder.setWrite();
    }

    /**
     * 值越小，越优先执行
     * 要优于事务的执行
     * 在启动类中加上了@EnableTransactionManagement(order = 10)
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
