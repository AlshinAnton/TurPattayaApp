package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import ru.turpattaya.turpattayaapp.excursions.CategoryTable;
import ru.turpattaya.turpattayaapp.excursions.ExcursionDetailTable;
import ru.turpattaya.turpattayaapp.excursions.ExcursionTable;
import ru.turpattaya.turpattayaapp.excursions.ImagesDetailTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiDestinationTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiFromTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiTable;

public class MySQLiteHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "tourptt.sqlite";
    private static final int DATABASE_VERSION = 3;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i3) {
        ExcursionTable.onUpgrade(sqLiteDatabase, i, i3);
        ExcursionDetailTable.onUpgrade(sqLiteDatabase, i, i3);
        CategoryTable.onUpgrade(sqLiteDatabase, i, i3);
        ImagesDetailTable.onUpgrade(sqLiteDatabase, i, i3);
        TaxiDestinationTable.onUpgrade(sqLiteDatabase, i, i3);
        TaxiFromTable.onUpgrade(sqLiteDatabase, i, i3);
        TaxiTable.onUpgrade(sqLiteDatabase, i, i3);
        FreeTransfersTable.onUpgrade(sqLiteDatabase, i, i3);
    }
}