package com.thinking.springbootincation.project.kafka;

import com.thinking.springbootincation.common.constant.KafkaConstants;
import com.thinking.springbootincation.common.util.JsonValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {KafkaConstants.USER_REQ,"test"})
    public void consume(ConsumerRecord<String, String> consume){
        String topic = "";
        String key = "";
        String value = "";
        if (consume.topic() != null) {
            topic = consume.topic();
        }
        if (consume.key() != null) {
            key = consume.key();
        }
        if (consume.value() != null) {
            value = consume.value();
        }
//        log.info("[kafkaMessage][topic]-->{}[key]-->{}[value]-->{}",
//                consume.topic(),consume.key(), consume.value());

        if (topic == null || "".equals(topic.trim()) || " ".equals(topic)) {
            log.info("[invalid topic]{}", topic);
            return;
        }
        if (key == null || "".equals(key.trim()) || " ".equals(key)) {
            log.info("[invalid key]{}", key);
            return;
        }
        if (!new JsonValidatorUtil().validate(value)) {
            log.info("[invalid value]{}", value);
            return;
        }

        log.info("[kafkaMessage][topic]{}[key]{}[value]{}", topic, key, value);

    }

}
