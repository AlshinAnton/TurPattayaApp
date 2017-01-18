package ru.turpattaya.turpattayaapp.excursions;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;

public class MainActivity extends BaseActivity {

    ListView listExcursion;
    String orderBy = "";
    static String selection = "";
    MySQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDrawer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listExcursion = (ListView) findViewById(R.id.list_excursion);

        helper = new MySQLiteHelper(this);

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
        listExcursion.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
       /* MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                Cursor cursor1 = helper.getReadableDatabase().rawQuery("SELECT * FROM ExcursionTable WHERE pagetitle like '%" + query + "%'", null);
                ExcursionAdapter adapter = new ExcursionAdapter(MainActivity.this, cursor1);
                listExcursion.setAdapter(adapter);
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return true;
            }
        });*/


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.category_islands:
                helper = new MySQLiteHelper(this);

                Cursor cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(1)},
                        null,
                        null,
                        null,
                        orderBy
                );
                ExcursionAdapter adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_zoo:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(2)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_show:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(3)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_temple:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(4)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_extreme:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(5)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_gardens_and_attractions:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(6)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;
            case R.id.category_fishing:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(8)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_mix_tours:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(9)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);
                return true;

            case R.id.category_nature:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        ExcursionTable.COLUMN_EXCURSION_CATEGORYID + " =?",
                        new String[]{String.valueOf(10)},
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

                return true;

            case R.id.category_main:

                cursorSort = helper.getReadableDatabase().query(
                        ExcursionTable.TABLE_EXCURSION,
                        null,
                        selection,
                        null,
                        null,
                        null,
                        orderBy
                );
                adapter = new ExcursionAdapter(this, cursorSort);
                listExcursion.setAdapter(adapter);

        }
        return super.onOptionsItemSelected(item);
    }

/*    private void sortByCategory() {

    }*/

}

/*    public void add_to_favorites(View view) {
        Toast.makeText(this, "Экскурсия добавлена в избранное", Toast.LENGTH_LONG).show();
    }*/
