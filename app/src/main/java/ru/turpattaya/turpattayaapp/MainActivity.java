package ru.turpattaya.turpattayaapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ListView;


public class MainActivity extends BaseActivity{

    String orderBy = "";
    static String selection= "";

    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDrawer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*searchView = (SearchView) findViewById(R.id.search_excursion);*/

        ListView list = (ListView) findViewById(R.id.list_excursion);
/*        TextView title = (TextView) view.findViewById(R.id.excursion_detail_pagetitle); */

        MySQLiteHelper helper = new MySQLiteHelper(this);

        Cursor cursor = helper.getReadableDatabase().query(
                ExcursionTable.TABLE_EXCURSION,
                null,
                selection,
                null,
                null,
                null,
                orderBy
        );
        ExcursionAdapter adapter = new ExcursionAdapter(this, cursor);

        list.setAdapter(adapter);
    }
}