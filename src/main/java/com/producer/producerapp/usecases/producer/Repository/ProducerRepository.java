package com.producer.producerapp.usecases.producer.Repository;

import com.producer.producerapp.usecases.producer.Repository.dto.Entity;
import org.springframework.stereotype.Repository;
@Repository
public class ProducerRepository
{
    public int produce(Entity entityInfo) {
        System.out.println(entityInfo.getUsername());
        System.out.println(entityInfo.getPassword());
        return 1;
    }
}
