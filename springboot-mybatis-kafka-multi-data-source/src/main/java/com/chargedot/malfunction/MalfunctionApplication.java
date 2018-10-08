package com.chargedot.malfunction;

import com.chargedot.malfunction.server.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableEurekaClient
@EnableScheduling
@ComponentScan(basePackages = {"com.chargedot.malfunction"})
@EnableTransactionManagement(order = 10)//开启事务，并设置order值，默认是Integer的最大值
public class MalfunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalfunctionApplication.class, args);
	}
}
