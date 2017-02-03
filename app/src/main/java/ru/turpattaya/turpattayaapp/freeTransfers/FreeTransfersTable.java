package ru.turpattaya.turpattayaapp.freeTransfers;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 1/19/2017.
 */

public class FreeTransfersTable {
    public static final String TABLE_FREE_TRANSFERS = "FreeTransfersTable";
    public static final String COLUMN_FREE_TRANSFERS_ID = "_id";
    public static final String COLUMN_FREE_TRANSFERS_PAGETITLE = "title";
    public static final String COLUMN_FREE_TRANSFERS_CONTENT = "content";
    public static final String COLUMN_FREE_TRANSFERS_URL = "url";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
