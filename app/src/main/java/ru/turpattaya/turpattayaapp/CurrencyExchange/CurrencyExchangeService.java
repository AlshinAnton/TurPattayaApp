package ru.turpattaya.turpattayaapp.currencyExchange;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CurrencyExchangeService {
    @GET("latest?base=THB")
    Call<CurrencyExchange> loadCurrencyExchange();
}
