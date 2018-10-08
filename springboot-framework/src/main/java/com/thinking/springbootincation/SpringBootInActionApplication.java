package com.thinking.springbootincation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.thinking.springbootincation"})
public class SpringBootInActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInActionApplication.class, args);
	}
}
