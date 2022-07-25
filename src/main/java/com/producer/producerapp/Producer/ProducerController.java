package com.producer.producerapp.Producer;

import com.producer.producerapp.Model.EntityGenerator;
import com.producer.producerapp.Model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Element;

import javax.persistence.EntityManager;
import java.util.Map.Entry;


@RestController
@Configuration
@EnableScheduling
public class ProducerController extends EntityGenerator{

    // Autowiring Kafka Template
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "NewTopic";


    @Scheduled(fixedDelay = 1000)
    @GetMapping("/publish")
    public void produce()
    {
        String CurNameM = EntityGenerator.CurName;
        String ForBuyM = EntityGenerator.ForexBuying;
        String ForSellM = EntityGenerator.ForexSelling;
        String BankBuyM = EntityGenerator.BanknoteBuying;
        String BankSellM = EntityGenerator.BanknoteSelling;

        System.out.println(CurNameM + " + " + ForBuyM + " + " + ForSellM + " + " + BankBuyM + " + " + BankSellM);

        Entity message = Entity.builder()
                .CurrencyName(EntityGenerator.CurrencyNameMethod(CurNameM))
                .ForexBuying(EntityGenerator.ForexBuyingMethod(ForBuyM))
                .ForexSelling(EntityGenerator.ForexSellingMethod(ForSellM))
                .BanknoteBuying(EntityGenerator.BanknoteBuyingMethod(BankBuyM))
                .BanknoteSelling(EntityGenerator.BanknoteSellingMethod(BankSellM))
                .build();

        kafkaTemplate.send(TOPIC, message.toString());
        EntityGen();
    }
}
