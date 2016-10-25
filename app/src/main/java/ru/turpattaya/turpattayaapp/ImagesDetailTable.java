package ru.turpattaya.turpattayaapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 26.10.2016.
 */

public class ImagesDetailTable {
    public static final String TABLE_IMAGESDETAIL = "ImagesDetailTable";
    public static final String COLUMN_IMAGESDETAIL_ID = "_id";
    public static final String COLUMN_IMAGESDETAIL_EXCURSIONID = "excursionid";
    public static final String COLUMN_IMAGESDETAIL_URL = "url";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
