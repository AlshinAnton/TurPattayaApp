package ru.turpattaya.turpattayaapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class TaxiFragment extends Fragment {
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Spinner spinnerCar;
    private TextView priceRezult;
    private Button buttonOrderTaxi;


    public TaxiFragment() {        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
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

        spinnerFrom.setOnItemSelectedListener(new CustomOnItemSelectedListener());
/*        spinnerTo.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinnerCar.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        buttonOrderTaxi.setOnClickListener(new CustomOnClickListener());*/

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


        ArrayAdapter<CharSequence> adapterFrom = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerfrom, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterTo = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerto, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterCar = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerTypeOfCar, android.R.layout.simple_spinner_item);

        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerTo.setAdapter(adapterTo);
        spinnerCar.setAdapter(adapterCar);



    }


    private void finish() {
        // TODO Auto-generated method stub

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private class CustomOnItemSelectedListener extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            switch (view.getId()) {
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    private class CustomOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }
}





/*
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
    private Spinner spinnerCar;
    private Button buttonOrderTaxi;
    private Activity rootView;


    public TaxiFragment() {        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_taxi, container, false);
        spinnerFrom = (Spinner) rootView.findViewById(R.id.spinner_from_taxi_fragment);
        spinnerFrom.setPrompt("Откуда");
        spinnerTo = (Spinner) rootView.findViewById(R.id.spinner_destination_fragment_taxi);
        spinnerCar = (Spinner) rootView.findViewById(R.id.spinner_typeOfCar_fragment_taxi);

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
*/
