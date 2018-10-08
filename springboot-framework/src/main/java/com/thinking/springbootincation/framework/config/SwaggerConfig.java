package com.thinking.springbootincation.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/5
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.url}")
    private String url;

    @Value("${swagger.email}")
    private String email;

    @Value("${swagger.basePackage}")
    private String basePackage;

    @Autowired
    private ProjectConfig projectConfig;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //详细定制
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //用apiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("标题：Thinking管理系统--接口文档")
                .description("描述：适用于开发和测试人员")
                .contact(new Contact(projectConfig.getName(), null, email))
                .version(projectConfig.getVersion())
                .build();
    }

}
