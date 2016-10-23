package ru.turpattaya.turpattayaapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 20.10.2016.
 */

public class ExcursionDetailTable {
    public static final String TABLE_EXCURSIONDETAIL = "ExcursionDetailTable";
    public static final String COLUMN_EXCURSIONDETAIL_ID = "_id";
    public static final String COLUMN_EXCURSIONDETAIL_EXCURSIONID = "excursionid";
    public static final String COLUMN_EXCURSIONDETAIL_URL = "url";
    public static final String COLUMN_EXCURSIONDETAIL_PAGETITLE = "pagetitle";
    public static final String COLUMN_EXCURSIONDETAIL_CONTENT = "content";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}