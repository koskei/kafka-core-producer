package com.beacon.kafkacoreproducer.service;

import com.beacon.kafkacoreproducer.entity.Images;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ImageService {

    private static AtomicInteger counter = new AtomicInteger();

    public Images generateImage(final String type) {
        var name = "image-"+counter.incrementAndGet();
        var size = ThreadLocalRandom.current().nextLong(100, 100_000);
        return  Images.builder().name(name).type(type).size(size).build();
    }
}
