package com.thinking.springbootincation.framework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/18
 */
@Component
@Slf4j
public class RestTemplateConfig {

    @Value("${rest.readTimeout}")
    private int readTimeout;
    @Value("${rest.connectTimeout}")
    private int connectionTimeout;
    @Value("${rest.connectionRequestTimeout}")
    private int connectionRequestTimeout;

    @Bean
    public HttpComponentsClientHttpRequestFactory httpClientFactory() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(readTimeout);
        httpRequestFactory.setConnectTimeout(connectionTimeout);
        httpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        return httpRequestFactory;
    }

    /**
     * loadBalanced config
     * @param httpClientFactory
     * @return
     */
    @Bean
//    @LoadBalanced //spring cloud loadBalanced
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory httpClientFactory) {
        RestTemplate restTemplate = new RestTemplate(httpClientFactory);
        return restTemplate;
    }

    /**
     * no loadBalanced config
     * @param httpClientFactory
     * @return
     */
    @Bean
    public RestTemplate restTemplateOuter(HttpComponentsClientHttpRequestFactory httpClientFactory) {
        RestTemplate restTemplate = new RestTemplate(httpClientFactory);
        return restTemplate;
    }
}
