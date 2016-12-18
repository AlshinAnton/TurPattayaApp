package ru.turpattaya.turpattayaapp.taxi;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 30.10.2016.
 */

public class TaxiFromTable {
    public static final String TABLE_TAXIFROMTABLE = "TaxiFromTable";
    public static final String COLUMN_TAXIFROM_ID = "_id";
    public static final String COLUMN_TAXIFROM_FROMCODE = "fromCode";
    public static final String COLUMN_TAXIFROM_FROMRUSSIANNAME = "fromRussianName";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
