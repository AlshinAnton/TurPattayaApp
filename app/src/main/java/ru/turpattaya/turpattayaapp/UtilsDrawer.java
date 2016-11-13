package ru.turpattaya.turpattayaapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class UtilsDrawer {

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            //
        }
    }

    public static Drawer.OnDrawerItemClickListener handlerOnClick(final Drawer.Result drawerResult, final MainActivity activity) {
        return new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                //check if the drawerItem is set.
                //there are different reasons for the drawerItem to be null
                //--> click on the header
                //--> click on the footer
                //those items don't contain a drawerItem

                if (drawerItem != null) {

                    if (drawerItem.getIdentifier() == 1) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_excursions, new ExcursionsListFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 2) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_taxi, new TaxiFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 3) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_transfers, new TransfersFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 4) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_myFavorite, new MyFavoriteFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 5) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_rates, new RatesFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 6) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_weather, new WeatherFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 7) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_share, new ShareFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 8) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_contacts, new ContactsFragment()).commit();
                    } else if (drawerItem.getIdentifier() == 9) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_aboutUs, new AboutFragment()).commit();
                        try {
                            Intent int_rate = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + activity.getApplicationContext().getPackageName()));
                            int_rate.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.getApplicationContext().startActivity(int_rate);
                        } catch (Exception e) {
                            //
                        }
                    }
                }
            }
        };
    }

    public static Drawer.Result createCommonDrawer(final MainActivity activity, Toolbar toolbar) {

        Drawer.Result drawerResult = new Drawer()
                .withActivity(activity)
                .withHeader(R.layout.nav_header_main)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.nav_excursions).withIcon(R.drawable.ic_pool_white_24dp).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.nav_taxi).withIcon(R.drawable.ic_local_taxi_white_24dp).withIdentifier(2),
                        // Вывод НЕ для Google Play
                        new PrimaryDrawerItem().withName(R.string.nav_transfers).withIcon(R.drawable.ic_directions_bus_white_24dp).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.nav_myFavorite).withIcon(R.drawable.ic_favorite_white_24dp).withIdentifier(4),
                        new PrimaryDrawerItem().withName(R.string.nav_rates).withIcon(R.drawable.ic_euro_symbol_white_24dp).withIdentifier(5),
                        new PrimaryDrawerItem().withName(R.string.nav_weather).withIcon(R.drawable.ic_wb_sunny_white_24dp).withIdentifier(6),
                        new PrimaryDrawerItem().withName(R.string.nav_share).withIcon(R.drawable.ic_menu_share).withIdentifier(7),
                        new PrimaryDrawerItem().withName(R.string.nav_contacts).withIcon(R.drawable.ic_contact_phone_white_24dp).withIdentifier(8),
                        new PrimaryDrawerItem().withName(R.string.nav_aboutUs).withIcon(R.drawable.ic_info_white_24dp).withIdentifier(9)

                        // Вывод для Google Play
                        //new PrimaryDrawerItem().withName(R.string.drawer_item_out).withIcon(GoogleMaterial.Icon.gmd_attach_money).withIdentifier(4),
                        //new DividerDrawerItem(),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(50),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(GoogleMaterial.Icon.gmd_help).withIdentifier(60),
                        //new DividerDrawerItem(),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_rate).withIdentifier(70)
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_donate).withIdentifier(80)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public boolean equals(Object o) {
                        return super.equals(o);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        //Toast.makeText(MainActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                        hideSoftKeyboard(activity);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        //Toast.makeText(MainActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                })
                .build();

        drawerResult.setOnDrawerItemClickListener(handlerOnClick(drawerResult, activity));

        return drawerResult;
    }
}