package com.chargedot.malfunction.server;

import com.chargedot.malfunction.util.JacksonUtil;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Future;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2017/12/27
 */
@Component
public class KafkaProducer {

    private Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * singleton instance
     */
    private static KafkaProducer instance = null;

    /**
     * get instance
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

    public void sendTest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", UUID.randomUUID().toString());
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("message", "helloWorld");
        LOG.info("send message:" + JacksonUtil.bean2Json(params));
        kafkaTemplate.send("test", "hello", JacksonUtil.bean2Json(params));
    }
}
