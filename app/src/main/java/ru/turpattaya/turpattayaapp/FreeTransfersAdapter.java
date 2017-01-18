package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.turpattaya.turpattayaapp.ViewHolders.ViewHolderFreeTransfers;

public class FreeTransfersAdapter extends CursorAdapter {

    public FreeTransfersAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View row = LayoutInflater.from(context).inflate(R.layout.item_free_transfer, viewGroup, false);

        ViewHolderFreeTransfers holderFreeTransfers = new ViewHolderFreeTransfers();
        holderFreeTransfers.titleFreeTransfers = (TextView) row.findViewById(R.id.title_free_transfer);
        holderFreeTransfers.imageFreeTransfers = (ImageView) row.findViewById(R.id.image_free_transfer);
        holderFreeTransfers.contentFreeTransfers = (TextView) row.findViewById(R.id.content_free_transfer);
        row.setTag(holderFreeTransfers);

        return row;
    }

    public void populateViewFreeTransfers(ViewHolderFreeTransfers holderFreeTransfers, Cursor cursor, Context context, View view) {
        holderFreeTransfers.titleFreeTransfers.setText(cursor.getString(cursor.getColumnIndex(FreeTransfersTable.COLUMN_FREE_TRANSFERS_PAGETITLE)));
        holderFreeTransfers.contentFreeTransfers.setText(cursor.getString(cursor.getColumnIndex(FreeTransfersTable.COLUMN_FREE_TRANSFERS_CONTENT)));
        String url = cursor.getString(cursor.getColumnIndex(FreeTransfersTable.COLUMN_FREE_TRANSFERS_URL));

        if(!TextUtils.isEmpty(url))
        {
            Picasso.with(context).load(url).fit().centerCrop().into(holderFreeTransfers.imageFreeTransfers);
        }

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolderFreeTransfers holderFreeTransfers = (ViewHolderFreeTransfers) view.getTag();
        populateViewFreeTransfers(holderFreeTransfers, cursor, context, view);
    }
}
