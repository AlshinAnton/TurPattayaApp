package ru.turpattaya.turpattayaapp;

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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.mikepenz.materialdrawer.Drawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPagerTabs;

    private ListView list;
    private List<Excursion> data = new ArrayList<>();
    private ExcursionAdapter adapter;

    SearchView searchView;

/*    private Drawer.Result drawerResult = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      /*  setTheme(R.style.AppThemeDrawer);*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPagerTabs = (ViewPager) findViewById(R.id.viewPager);
        /*searchView = (SearchView) findViewById(R.id.search_excursion);*/

        setupViewPager(viewPagerTabs);// будет добавлять объекты в адаптер
        tabLayout.setupWithViewPager(viewPagerTabs);

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
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExcursionsListFragment(), "Экскурсии");
        adapter.addFragment(new TaxiFragment(), "Такси");
        adapter.addFragment(new TransfersFragment(), "Трансферы");
        adapter.addFragment(new AboutFragment(), "О нас");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }



    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>(); //контейнер для фрагментов
        private  final List<String> titleList = new ArrayList<>(); // контейнер для заголовков Tabs

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {// напишем функцию, которая в этот адаптер добавит фрагмент и тайтл
            fragmentList.add(fragment);
            titleList.add(title);

        }


        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START); }
/*        if (drawerResult.isDrawerOpen()) {
            // Закрываем меню, если оно показано и при этом нажата системная кнопка "Назад"
            drawerResult.closeDrawer();*/
            if (!searchView.isIconified()) {
                searchView.setIconified(true);
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