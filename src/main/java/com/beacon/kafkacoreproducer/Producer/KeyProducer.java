package com.beacon.kafkacoreproducer.Producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KeyProducer {

    private  KafkaTemplate<String, String> kafkaTemplate;

    public KeyProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage (final String key, final String data) {
        log.info("sending => {} and message {} :" ,key , data);
        kafkaTemplate.send("newPartition", key,data);
    }
}
