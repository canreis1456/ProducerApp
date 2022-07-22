package com.producer.producerapp.usecases.producer.Repository.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Entity {

    private Long id;
    private String username;
    private String password;
}
