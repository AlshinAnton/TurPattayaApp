package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import ru.turpattaya.turpattayaapp.ViewHolders.ViewHolderExcursionDetail;
import ru.turpattaya.turpattayaapp.ViewHolders.ViewHolderExcursionList;

/**
 * Created by MSI on 13.10.2016.
 */

public class ExcursionDetailAdapter extends CursorAdapter {

    public ExcursionDetailAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View row = LayoutInflater.from(context).inflate(R.layout.image_for_viewpager_detailactivity, viewGroup, false);

        ViewHolderExcursionDetail holder = new ViewHolderExcursionDetail();
        /*holder.viewPagerDetail = (ViewPager) row.findViewById(R.id.viewPager_excursion_detail);*/
        holder.imageViewExcursionDetail = (ImageView) row.findViewById(R.id.image1_excursion_detail);
        row.setTag(holder);
        return row;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolderExcursionDetail holder = (ViewHolderExcursionDetail) view.getTag();
        populateViewDetailExcursion(holder, cursor, context);
    }

    private void populateViewDetailExcursion(ViewHolderExcursionDetail holder, Cursor cursor, Context context) {

        String url = cursor.getString(cursor.getColumnIndex(ImagesDetailTable.COLUMN_IMAGESDETAIL_URL));
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url).fit().centerCrop().into((Target) holder.imageViewExcursionDetail);
        }
    }
}