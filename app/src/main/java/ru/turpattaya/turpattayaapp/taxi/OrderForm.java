package ru.turpattaya.turpattayaapp.taxi;


import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.fragments.DatePickerFragment;
import ru.turpattaya.turpattayaapp.R;
import ru.turpattaya.turpattayaapp.fragments.TimePickerFragment;
import ru.turpattaya.turpattayaapp.UtilsTime;


public class OrderForm extends BaseActivity {
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
    private TextInputLayout ilNumOfPasOrderform;
    private TextInputLayout ilDateOrderForm;
    private TextInputLayout ilTimeOrderform;
    TextInputLayout ilremarkOrderform;
    Button btnSendOrderForm;
    Button btnBackToTaxiActivity;
    final Calendar calendar = Calendar.getInstance();


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
        ilNumOfPasOrderform = (TextInputLayout) findViewById(R.id.input_layout_num_od_pas_orderform);
        ilremarkOrderform = (TextInputLayout) findViewById(R.id.input_layout_remark_orderform);
        ilDateOrderForm = (TextInputLayout) findViewById(R.id.input_layout_date_orderform);
        ilTimeOrderform = (TextInputLayout) findViewById(R.id.input_layout_time_orderform);

        String txtFrom = getIntent().getStringExtra("from");
        pickupPlace.setText(pickupPlace.getText().toString() + " " + txtFrom);
        String txtDestination = getIntent().getStringExtra("destination");
        destinationOrderForm.setText(destinationOrderForm.getText().toString() + " " + txtDestination);
        String txtCar = getIntent().getStringExtra("car");
        carOrderForm.setText(carOrderForm.getText().toString() + " " + txtCar);
        String txtPrice = getIntent().getStringExtra("price");
        priceOrderForm.setText(priceOrderForm.getText().toString() + " " + txtPrice);

        assert dateOrderForm != null;
        dateOrderForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dateOrderForm.length() == 0) {
                    dateOrderForm.setText("");
                }
                @SuppressLint("ValidFragment")
                DialogFragment datePickerFragment = new DatePickerFragment() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        dateOrderForm.setText(UtilsTime.getDate(calendar.getTimeInMillis()));
                    }

                    @Override
                    public void onCancel(DialogInterface dialog) {
                        dateOrderForm.setText(null);
                    }
                };
                datePickerFragment.show(getFragmentManager(), "DatePickerFragment");
            }
        });

        assert timeOrderForm != null;
        timeOrderForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timeOrderForm.length() == 0) {
                    timeOrderForm.setText(" ");
                }
                @SuppressLint("ValidFragment")
                DialogFragment timePickerFragment = new TimePickerFragment() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, 0);
                        timeOrderForm.setText(UtilsTime.getTime(calendar.getTimeInMillis()));
                    }

                    @Override
                    public void onCancel(DialogInterface dialog) {
                        timeOrderForm.setText(null);
                    }
                };
                timePickerFragment.show(getFragmentManager(), "TimePickerFragment");
            }
        });

        btnSendOrderForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkForm()) {
                    Toast.makeText(OrderForm.this, "Заполните все поля", Toast.LENGTH_LONG).show();
                    return;
                }

                Log.d("Valo","Send email");
                switch (v.getId()) {
                    case R.id.btn_send_form:
                        Intent send = new Intent(Intent.ACTION_SENDTO);
                        String uriText =
                                "mailto:" + Uri.encode("TURPATTAYA@gmail.com") +
                                        "?subject=" + Uri.encode("Заказ такси/TaxiOrder") +
                                        "&body=" + Uri.encode("Откуда  " + pickupPlace.getText().toString() + "\n" +
                                        "Куда " + destinationOrderForm.getText().toString() + "\n" +
                                        "Тип машины " + carOrderForm.getText().toString() + "\n" +
                                        "Цена " + priceOrderForm.getText().toString() + "\n" + "\n"+
                                        "Информация о заказчике: \n" +
                                        "Имя " + nameOrderForm.getText().toString() + "\n" +
                                        "Email " + emailOrderForm.getText().toString() + "\n" +
                                        "Номер телефона " + phoneOrderForm.getText().toString() + "\n" +
                                        "Дата поездки " + dateOrderForm.getText().toString() + "\n" +
                                        "Время " + timeOrderForm.getText().toString() + "\n" +
                                        "Колличество пассажиров " + numberOfPassengerOrderForm.getText().toString() + "\n" +
                                        "Пожелания " + remarksOrderForm.getText().toString());
                        Uri emailUri = Uri.parse(uriText);
                        send.setData(emailUri);
                        startActivity(Intent.createChooser(send, "написать письмо"));
                }
            }
        });

    }

    private boolean checkForm() {
        return validateName() && validateMail() && validatePhone() && validateDate() && validateTime() && validateNuOfPas();
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

    private boolean validateDate() {
        if (dateOrderForm.getText().toString().trim().isEmpty()) {
            ilDateOrderForm.setError(getString(R.string.errorDateOrderform));
            requestFocus(dateOrderForm);
            return false;
        } else {
            ilDateOrderForm.setErrorEnabled(false);
        }

        return true;
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

/*    private class MyTextWatcher implements TextWatcher {

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
    }*/

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
