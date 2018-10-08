package com.chargedot.malfunction.config.dbconfig;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author：caoj
 * @Description：  data source config
 * @Data：Created in 2018/1/4
 */
@Configuration
public class DataSourceConfig {
    private static Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${mysql.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Value("${mysql.datasource.write.url}")
    private String dbUrl;
    @Value("${mysql.datasource.write.username}")
    private String username;
    @Value("${mysql.datasource.write.password}")
    private String password;
//    @Value("${mysql.datasource.write.driver-class-name}")
//    private String driverClassName;
//    @Value("${mysql.datasource.write.minIdle}")
//    private int minIdle;
//    @Value("${mysql.datasource.write.maxActive}")
//    private int maxActive;
//    @Value("${mysql.datasource.write.initialSize}")
//    private int initialSize;
//    @Value("${mysql.datasource.write.maxWait}")
//    private int maxWait;
//    @Value("${mysql.datasource.write.timeBetweenEvictionRunsMillis}")
//    private int timeBetweenEvictionRunsMillis;
//    @Value("${mysql.datasource.write.minEvictableIdleTimeMillis}")
//    private int minEvictableIdleTimeMillis;
//    @Value("${mysql.datasource.write.validationQuery}")
//    private String validationQuery;
//    @Value("${mysql.datasource.write.testWhileIdle}")
//    private boolean testWhileIdle;
//    @Value("${mysql.datasource.write.testOnBorrow}")
//    private boolean testOnBorrow;
//    @Value("${mysql.datasource.write.testOnReturn}")
//    private boolean testOnReturn;
//    @Value("${mysql.datasource.write.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//    @Value("${mysql.datasource.write.maxPoolPreparedStatementPerConnectionSize}")
//    private int maxPoolPreparedStatementPerConnectionSize;
//    @Value("${mysql.datasource.write.removeAbandoned}")
//    private boolean removeAbandoned;
//    @Value("${mysql.datasource.write.filters}")
//    private String filters;
//    @Value("${mysql.datasource.write.logSlowSql}")
//    private String logSlowSql;

    /**
     * write database dataSource config
     * @return DataSource
     */
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource() {
        LOG.info("-------------------- writeDataSource init ---------------------");
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(dbUrl);
//        druidDataSource.setUrl(username);
//        druidDataSource.setUrl(password);
//        druidDataSource.setUrl(driverClassName);
//        druidDataSource.setInitialSize(initialSize);
//        druidDataSource.setMinIdle(minIdle);
//        druidDataSource.setMaxActive(maxActive);
//        druidDataSource.setMaxWait(maxWait);
//        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        druidDataSource.setValidationQuery(validationQuery);
//        druidDataSource.setTestWhileIdle(testWhileIdle);
//        druidDataSource.setTestOnBorrow(testOnBorrow);
//        druidDataSource.setTestOnReturn(testOnReturn);
//        druidDataSource.setRemoveAbandoned(removeAbandoned);
//        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            druidDataSource.setFilters(filters);
//        } catch (SQLException e) {
//            LOG.error("[druid configuration initialization filter failed]--->", e.getMessage());
//        }
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * read database dataSource config(可配置多个)
     * @return DataSource
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "mysql.datasource.read")
    public DataSource readDataSourceOne() {
        LOG.info("-------------------- read DataSourceOne init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
//        reg.addInitParameter("logSlowSql", logSlowSql);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

}
