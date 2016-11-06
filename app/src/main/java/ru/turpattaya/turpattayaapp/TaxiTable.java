package ru.turpattaya.turpattayaapp;

import android.database.sqlite.SQLiteDatabase;


public class TaxiTable {

    public static final String TABLE_TAXI = "TaxiTable";
    public static final String COLOMN_TAXI_ID = "_id";
    public static final String COLOMN_TAXI_FROMCODE = "fromcode";
    public static final String COLOMN_TAXI_DESTINATIONCODE = "destinationcode";
    public static final String COLOMN_TAXI_PRICESMALCAR = "priceSmalCar";
    public static final String COLOMN_TAXI_PRICEINOVACAR = "priceInovaCar";
    public static final String COLOMN_TAXI_PRICEMINIBUSCAR = "priceMinibusCar";

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
