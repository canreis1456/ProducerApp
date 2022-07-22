package com.producer.producerapp.Model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Entity {
    private final String currencyName;
    private final double currencyValue;
}
