package ru.turpattaya.turpattayaapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

/*    private ArrayList listTaxiFrom;
    private ArrayList listTaxiDestination;
    private ArrayList listCarType;*/
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

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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







    private String calculatePrice() {
        Cursor cursor = null;
        String fromcode;
        String destinationcode;


        MySQLiteHelper helper = new MySQLiteHelper(getActivity());

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





/*    private void loadSpinnerData() {
        listTaxiFrom = new ArrayList<String>();
        helper.getReadableDatabase();

        Cursor taxiFromCursor = helper.getReadableDatabase().query(TaxiTable.COLOMN_TAXI_FROM,
                null,
                null,
                null,
                null,
                null,
                null);
        taxiFromCursor.moveToFirst();
        if (!taxiFromCursor.isAfterLast()) {
            do {
                String taxiFrom = taxiFromCursor.getString(1);
                spinnerFrom.addView(taxiFrom);
            } while (taxiFromCursor.moveToNext());
        }
        taxiFromCursor.close();
        helper.close();   // Закрываем БД
    }*/


/*
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
    }*/
/*
 */
/*









 String[] listTaxiFrom = new String[] {"_id", "from"};
        helper = new MySQLiteHelper(getActivity());

        spinnerFromAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_spinner_item,
                null,                                                                               //Вместо курсора передаем null, ибо CursorLoader по окончании выборки сам создаст нам курсор.
                new String[]{"from"},
                new int[]{android.R.id.text1},
                0);                                                                                 //индекс CursorLoader-а.
        spinnerFromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnerFromAdapter);

        getActivity().getSupportLoaderManager().initLoader(0, null, this);
public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
    // Готовим колонки и условие
    String[] from = new String[] { "_id", "from" };
    // создаем и возвращаем настроенный лоадер поиска
    return new CursorLoader(getActivity(), URI, from, null, null, null);
}

    // обработчик окончания выборки из БД
    @Override
    public void onLoadFinished(Loader arg0, Cursor arg1) {
        spinnerFromAdapter.swapCursor(arg1);
        break;
    }


    // Этот метод нам без надобности

    @Override
    public void onLoaderReset(Loader arg0) {

    }*/
