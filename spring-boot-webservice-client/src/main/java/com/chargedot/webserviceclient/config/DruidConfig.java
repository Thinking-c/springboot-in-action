package com.chargedot.webserviceclient.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
@Configuration
@Slf4j
public class DruidConfig {

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        log.info("======================build datasource and set property============================");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/monitor/druid/*");
        servletRegistrationBean.addUrlMappings("/monitor/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername", userName);
        servletRegistrationBean.addInitParameter("loginPassword", password);

        //ip白名单
//        servletRegistrationBean.addInitParameter("allow", "");
        //ip黑名单
//        servletRegistrationBean.addInitParameter("deny", "");

        log.info("username:{},password:{}", userName, password);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");

        return filterRegistrationBean;
    }

}
