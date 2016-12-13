package ru.turpattaya.turpattayaapp.CurrencyExchange;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MSI on 12/14/2016.
 */

public interface CurrencyExchangeService {
    @GET("latest")
    Call<CurrencyExchange> loadCurrencyExchange();
}
