package ru.turpattaya.turpattayaapp.CurrencyExchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 12/14/2016.
 */

public class CurrencyExchange {

    /**
     * base : EUR
     * date : 2016-12-13
     * rates : {"AUD":1.4155,"BGN":1.9558,"BRL":3.5325,"CAD":1.3921,"CHF":1.0742,"CNY":7.3233,"CZK":27.022,"DKK":7.437,"GBP":0.83488,"HKD":8.2303,"HRK":7.526,"HUF":314.31,"IDR":14124.95,"ILS":4.042,"INR":71.659,"JPY":122.27,"KRW":1237.88,"MXN":21.4788,"MYR":4.7167,"NOK":8.9495,"NZD":1.4724,"PHP":52.844,"PLN":4.4442,"RON":4.5045,"RUB":64.5831,"SEK":9.718,"SGD":1.5138,"THB":37.772,"TRY":3.6953,"USD":1.061,"ZAR":14.522}
     */

    private String base;
    private String date;
    private RatesBean rates;

    public List<Currency> getCurrencyList() {
        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("RUB", rates.getRUB()));
        currencyList.add(new Currency("USD", rates.getUSD()));
        currencyList.add(new Currency("THB", rates.getTHB()));
        currencyList.add(new Currency("CHY", rates.getCNY()));
        currencyList.add(new Currency("CZK", rates.getCZK()));

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
         * AUD : 1.4155
         * BGN : 1.9558
         * BRL : 3.5325
         * CAD : 1.3921
         * CHF : 1.0742
         * CNY : 7.3233
         * CZK : 27.022
         * DKK : 7.437
         * GBP : 0.83488
         * HKD : 8.2303
         * HRK : 7.526
         * HUF : 314.31
         * IDR : 14124.95
         * ILS : 4.042
         * INR : 71.659
         * JPY : 122.27
         * KRW : 1237.88
         * MXN : 21.4788
         * MYR : 4.7167
         * NOK : 8.9495
         * NZD : 1.4724
         * PHP : 52.844
         * PLN : 4.4442
         * RON : 4.5045
         * RUB : 64.5831
         * SEK : 9.718
         * SGD : 1.5138
         * THB : 37.772
         * TRY : 3.6953
         * USD : 1.061
         * ZAR : 14.522
         */

        private double CNY;
        private double CZK;
        private double RUB;
        private double THB;
        private double USD;

        public double getCNY() {
            return CNY;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public double getCZK() {
            return CZK;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public double getRUB() {
            return RUB;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public double getTHB() {
            return THB;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }
    }
}
