package com.think.multi.datasource.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/19
 */
@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(ClusterDataSourceConfig.class);

    static final String BASE_PACKAGE = "com.think.multi.datasource.dao.cluster";
    static final String MAPPER_LOCATION = "com.think.multi.datasource.dao.cluster.*.XML";

    @Value("${mysql.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Value("${mysql.datasource.configLocation}")
    private String configLocation;

    @Bean(name = "clusterDataSource")
    @ConfigurationProperties(prefix = "mysql.datasource.cluster")
    public DataSource clusterDataSource(){
        log.info("-------------clusterDataSource init-------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
        return sessionFactory.getObject();
    }



}
