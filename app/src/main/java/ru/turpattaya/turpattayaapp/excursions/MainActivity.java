package ru.turpattaya.turpattayaapp.excursions;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;

public class MainActivity extends BaseActivity {

    String orderBy = "";
    static String selection= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDrawer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list_excursion);

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

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

            MenuItem searchItem = menu.findItem(R.id.item_search);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
                @Override
                public boolean onQueryTextChange(String newText) {

                    return true;
                }

                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }
            });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.category_islands:

                return true;
            case R.id.category_zoo:

                return true;
            case R.id.category_show:

                return true;
            case R.id.category_temple:

                return true;
            case R.id.category_extreme:

                return true;
            case R.id.category_gardens_and_attractions:

                return true;
            case R.id.category_fishing:

                return true;
            case R.id.category_mix_tours:

                return true;
            case R.id.category_nature:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

/*    public void add_to_favorites(View view) {
        Toast.makeText(this, "Экскурсия добавлена в избранное", Toast.LENGTH_LONG).show();
    }*/
