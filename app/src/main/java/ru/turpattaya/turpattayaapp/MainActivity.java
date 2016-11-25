package ru.turpattaya.turpattayaapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends BaseActivity {

    String orderBy = "";
    static String selection= "";

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case R.id.menu_search_excursion:
                ExcursionsListFragment.handleSearch(item);
                return true;
            case R.id.menu_sort_ascending:
                orderBy = AnimalsTable.COLUMN_ANIMAL+ " asc";
                updateAdapterCursor();
                return true;
            case R.id.menu_sort_descending:
                orderBy = AnimalsTable.COLUMN_ANIMAL+ " desc";
                updateAdapterCursor();*/
                return true;
        }

   /* public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            //
        }
    }*/
}