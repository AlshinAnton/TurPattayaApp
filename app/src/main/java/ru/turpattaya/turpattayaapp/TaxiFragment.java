package ru.turpattaya.turpattayaapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class TaxiFragment extends Fragment {
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Spinner spinnerCar;

    private TextView priceRezult;
    private Button buttonOrderTaxi;

    HashMap<String, String> fromPares;
    HashMap<String, String> destinationPares;
    ArrayList<String> destinationArray;


    MySQLiteHelper helper;


    public TaxiFragment() {        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_taxi, container, false);
        spinnerFrom = (Spinner) rootView.findViewById(R.id.spinner_from_taxi_fragment);
        spinnerTo = (Spinner) rootView.findViewById(R.id.spinner_destination_fragment_taxi);
        spinnerCar = (Spinner) rootView.findViewById(R.id.spinner_typeOfCar_fragment_taxi);
        priceRezult = (TextView) rootView.findViewById(R.id.priceResult_fragment_taxi);
        buttonOrderTaxi = (Button) rootView.findViewById(R.id.btn_taxi_order);

        spinnerFrom.setPrompt("Откуда");
        spinnerTo.setPrompt("Куда");
        spinnerCar.setPrompt("Тип машины");

        helper = new MySQLiteHelper(getActivity());



        Cursor cursor = helper.getReadableDatabase().query(
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

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, fromArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnerArrayAdapter);







        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedText = parent.getItemAtPosition(position).toString();
                if (selectedText.contains("Выберите")) {
                    spinnerTo.setClickable(false);
                    return;
                }
                if (fromPares.containsKey(selectedText)) {
                    String selectedCode = fromPares.get(selectedText);
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerCar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return rootView;
    }


    private void finish() {
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

        helper = new MySQLiteHelper(getContext());
        Cursor cursor = helper.getReadableDatabase().rawQuery(sb.toString(),new String[] {fromCode});

        if (!cursor.moveToFirst()) return;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(TaxiDestinationTable.COLUMN_TAXIDESTINATION_DESTINATIONRUSSIANNAME));
            String code = cursor.getString(cursor.getColumnIndexOrThrow(TaxiDestinationTable.COLUMN_TAXIDESTINATION_DESTINATIONCODE));

            destinationArray.add(name);
            destinationPares.put(name, code);

            cursor.moveToNext();
        }

        cursor.close();

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, destinationArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(spinnerArrayAdapter);



    }






    private String calculatePrice() {
        Cursor cursor = null;
        String fromcode;
        String destinationcode;


        helper = new MySQLiteHelper(getActivity());

        cursor = helper.getReadableDatabase().query(
                TaxiTable.TABLE_TAXI,
                null,
                TaxiTable.COLOMN_TAXI_FROMCODE + " like ? and " + TaxiTable.COLOMN_TAXI_DESTINATIONCODE + " like ? ",
                new String[]{"2", "3"},
                null,
                null,
                null,
                null
        );
        return null;
    }


}
