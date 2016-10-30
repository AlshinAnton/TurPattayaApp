package ru.turpattaya.turpattayaapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 30.10.2016.
 */

public class TaxiPlacesTable {
    public static final String COLUMN_TAXIPLACES_ID = "_id";
    public static final String COLUMN_TAXIPLACES_PLACE = "place";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
