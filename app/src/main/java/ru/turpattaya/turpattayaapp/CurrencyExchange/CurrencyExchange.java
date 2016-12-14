package ru.turpattaya.turpattayaapp.currencyExchange;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExchange {

    /**
     * base : THB
     * date : 2016-12-13
     * rates : {"AUD":0.037475,"BGN":0.051779,"BRL":0.093522,"CAD":0.036855,"CHF":0.028439,"CNY":0.19388,"CZK":0.7154,"DKK":0.19689,"GBP":0.022103,"HKD":0.21789,"HRK":0.19925,"HUF":8.3212,"IDR":373.95,"ILS":0.10701,"INR":1.8971,"JPY":3.2371,"KRW":32.772,"MXN":0.56864,"MYR":0.12487,"NOK":0.23693,"NZD":0.038981,"PHP":1.399,"PLN":0.11766,"RON":0.11926,"RUB":1.7098,"SEK":0.25728,"SGD":0.040077,"TRY":0.097832,"USD":0.02809,"ZAR":0.38446,"EUR":0.026475}
     */

    private String base;
    private String date;
    private RatesBean rates;

    public List<Currency> getCurrencyList() {
        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("RUB", rates.getRUB()));
        currencyList.add(new Currency("USD", rates.getUSD()));
        currencyList.add(new Currency("EUR", rates.getEUR()));
        currencyList.add(new Currency("CHY", rates.getCNY()));

        return currencyList;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }

    public static class RatesBean {
        /**
         * AUD : 0.037475
         * BGN : 0.051779
         * BRL : 0.093522
         * CAD : 0.036855
         * CHF : 0.028439
         * CNY : 0.19388
         * CZK : 0.7154
         * DKK : 0.19689
         * GBP : 0.022103
         * HKD : 0.21789
         * HRK : 0.19925
         * HUF : 8.3212
         * IDR : 373.95
         * ILS : 0.10701
         * INR : 1.8971
         * JPY : 3.2371
         * KRW : 32.772
         * MXN : 0.56864
         * MYR : 0.12487
         * NOK : 0.23693
         * NZD : 0.038981
         * PHP : 1.399
         * PLN : 0.11766
         * RON : 0.11926
         * RUB : 1.7098
         * SEK : 0.25728
         * SGD : 0.040077
         * TRY : 0.097832
         * USD : 0.02809
         * ZAR : 0.38446
         * EUR : 0.026475
         */

        private double CNY;
        private double RUB;
        private double USD;
        private double EUR;

        public double getCNY() {
            return (double)Math.round(100/CNY)/100;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public double getRUB() {
            return (double)Math.round(100/RUB)/100;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public double getUSD() {
            return (double)Math.round(100/USD)/100;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getEUR() {
            return (double)Math.round(100/EUR)/100;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }
    }
}