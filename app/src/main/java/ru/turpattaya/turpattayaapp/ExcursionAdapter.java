package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ExcursionAdapter extends CursorAdapter {


    public ExcursionAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View row = LayoutInflater.from(context).inflate(R.layout.item_excursion, viewGroup, false);

        ViewHolder holder = new ViewHolder();
        holder.imagePreview = (ImageView) row.findViewById(R.id.image_preview);
        holder.textExcursionPreview = (TextView) row.findViewById(R.id.text_excursion_preview);
        holder.textPricePreview = (TextView) row.findViewById(R.id.text_price_preview);
        // populateView(holder, cursor, context);

        row.setTag(holder);

        return row;

    }
    private void populateViewExcursion(ViewHolder holder, Cursor cursor, final Context context, View view)
    {
        holder.textExcursionPreview.setText(cursor.getString(cursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_PAGETITLE)));
        holder.textPricePreview.setText(cursor.getString(cursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_VALUE)));
        String url = cursor.getString(cursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_URL));
        if(!TextUtils.isEmpty(url))
        {
            Picasso.with(context).load(url).fit().centerCrop().into(holder.imagePreview);
            // holder.imagePreview.setImageURI(Uri.parse()));

        }

        final long id = cursor.getLong(cursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_ID));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Valo", "got it! -> " + id);
                Intent intent = new Intent(context, ExcursionDetailActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        populateViewExcursion(holder, cursor, context, view);
    }
}