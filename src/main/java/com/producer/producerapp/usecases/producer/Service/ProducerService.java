package com.producer.producerapp.usecases.producer.Service;

import com.producer.producerapp.usecases.common.dto.Response;
import com.producer.producerapp.usecases.producer.Repository.ProducerRepository;
import com.producer.producerapp.usecases.producer.Repository.dto.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService
{
    @Autowired
    ProducerRepository producerRepository;

    public Response produce(Entity entityInfo)
    {
        int registered_id = producerRepository.produce(entityInfo);
        if(registered_id > 0)
        {
            return new Response(true, "Production Successful", registered_id);
        }
        else
        {
            return new Response(false, "Production Unsuccessful", null);
        }
    }
}
