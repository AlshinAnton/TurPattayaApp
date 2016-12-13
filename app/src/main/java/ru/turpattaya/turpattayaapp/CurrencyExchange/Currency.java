package ru.turpattaya.turpattayaapp.CurrencyExchange;

/**
 * Created by MSI on 12/14/2016.
 */

public class Currency {
    private String name;
    private Double rate;

    public Currency(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }
}
