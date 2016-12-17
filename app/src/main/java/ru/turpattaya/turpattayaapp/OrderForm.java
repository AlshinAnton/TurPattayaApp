package ru.turpattaya.turpattayaapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrderForm extends AppCompatActivity {
    private EditText name;
    private EditText mail;
    private EditText phone;
    private EditText pickupDate;
    private EditText pickupTime;
    private EditText numberOfPassenger;
    private TextInputLayout ilNameOrderform;
    private TextInputLayout ilMailOrderform;
    private TextInputLayout ilPhoneOrderform;
    private TextInputLayout ilDateOrderform;
    private TextInputLayout ilTimeOrderform;
    private TextInputLayout ilNumOfPasOrderform;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderform_taxi);

        name = (EditText) findViewById(R.id.name_orderform);
        mail = (EditText) findViewById(R.id.mail_orderform);
        phone = (EditText) findViewById(R.id.phone_orderform);
        TextView pickupPlace = (TextView) findViewById(R.id.pickup_place_orderform);
        pickupDate = (EditText) findViewById(R.id.date_orderform);
        pickupTime = (EditText) findViewById(R.id.time_orderform);
        numberOfPassenger = (EditText) findViewById(R.id.num_of_passengers_orderform);
        TextView destinationOrderForm = (TextView) findViewById(R.id.destination_orderform);
        TextView carOrderForm = (TextView) findViewById(R.id.car_orderform);
        EditText remarksOrderForm = (EditText) findViewById(R.id.remark_orderform);
        Button btnSendForm = (Button) findViewById(R.id.btn_send_form);
        TextView priceOrderForm = (TextView) findViewById(R.id.price_orderform);
        Button btnBackToTaxiActivity = (Button) findViewById(R.id.btn_back_taxiactivity);

        ilNameOrderform = (TextInputLayout) findViewById(R.id.input_layout_name_orderform);
        ilMailOrderform = (TextInputLayout) findViewById(R.id.input_layout_mail_orderform);
        ilPhoneOrderform = (TextInputLayout) findViewById(R.id.input_layout_phone_orderform);
        ilTimeOrderform = (TextInputLayout) findViewById(R.id.input_layout_time_orderform);
        ilDateOrderform = (TextInputLayout) findViewById(R.id.input_layout_date_orderform);
        ilNumOfPasOrderform = (TextInputLayout) findViewById(R.id.input_layout_num_od_pas_orderform);
        TextInputLayout ilremarkOrderform = (TextInputLayout) findViewById(R.id.input_layout_remark_orderform);

        String txtFrom = getIntent().getStringExtra("from");
        pickupPlace.setText(pickupPlace.getText().toString() + " " + txtFrom);
        String txtDestination = getIntent().getStringExtra("destination");
        destinationOrderForm.setText(destinationOrderForm.getText().toString() + " " + txtDestination);
        String txtCar = getIntent().getStringExtra("car");
        carOrderForm.setText(carOrderForm.getText().toString() + " " + txtCar);
        String txtPrice = getIntent().getStringExtra("price");
        priceOrderForm.setText(priceOrderForm.getText().toString() + " " + txtPrice);

        btnSendForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendForm();
            }
        });
    }

    private void sendForm() {
        if (!validateName()){
            return;
        }
        if (!validateMail()){
            return;
        }
        if (!validatePhone()){
            return;
        }
        if (!validateDate()){
            return;
        }
        if (!validateTime()){
            return;
        }
        if (!validateNuOfPas()){
            return;
        }
    }

    private boolean validateName() {
        if (name.getText().toString().trim().isEmpty()) {
            ilNameOrderform.setError(getString(R.string.ErrorNameOrderForm));
            requestFocus(name);
            return false;
        } else {
            ilNameOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMail() {
        String email = mail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            ilMailOrderform.setError(getString(R.string.errorMailOrderform));
            requestFocus(mail);
            return false;
        } else {
            ilMailOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (phone.getText().toString().trim().isEmpty()) {
            ilPhoneOrderform.setError(getString(R.string.errorPhoneOrderform));
            requestFocus(phone);
            return false;
        } else {
            ilPhoneOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDate() {
        if (pickupDate.getText().toString().trim().isEmpty()) {
            ilDateOrderform.setError(getString(R.string.errorDateOrderform));
            requestFocus(pickupDate);
            return false;
        } else {
            ilDateOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTime() {
        if (pickupTime.getText().toString().trim().isEmpty()) {
            ilTimeOrderform.setError(getString(R.string.errorTimeOrderform));
            requestFocus(pickupTime);
            return false;
        } else {
            ilTimeOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNuOfPas() {
        if (numberOfPassenger.getText().toString().trim().isEmpty()) {
            ilNumOfPasOrderform.setError(getString(R.string.errorNumOfPasOrderform));
            requestFocus(numberOfPassenger);
            return false;
        } else {
            ilNumOfPasOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.name_orderform:
                    validateName();
                    break;
                case R.id.mail_orderform:
                    validateMail();
                    break;

            }
        }
    }

    public void backToTaxiActivity(View v){
        switch (v.getId()) {
            case R.id.btn_back_taxiactivity:
                Intent intent = new Intent(this, TaxiActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
