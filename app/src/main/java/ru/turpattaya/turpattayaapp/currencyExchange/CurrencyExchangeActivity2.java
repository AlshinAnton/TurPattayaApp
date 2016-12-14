package ru.turpattaya.turpattayaapp.currencyExchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.R;

public class CurrencyExchangeActivity2 extends BaseActivity {

    private TextView tvTitle, tvSubTitle, tvOutputName, tvOutputRate;
    private EditText etInput;
    private Button btnCalculate;

    private String currencyName;
    private double currencyRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeDrawer);
        setContentView(R.layout.activity_currency_exchange2);
        tvTitle  = (TextView) findViewById(R.id.tvTitle);
        tvSubTitle  = (TextView) findViewById(R.id.tvSubTitle);
        tvOutputName  = (TextView) findViewById(R.id.tvOutputName);
        tvOutputRate  = (TextView) findViewById(R.id.tvOutputRate);
        etInput  = (EditText) findViewById(R.id.etInput);
        btnCalculate  = (Button) findViewById(R.id.btnCalculate);

        Intent intent = getIntent();
        currencyName = intent.getStringExtra("currency_name");
        currencyRate = intent.getDoubleExtra("currency_rate", 0);

        tvTitle.setText(currencyName.toUpperCase() + " to BAHT");
        tvSubTitle.setText("Rate 1 : " + currencyRate);
        tvOutputName.setText(currencyName.toUpperCase() + ": ");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etInput.getText().toString().length() == 0) {
                    return;
                }

                double input;
                try {
                    input = Double.parseDouble(etInput.getText().toString());
                }
                catch (NumberFormatException e) {
                    etInput.setText("Введите число");
                    return;
                }
                double output = (double)Math.round(input * currencyRate*100)/100;
                tvOutputRate.setText("" + output);
            }
        });
    }
}
