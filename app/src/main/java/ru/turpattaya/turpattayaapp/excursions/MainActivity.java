package ru.turpattaya.turpattayaapp.excursions;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import ru.turpattaya.turpattayaapp.BaseActivity;
import ru.turpattaya.turpattayaapp.MySQLiteHelper;
import ru.turpattaya.turpattayaapp.R;
import ru.turpattaya.turpattayaapp.SearchActivity;


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

    public void add_to_favorites(View view) {
        Toast.makeText(this, "Экскурсия добавлена в избранное", Toast.LENGTH_LONG).show();
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {

        startActivity(new Intent(this, SearchActivity.class));
    }
*/
}