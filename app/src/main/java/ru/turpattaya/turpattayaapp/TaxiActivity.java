package ru.turpattaya.turpattayaapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class TaxiActivity extends BaseActivity {

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Spinner spinnerCar;

    private TextView priceRezult;
    private Button buttonOrderTaxi;

    HashMap<String, String> fromPares;
    HashMap<String, String> destinationPares;
    ArrayList<String> destinationArray;

    String destinationCode = "";
    String fromCode = "";

    MySQLiteHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from_taxi_fragment);
        spinnerTo = (Spinner) findViewById(R.id.spinner_destination_fragment_taxi);
        spinnerCar = (Spinner) findViewById(R.id.spinner_typeOfCar_fragment_taxi);
        priceRezult = (TextView) findViewById(R.id.priceResult_fragment_taxi);
        buttonOrderTaxi = (Button) findViewById(R.id.btn_taxi_order);

        helper = new MySQLiteHelper(this);
        destinationArray = new ArrayList<>();
        destinationArray.add("Выберите куда");


        final Cursor cursor = helper.getReadableDatabase().query(
                TaxiFromTable.TABLE_TAXIFROMTABLE,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<String> fromArray = new ArrayList<>();
        fromPares = new HashMap<>();
        fromArray.add("Выберите откуда");

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(TaxiFromTable.COLUMN_TAXIFROM_FROMRUSSIANNAME));
                String code = cursor.getString(cursor.getColumnIndexOrThrow(TaxiFromTable.COLUMN_TAXIFROM_FROMCODE));

                fromArray.add(name);
                fromPares.put(name, code);

                cursor.moveToNext();
            }
            cursor.close();
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fromArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnerArrayAdapter);


        // ПОКАЗАТЬ МАШЕ !!!!!!!!!!!!!!!! правильно ли я сделал?   косяк в том, что при повороте экрана , сбрасывается этот спиннер (пересоздается)
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, destinationArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(spinnerArrayAdapter2);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedText = parent.getItemAtPosition(position).toString();
                if (selectedText.contains("Выберите")) {
                    /*spinnerTo.setClickable(false);*/
                    return;
                }
                if (fromPares.containsKey(selectedText)) {
                    String selectedCode = fromPares.get(selectedText);
                    fromCode = fromPares.get(selectedText);
                    fillDestinationSpinner(selectedCode);
                    spinnerTo.setClickable(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedText = parent.getItemAtPosition(position).toString();
                if (selectedText.contains("Выберите")) {
                    /*spinnerCar.setClickable(false);*/
                    return;
                }
                if (destinationPares.containsKey(selectedText)) {
                    destinationCode = destinationPares.get(selectedText);
                    spinnerCar.setClickable(true);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_car_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCar.setAdapter(adapter);


        spinnerCar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String car = parent.getItemAtPosition(position).toString(); // так мы достаем из спиннера текст выбранный
                if (car.equals("Легковая")) {
                    String colomn = TaxiTable.COLOMN_TAXI_PRICESMALCAR;

                    calculatePrice(colomn);
                } else if (car.equals("Минивэн")) {
                    String colomn = TaxiTable.COLOMN_TAXI_PRICEINOVACAR;
                    calculatePrice(colomn);
                } else if (car.equals("Микроавтобус")) {
                    String colomn = TaxiTable.COLOMN_TAXI_PRICEMINIBUSCAR;

                    calculatePrice(colomn);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void finish() {
        // TODO Auto-generated method stub
    }

    private void fillDestinationSpinner(String fromCode) {
        destinationArray = new ArrayList<>();
        destinationArray.add("Выберите куда");
        destinationPares = new HashMap<>();

        /*SELECT tdt.destinationCode, tdt.destinationRussianName FROM TaxiTable tt
        LEFT OUTER JOIN TaxiDestinationTable tdt
        ON tdt.destinationCode = tt.destinationCode
        WHERE tt.fromCode like '0'   */

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT tdt.destinationCode, tdt.destinationRussianName FROM ")
                .append("TaxiTable tt ")
                .append("LEFT OUTER JOIN TaxiDestinationTable tdt ")
                .append("ON tdt.destinationCode = tt.destinationCode ")
                .append("WHERE tt.fromCode like ?");

        helper = new MySQLiteHelper(this);
        Cursor cursor = helper.getReadableDatabase().rawQuery(sb.toString(), new String[]{fromCode});

        if (!cursor.moveToFirst()) return;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(TaxiDestinationTable.COLUMN_TAXIDESTINATION_DESTINATIONRUSSIANNAME));
            String code = cursor.getString(cursor.getColumnIndexOrThrow(TaxiDestinationTable.COLUMN_TAXIDESTINATION_DESTINATIONCODE));

            destinationArray.add(name);
            destinationPares.put(name, code);

            cursor.moveToNext();
        }

        cursor.close();

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, destinationArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(spinnerArrayAdapter);
    }

    private String calculatePrice(String colomnName) {
        Cursor cursor = null;


        helper = new MySQLiteHelper(this);

        cursor = helper.getReadableDatabase().query(
                TaxiTable.TABLE_TAXI,
                null,
                TaxiTable.COLOMN_TAXI_FROMCODE + " like ? and " + TaxiTable.COLOMN_TAXI_DESTINATIONCODE + " like ? ",
                new String[]{fromCode, destinationCode},
                null,
                null,
                null,
                null
        );

        if (!cursor.moveToFirst()) return "";

        String value = cursor.getString(cursor.getColumnIndexOrThrow(colomnName));
        cursor.close();

        priceRezult.setText(value == null ? "" : value + " Бат");

        return value;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}