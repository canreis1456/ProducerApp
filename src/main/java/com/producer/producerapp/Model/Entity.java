package com.producer.producerapp.Model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class Entity extends EntityGenerator {
    private final String CurrencyName;
    private final String ForexBuying;
    private final String ForexSelling;
    private final String BanknoteBuying;
    private final String BanknoteSelling;

    @Override
    public String toString() {
        return "Currency Name: " + this.CurrencyName + "\n" +
                "Forex Buying: " + this.ForexBuying + "\n" +
                "Forex Selling: " + this.ForexSelling + "\n" +
                "Banknote Buying: " + this.BanknoteBuying + "\n" +
                "Banknote Selling: " + this.BanknoteSelling + "\n";
    }
}
