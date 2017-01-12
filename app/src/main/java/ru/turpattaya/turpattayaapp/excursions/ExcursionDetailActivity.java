package ru.turpattaya.turpattayaapp.excursions;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.widget.TextView;


import java.util.ArrayList;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;
import ru.turpattaya.turpattayaapp.ViewHolders.ViewHolderExcursionDetail;

public class ExcursionDetailActivity extends BaseActivity {

    Cursor cursor;
    MySQLiteHelper helper;

    private TextView pagetitleExcursionDetail;
    private TextView contentExcursionDetail;
    /*ImageView imageFavoriteDetail;*/
    private ViewPager viewPagerDetail;
    private TextView priceForDetail;

    ImagesDetailPagerAdapter pagerAdapter;
    ArrayList<String> urls = new ArrayList<>();

    int c = 0x0E3F;
    String s = Character.toString((char)c);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDrawer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_detail);

        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);
        ViewHolderExcursionDetail holder = new ViewHolderExcursionDetail();
        pagetitleExcursionDetail = (TextView) findViewById(R.id.excursion_detail_pagetitle);
        contentExcursionDetail = (TextView) findViewById(R.id.excursion_detail_content);
        viewPagerDetail = (ViewPager) findViewById(R.id.viewPager_excursion_detail);
        priceForDetail = (TextView) findViewById(R.id.text_price_detail);
        /*imageFavoriteDetail = (ImageView) findViewById(R.id.image_detail_favorite);*/
        viewPagerDetail.setPageTransformer(true, new ImagesDetailAnimation());


       /* viewPagerDetail.setAdapter(pagerAdapter);
        UnderlinePageIndicator indicator = (UnderlinePageIndicator) findViewById(R.id.viewPager_indicator);
        indicator.setViewPager(viewPagerDetail);*/


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

        Cursor priceCursor = helper.getReadableDatabase().query(
                ExcursionTable.TABLE_EXCURSION,
                null,
                ExcursionTable.COLUMN_EXCURSION_ID + " =?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null
        );

        if (priceCursor !=null && priceCursor.moveToFirst()) {
             String price = priceCursor.getString(priceCursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_VALUE));

            priceForDetail.setText((price)+ s);
            priceCursor.close();
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


        while (!imagesCursor.isAfterLast()) {
            urls.add(imagesCursor.getString(imagesCursor.getColumnIndexOrThrow(ImagesDetailTable.COLUMN_IMAGESDETAIL_URL)));
            imagesCursor.moveToNext();
        }
        imagesCursor.close();

        if (urls.isEmpty()) return;

        pagerAdapter = new ImagesDetailPagerAdapter(getSupportFragmentManager(), urls);
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
            ExcursionImageItem excursionImageItemFragment = new ExcursionImageItem();
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

/*    public void add_to_favorites_from_detail(View view) {
        Toast.makeText(this, "Экскурсия добавлена в избранное", Toast.LENGTH_LONG).show();
    }*/
}



