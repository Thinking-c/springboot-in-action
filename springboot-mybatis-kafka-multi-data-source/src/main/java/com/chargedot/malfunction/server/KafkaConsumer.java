package com.chargedot.malfunction.server;

import com.chargedot.malfunction.config.ConstantConfig;
import com.chargedot.malfunction.util.JsonValidatorUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2017/12/27
 */
@Component
public class KafkaConsumer {

    private Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {ConstantConfig.D2S_MALFUNCATION_REQ_TOPIC,"test"})
    public void consumer(ConsumerRecord<String, String> consumer) {
        String topic = "";
        String key = "";
        String message = "";
        if (consumer.topic() != null) {
            topic = consumer.topic();
        }
        if (consumer.key() != null) {
            key = consumer.key();
        }
        if (consumer.value() != null) {
            message = consumer.value();
        }
        LOG.info("[kafkaMessage][topic]-->" + consumer.topic()+"[key]-->" + consumer.key()+"[value]-->"+ consumer.value());

        if (topic == null || "".equals(topic.trim()) || " ".equals(topic)) {
            LOG.info("[invalid topic]" + topic);
            return;
        }
        if (key == null || "".equals(key.trim()) || " ".equals(key)) {
            LOG.info("[invalid key]" + key);
            return;
        }
        if (!new JsonValidatorUtil().validate(message)) {
            LOG.info("[invalid message string]" + message);
            return;
        }



    }
}
