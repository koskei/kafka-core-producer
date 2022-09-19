package com.beacon.kafkacoreproducer.Producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public static String TOPIC = "-t-hello";
    private AtomicInteger counter = new AtomicInteger();

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        var i = counter.incrementAndGet();
        kafkaTemplate.send(TOPIC, "t-fixed "+ i);
    }


}
