package ru.turpattaya.turpattayaapp;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class ExcursionsListFragment extends Fragment  {

/*
    public interface GoToDetailActivity {
        public void StartDetail();
    }
*/

    public ExcursionsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

/*        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ExampleFragment fragment = new ExampleFragment();
        fragmentTransaction.add(R.id.fragm_list, fragment);
        fragmentTransaction.commit();*/



        View view = inflater.inflate(R.layout.fragment_list_excursions, container, false);

        ListView list = (ListView) view.findViewById(R.id.list_excursion);

        MySQLiteHelper helper = new MySQLiteHelper(getContext());

        Cursor cursor = helper.getReadableDatabase().query(
                ExcursionTable.TABLE_EXCURSION,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ExcursionAdapter adapter = new ExcursionAdapter(getContext(), cursor);

        list.setAdapter(adapter);

 /*       list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}