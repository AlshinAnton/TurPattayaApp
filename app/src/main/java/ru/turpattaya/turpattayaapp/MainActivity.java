package ru.turpattaya.turpattayaapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.mikepenz.materialdrawer.Drawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, AdapterView.OnItemClickListener*/ {

    private Toolbar toolbar;

    private ListView list;
    private List<Excursion> data = new ArrayList<>();
    private ExcursionAdapter adapter;


    String orderBy = "";
    static String selection= "";
    private static String likeQuery="";

    SearchView searchView;

/*    private Drawer.Result drawerResult = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      /*  setTheme(R.style.AppThemeDrawer);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*searchView = (SearchView) findViewById(R.id.search_excursion);*/

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.logo);

        /*drawerResult = UtilsDrawer.createCommonDrawer(MainActivity.this, toolbar);
        drawerResult.setSelectionByIdentifier(1, false); // Set proper selection
        drawerResult.openDrawer();*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
/*        if (drawerResult.isDrawerOpen()) {
            // Закрываем меню, если оно показано и при этом нажата системная кнопка "Назад"
            drawerResult.closeDrawer();*/
            /*if (!searchView.isIconified()) {
                searchView.setIconified(true);*/
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_excursions) {
            /*Intent intent = new Intent(this, ExcursionActivity.class);
            startActivity(intent);*/

        } else if (id == R.id.nav_taxi) {

        } else if (id == R.id.nav_transfers) {
        } else if (id == R.id.nav_myFavorite) {
        } else if (id == R.id.nav_rates) {
        } else if (id == R.id.nav_weather) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_contacts) {
        } else if (id == R.id.nav_aboutUs) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}