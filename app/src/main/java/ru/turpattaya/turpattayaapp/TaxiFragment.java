package ru.turpattaya.turpattayaapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class TaxiFragment extends Fragment {
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Button buttonOrderTaxi;
    private Activity rootView;


    public TaxiFragment() {        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_taxi, container, false);
        spinnerFrom = (Spinner) rootView.findViewById(R.id.spinner_from_taxi_fragment);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    @Override
    public void onStart() {
        super.onStart();

        addItemsOnSpinner();
    }
    public void addItemsOnSpinner() {


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinnerfrom, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);



    }


    private void finish() {
        // TODO Auto-generated method stub

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}







 /*ListView list = (ListView) view.findViewById(R.id.list_taxi);
        MySQLiteHelper helper = new MySQLiteHelper(getContext());
        Cursor cursor = helper.getReadableDatabase().query(
                TaxiTable.TABLE_TAXI,
                null,
                null,
                null,
                null,
                null,
                null
        );
        TaxiAdapter adapter = new TaxiAdapter(getContext(), cursor);
        list.setAdapter(adapter);*/