package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class ExcursionDetailActivity extends AppCompatActivity {

    Cursor cursor;
    MySQLiteHelper helper;

    private TextView pagetitleExcursionDetail;
    private TextView contentExcursionDetail;

    private ViewPager viewPagerDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_detail);

        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);

        pagetitleExcursionDetail = (TextView) findViewById(R.id.excursion_detail_pagetitle);
        contentExcursionDetail = (TextView) findViewById(R.id.excursion_detail_content);
        viewPagerDetail = (ViewPager) findViewById(R.id.viewPager_excursion_detail);
        viewPagerDetail.setPageTransformer(true, new ImagesDetailAnimation());

        helper = new MySQLiteHelper(this);

            cursor = helper.getReadableDatabase().query(
                    ExcursionDetailTable.TABLE_EXCURSIONDETAIL,
                    null,
                    ExcursionDetailTable.COLUMN_EXCURSIONDETAIL_EXCURSIONID + " =?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null,
                    null
            );
            if (cursor != null && cursor.moveToFirst()) {
                String title = cursor.getString(cursor.getColumnIndex(ExcursionDetailTable.COLUMN_EXCURSIONDETAIL_PAGETITLE));
                pagetitleExcursionDetail.setText(Html.fromHtml(title));
                String content = cursor.getString(cursor.getColumnIndex(ExcursionDetailTable.COLUMN_EXCURSIONDETAIL_CONTENT));
                contentExcursionDetail.setText(Html.fromHtml(content));
                cursor.close();
        }

        Cursor imagesCursor = helper.getReadableDatabase().query(
                ImagesDetailTable.TABLE_IMAGESDETAIL,
                null,
                ImagesDetailTable.COLUMN_IMAGESDETAIL_EXCURSIONID + " =?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null
        );

        if (!imagesCursor.moveToFirst()) return;

        ArrayList<String> urls = new ArrayList<>();
        while (!imagesCursor.isAfterLast()) {
            urls.add(imagesCursor.getString(imagesCursor.getColumnIndexOrThrow(ImagesDetailTable.COLUMN_IMAGESDETAIL_URL)));
            imagesCursor.moveToNext();
        }
        imagesCursor.close();

        if (urls.isEmpty()) return;

        ImagesDetailPagerAdapter pagerAdapter = new ImagesDetailPagerAdapter(getSupportFragmentManager(), urls);
        viewPagerDetail.setAdapter(pagerAdapter);
    }

    private class ImagesDetailPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<String> adapterUrls;

        ImagesDetailPagerAdapter(FragmentManager fm, ArrayList<String> urls) {
            super(fm);
            this.adapterUrls = urls;
        }

        @Override
        public Fragment getItem(int position) {
            ExcursionImageItemFragment excursionImageItemFragment = new ExcursionImageItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", adapterUrls.get(position));
            excursionImageItemFragment.setArguments(bundle);
            return excursionImageItemFragment;
        }

        @Override
        public int getCount() {
            return adapterUrls.size();
        }

    }
}



