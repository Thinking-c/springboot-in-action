package com.chargedot.malfunction.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2017/12/27
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    private Logger LOG = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String brokers;

    @Value("${spring.kafka.producer.key-serializer}")
    private String keyType;

    @Value("${spring.kafka.producer.value-serializer}")
    private String valueType;

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<String, String>(producerFactory());
        return kafkaTemplate;
    }

    public ProducerFactory<String, String> producerFactory() {

        LOG.info("keyType:"+keyType +"valueType:"+ valueType);
        // set the producer properties
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 65536);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 524288);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keyType);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueType);
        return new DefaultKafkaProducerFactory<String, String>(properties);
    }
}
