package com.boot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class BootDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDubboConsumerApplication.class, args);
	}
}
