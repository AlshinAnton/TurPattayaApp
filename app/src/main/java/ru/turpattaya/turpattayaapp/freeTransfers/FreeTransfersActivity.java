package ru.turpattaya.turpattayaapp.freeTransfers;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;

public class FreeTransfersActivity extends BaseActivity {

    ListView listTransfer;

    MySQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_transfers);

        listTransfer = (ListView) findViewById(R.id.list_free_transfers);

        helper = new MySQLiteHelper(this);

        Cursor cursor = helper.getReadableDatabase().query(
                FreeTransfersTable.TABLE_FREE_TRANSFERS,
                null,
                null,
                null,
                null,
                null,
                null
        );
        FreeTransfersAdapter adapterTransfer = new FreeTransfersAdapter(this, cursor);
        listTransfer.setAdapter(adapterTransfer);
    }
}
