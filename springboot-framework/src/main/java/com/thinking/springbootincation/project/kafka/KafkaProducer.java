package com.thinking.springbootincation.project.kafka;

import com.thinking.springbootincation.common.constant.KafkaConstants;
import com.thinking.springbootincation.common.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Future;

/**
 * @Author：caoj
 * @Description： not  use kafkaTemplate, can use this instance
 * @Date：Created in 2018/7/13
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * singleton instance
     */
    private static KafkaProducer instance = null;

    /**
     * @return instance
     */
    public static KafkaProducer getInstance() {
        if (instance == null) {
            instance = new KafkaProducer();
        }
        return instance;
    }

    public Future<RecordMetadata> send(String topic, String key, String message) {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, message);
        Future<RecordMetadata> result = kafkaTemplate.send(topic, key, message);
        return result;
    }

    //test kafka producer
//    @Scheduled(fixedRate = 10000)
    public void sendTest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", UUID.randomUUID().toString().trim().replaceAll("-", ""));
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("kafka", "helloWorld");
        log.info("[send kafka]{}", JacksonUtil.bean2Json(params));
        kafkaTemplate.send(KafkaConstants.USER_REQ, "think", JacksonUtil.bean2Json(params));
    }


}
