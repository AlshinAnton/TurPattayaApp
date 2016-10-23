package ru.turpattaya.turpattayaapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class ExcursionDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_excursion, container, false);
        ViewFlipper viewFlipperDetailExcursion = (ViewFlipper) view.findViewById(R.id.viewFlipper_excursion_detail);
        TextView pagetitle = (TextView) view.findViewById(R.id.excursion_detail_pagetitle);
        TextView content = (TextView) view.findViewById(R.id.excursion_detail_content);

        MySQLiteHelper helper = new MySQLiteHelper(getContext());

        Cursor cursor = helper.getReadableDatabase().query(
                ExcursionDetailTable.TABLE_EXCURSIONDETAIL,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ExcursionDetailAdapter adapter = new ExcursionDetailAdapter(getContext(), cursor);


        /*list.setAdapter(adapter);*/

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


    }
}
