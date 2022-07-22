package com.producer.producerapp.usecases.producer.Controller;

import com.producer.producerapp.usecases.common.dto.Response;
import com.producer.producerapp.usecases.producer.Repository.dto.Entity;
import com.producer.producerapp.usecases.producer.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("ProducerController")
@CrossOrigin(origins = "http://localhost:8080")
public class ProducerController
{
    @Autowired
    ProducerService producerService;

    @PostMapping("producer")
    public Response login(@RequestBody Entity entityInfo)
    {
        return producerService.produce(entityInfo);
    }
}
