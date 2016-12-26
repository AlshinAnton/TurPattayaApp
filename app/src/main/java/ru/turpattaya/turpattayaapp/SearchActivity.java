package ru.turpattaya.turpattayaapp;


import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


public class SearchActivity extends ListActivity {

    private ListView listView;
    Cursor cursor;

    public void onCreate(Bundle savedInstanceState) {
        Log.d("Valo", "start search");
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
        listView = (ListView) findViewById(R.id.list_excursion);
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    public void onListItemClick(ListView l,
                                View v, int position, long id) {
        // call detail activity for clicked entry

    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query =
                    intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
    }

    private void doSearch(String queryStr) {
        // get a Cursor, prepare the ListAdapter
        // and set it
/*
        if (cursor != null && cursor.moveToFirst()) {
            String pagetitle = cursor.getString(cursor.getColumnIndex(ExcursionTable.COLUMN_EXCURSION_PAGETITLE));
            cursor.close();
        }


        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, queryStr); // ??why arrayAdapter
        listView.setAdapter(adapter);*/





    /*
        if (cursor != null && cursor.moveToFirst()) {
            String pagetitile = cursor.getString(cursor.getColumnIndex(ExcursionDetailTable.COLUMN_EXCURSIONDETAIL_PAGETITLE));

            cursor.close();
        }*/
    }
}