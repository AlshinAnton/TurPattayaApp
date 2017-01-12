package ru.turpattaya.turpattayaapp.excursions;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MSI on 1/8/2017.
 */

public class CategoryTable {
    public static final String TABLE_CATEGORY = "CategoryTable";
    public static final String COLUMN_CATEGORY_ID = "_id";
    public static final String COLUMN_CATEGORY_NAME = "categoryname";


    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
