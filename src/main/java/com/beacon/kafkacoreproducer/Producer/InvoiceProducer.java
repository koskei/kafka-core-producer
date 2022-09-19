package com.beacon.kafkacoreproducer.Producer;

import com.beacon.kafkacoreproducer.entity.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class InvoiceProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private AtomicInteger counter = new AtomicInteger();
    public InvoiceProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(final Invoice invoice) throws JsonProcessingException {
        final var imagesJson = objectMapper.writeValueAsString(invoice);
        kafkaTemplate.send("invoice", invoice.getAmount()%2, invoice.getInvoiceNumber(), imagesJson);
    }


    public Invoice generateInvoice() {
        Invoice invoice = Invoice.builder()
                .invoiceNumber(String.valueOf(counter.getAndIncrement()))
                .amount(ThreadLocalRandom.current().nextInt(1,1_000))
                .currency("USD")
                .build();
        return invoice;
    }
}
