package com.beacon.kafkacoreproducer.Producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RebalancingProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public RebalancingProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @Scheduled(fixedRate = 1000)
//    public void sendMessage() {
//        kafkaTemplate.send("t-balancing", String.valueOf(atomicInteger.incrementAndGet()));
//    }
}
