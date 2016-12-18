package ru.turpattaya.turpattayaapp.taxi;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.turpattaya.turpattayaapp.R;

public class OrderForm extends AppCompatActivity {
    TextView pickupPlace;
    TextView destinationOrderForm;
    TextView carOrderForm;
    TextView priceOrderForm;
    private EditText nameOrderForm;
    private EditText emailOrderForm;
    private EditText phoneOrderForm;
    private EditText dateOrderForm;
    private EditText timeOrderForm;
    private EditText numberOfPassengerOrderForm;
    EditText remarksOrderForm;
    private TextInputLayout ilNameOrderform;
    private TextInputLayout ilMailOrderform;
    private TextInputLayout ilPhoneOrderform;
    private TextInputLayout ilDateOrderform;
    private TextInputLayout ilTimeOrderform;
    private TextInputLayout ilNumOfPasOrderform;
    TextInputLayout ilremarkOrderform;
    Button btnSendOrderForm;
    Button btnBackToTaxiActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderform_taxi);

        nameOrderForm = (EditText) findViewById(R.id.name_orderform);
        emailOrderForm = (EditText) findViewById(R.id.mail_orderform);
        phoneOrderForm = (EditText) findViewById(R.id.phone_orderform);
        pickupPlace = (TextView) findViewById(R.id.pickup_place_orderform);
        dateOrderForm = (EditText) findViewById(R.id.date_orderform);
        timeOrderForm = (EditText) findViewById(R.id.time_orderform);
        numberOfPassengerOrderForm = (EditText) findViewById(R.id.num_of_passengers_orderform);
        destinationOrderForm = (TextView) findViewById(R.id.destination_orderform);
        carOrderForm = (TextView) findViewById(R.id.car_orderform);
        remarksOrderForm = (EditText) findViewById(R.id.remark_orderform);
        btnSendOrderForm = (Button) findViewById(R.id.btn_send_form);
        priceOrderForm = (TextView) findViewById(R.id.price_orderform);
        btnBackToTaxiActivity = (Button) findViewById(R.id.btn_back_taxiactivity);

        ilNameOrderform = (TextInputLayout) findViewById(R.id.input_layout_name_orderform);
        ilMailOrderform = (TextInputLayout) findViewById(R.id.input_layout_mail_orderform);
        ilPhoneOrderform = (TextInputLayout) findViewById(R.id.input_layout_phone_orderform);
        ilTimeOrderform = (TextInputLayout) findViewById(R.id.input_layout_time_orderform);
        ilDateOrderform = (TextInputLayout) findViewById(R.id.input_layout_date_orderform);
        ilNumOfPasOrderform = (TextInputLayout) findViewById(R.id.input_layout_num_od_pas_orderform);
        ilremarkOrderform = (TextInputLayout) findViewById(R.id.input_layout_remark_orderform);

        String txtFrom = getIntent().getStringExtra("from");
        pickupPlace.setText(pickupPlace.getText().toString() + " " + txtFrom);
        String txtDestination = getIntent().getStringExtra("destination");
        destinationOrderForm.setText(destinationOrderForm.getText().toString() + " " + txtDestination);
        String txtCar = getIntent().getStringExtra("car");
        carOrderForm.setText(carOrderForm.getText().toString() + " " + txtCar);
        String txtPrice = getIntent().getStringExtra("price");
        priceOrderForm.setText(priceOrderForm.getText().toString() + " " + txtPrice);

        btnSendOrderForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForm();
                Log.d("Valo","Send email");
                switch (v.getId()) {
                    case R.id.btn_send_form:
                        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        emailIntent.setData(Uri.parse("alshinanton@gmail.com"));
                        emailIntent.setType("text/plain");
                        emailIntent.putExtra("from", pickupPlace.getText().toString());
                        emailIntent.putExtra("destination", destinationOrderForm.getText().toString());
                        emailIntent.putExtra("car", carOrderForm.getText().toString());
                        emailIntent.putExtra("price", priceOrderForm.getText().toString());
                        emailIntent.putExtra("nameOrderForm", nameOrderForm.getText().toString());
                        emailIntent.putExtra("email", emailOrderForm.getText().toString());
                        emailIntent.putExtra("phone", phoneOrderForm.getText().toString());
                        emailIntent.putExtra("date", dateOrderForm.getText().toString());
                        emailIntent.putExtra("numOfPas", numberOfPassengerOrderForm.getText().toString());
                        emailIntent.putExtra("remarks", remarksOrderForm.getText().toString());

                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                            finish();
                            Log.d("Valo","Finished sending email");
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(OrderForm.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }

                        /*startActivity(emailIntent);
                        break;
                    default:
                        break;*/
                }
            }
        });
    }

    private void checkForm() {
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
        if (nameOrderForm.getText().toString().trim().isEmpty()) {
            ilNameOrderform.setError(getString(R.string.ErrorNameOrderForm));
            requestFocus(nameOrderForm);
            return false;
        } else {
            ilNameOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMail() {
        String email = emailOrderForm.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            ilMailOrderform.setError(getString(R.string.errorMailOrderform));
            requestFocus(emailOrderForm);
            return false;
        } else {
            ilMailOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (phoneOrderForm.getText().toString().trim().isEmpty()) {
            ilPhoneOrderform.setError(getString(R.string.errorPhoneOrderform));
            requestFocus(phoneOrderForm);
            return false;
        } else {
            ilPhoneOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDate() {
        if (dateOrderForm.getText().toString().trim().isEmpty()) {
            ilDateOrderform.setError(getString(R.string.errorDateOrderform));
            requestFocus(dateOrderForm);
            return false;
        } else {
            ilDateOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTime() {
        if (timeOrderForm.getText().toString().trim().isEmpty()) {
            ilTimeOrderform.setError(getString(R.string.errorTimeOrderform));
            requestFocus(timeOrderForm);
            return false;
        } else {
            ilTimeOrderform.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNuOfPas() {
        if (numberOfPassengerOrderForm.getText().toString().trim().isEmpty()) {
            ilNumOfPasOrderform.setError(getString(R.string.errorNumOfPasOrderform));
            requestFocus(numberOfPassengerOrderForm);
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
