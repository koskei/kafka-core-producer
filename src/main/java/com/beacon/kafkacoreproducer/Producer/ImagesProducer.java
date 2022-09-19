package com.beacon.kafkacoreproducer.Producer;

import com.beacon.kafkacoreproducer.entity.Images;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImagesProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public ImagesProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(final Images images, final int partition) throws JsonProcessingException {
        final var  imagesJson = objectMapper.writeValueAsString(images);
        kafkaTemplate.send("images", partition, images.getType(), imagesJson);
    }
}
