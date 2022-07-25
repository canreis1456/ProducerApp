package com.producer.producerapp.Producer;

import com.producer.producerapp.Model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
@Configuration
@EnableScheduling
public class ProducerController {

    // Autowiring Kafka Template
    @Autowired KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @Scheduled(fixedDelay = 1000)
    @GetMapping("/publish")
    public String produce()
    {
        Entity message = Entity.builder()
                .currencyName("dollar").currencyValue(17.66).build();

        // Sending the message
        kafkaTemplate.send(TOPIC, message.toString());

        return "Published Successfully";
    }
}
