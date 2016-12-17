package ru.turpattaya.turpattayaapp.currencyExchange;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.R;

public class CurrencyExchangeActivity extends BaseActivity implements Callback<CurrencyExchange>, CurrencyItemClickListener {
    private ListView lvCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeDrawer);
        setContentView(R.layout.activity_currency_exchange);
        lvCurrency = (ListView) findViewById(R.id.lvCurrency);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadCurrencyExchangeData();
    }

    private void loadCurrencyExchangeData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrencyExchangeService service = retrofit.create(CurrencyExchangeService.class);
        Call<CurrencyExchange> call =  service.loadCurrencyExchange();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<CurrencyExchange> call, Response<CurrencyExchange> response) {
        /*Toast.makeText(this, response.body().getBase(), Toast.LENGTH_LONG).show();*/
        CurrencyExchange currencyExchange = response.body();
        lvCurrency.setAdapter(new CurrencyAdapter(this,currencyExchange.getCurrencyList(), this));
    }

    @Override
    public void onFailure(Call<CurrencyExchange> call, Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCurrencyItemClick(Currency currency) {
        /*Toast.makeText(this, currency.getName(), Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(this, CurrencyConverter.class);
        intent.putExtra("currency_name", currency.getName());
        intent.putExtra("currency_rate", currency.getRate());

        startActivity(intent);
    }
}
