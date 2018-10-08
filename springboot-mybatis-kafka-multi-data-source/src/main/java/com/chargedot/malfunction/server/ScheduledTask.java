package com.chargedot.malfunction.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2018/1/8
 */
@Component
public class ScheduledTask {

    @Autowired
    private KafkaProducer kafkaProducer;

    //test method
    @Scheduled(fixedDelay = 60 * 1000)
    private void testKafka(){
		kafkaProducer.sendTest();
    }
}
