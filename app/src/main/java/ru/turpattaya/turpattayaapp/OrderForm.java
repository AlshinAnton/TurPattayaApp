package ru.turpattaya.turpattayaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class OrderForm extends AppCompatActivity {
    private EditText nameOrderForm;
    private EditText mailOrderForm;
    private EditText phoneOrderForm;
    private EditText departureAirportOrderForm;
    private EditText arrivalAirportOrderForm;
    private EditText flightNumberOrderForm;
    private EditText dateArrivalOrderForm;
    private EditText timeArrivalOrderForm;
    private EditText numberOfPassengerOrderForm;
    private EditText destinationOrderForm;
    private EditText remarksOrderForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderform_taxi);
        nameOrderForm = (EditText) findViewById(R.id.name_orderform);
        mailOrderForm = (EditText) findViewById(R.id.mail_orderform);
        phoneOrderForm = (EditText) findViewById(R.id.phone_orderform);
        departureAirportOrderForm = (EditText) findViewById(R.id.airport_of_departure_orderform);
        arrivalAirportOrderForm = (EditText) findViewById(R.id.airport_of_arrival_orderform);
        flightNumberOrderForm = (EditText) findViewById(R.id.flight_number_orderform);
        dateArrivalOrderForm = (EditText) findViewById(R.id.arrival_date_orderform);
        timeArrivalOrderForm = (EditText) findViewById(R.id.arrival_time_orderform);
        numberOfPassengerOrderForm = (EditText) findViewById(R.id.num_of_passengers_orderform);
        destinationOrderForm = (EditText) findViewById(R.id.destination_orderform);
        remarksOrderForm = (EditText) findViewById(R.id.remark_orderform);
    }
}
