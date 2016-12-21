package ru.turpattaya.turpattayaapp.excursions;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;


public class MainActivity extends BaseActivity {

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

    public void add_to_favorites(View view) {
        Toast.makeText(this, "Экскурсия добавлена в избранное", Toast.LENGTH_LONG).show();
    }
}