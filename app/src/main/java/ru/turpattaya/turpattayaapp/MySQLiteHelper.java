package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import ru.turpattaya.turpattayaapp.excursions.CategoryTable;
import ru.turpattaya.turpattayaapp.excursions.ExcursionDetailTable;
import ru.turpattaya.turpattayaapp.excursions.ExcursionTable;
import ru.turpattaya.turpattayaapp.excursions.ImagesDetailTable;
import ru.turpattaya.turpattayaapp.freeTransfers.FreeTransfersTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiDestinationTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiFromTable;
import ru.turpattaya.turpattayaapp.taxi.TaxiTable;


public class MySQLiteHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "tourptt.sqlite";
    private static final int DATABASE_VERSION = 3;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i1, int i2) {
        ExcursionTable.onUpgrade(sqLiteDatabase, i1, i2);
        ExcursionDetailTable.onUpgrade(sqLiteDatabase, i1, i2);
        CategoryTable.onUpgrade(sqLiteDatabase, i1, i2);
        ImagesDetailTable.onUpgrade(sqLiteDatabase, i1, i2);
        TaxiDestinationTable.onUpgrade(sqLiteDatabase, i1, i2);
        TaxiFromTable.onUpgrade(sqLiteDatabase, i1, i2);
        TaxiTable.onUpgrade(sqLiteDatabase, i1, i2);
        FreeTransfersTable.onUpgrade(sqLiteDatabase, i1, i2);
    }
}



