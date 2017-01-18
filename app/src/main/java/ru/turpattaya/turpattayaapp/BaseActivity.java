package ru.turpattaya.turpattayaapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import ru.turpattaya.turpattayaapp.currencyExchange.CurrencyExchangeActivity;
import ru.turpattaya.turpattayaapp.excursions.MainActivity;
import ru.turpattaya.turpattayaapp.taxi.TaxiActivity;
import ru.turpattaya.turpattayaapp.weather.WeatherActivity;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public void setContentView(int layoutResID)
    {
        setTheme(R.style.AppThemeDrawer);
        DrawerLayout drawer = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) drawer.findViewById(R.id.activity_base_content_frame);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_excursions) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_taxi) {
            Intent intent = new Intent(this, TaxiActivity.class);
            startActivity(intent);
/*        } else if (id == R.id.nav_myFavorite) {
            Intent intent = new Intent(this, MyFavoriteActivity.class);
            startActivity(intent);*/
        } else if (id == R.id.nav_rates) {
            Intent intent = new Intent(this, CurrencyExchangeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_weather) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contacts) {
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_free_transfers) {
            Intent intent = new Intent(this, FreeTransfersActivity.class);
            startActivity(intent);
        }
/*        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(this, ShareActivity.class);
            startActivity(intent);
        */


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}