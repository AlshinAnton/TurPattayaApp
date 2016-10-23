package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ExcursionDetailActivity extends AppCompatActivity {

    private TextView pagetitleExcursionDetail;
    private TextView contextExcursionDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_detail);

        pagetitleExcursionDetail = (TextView) findViewById(R.id.excursion_detail_pagetitle);
        contextExcursionDetail = (TextView) findViewById(R.id.excursion_detail_content);


    }

}