package ru.turpattaya.turpattayaapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 30.10.2016.
 */

public class TaxiDestinationTable {
    public static final String COLUMN_TAXIDESTINATION_ID = "_id";
    public static final String COLUMN_TAXIDESTINATION_DESTINATIONCODE = "destinationCode";
    public static final String COLUMN_TAXIDESTINATION_DESTINATIONRUSSIANNAME = "destinationRussianName";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
