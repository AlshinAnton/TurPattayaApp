package ru.turpattaya.turpattayaapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.turpattaya.turpattayaapp.excursions.Excursion;

/**
 * Created by MSI on 12/22/2016.
 */

public class SharedPreference {
    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Excursion> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, Excursion excursion) {
        ArrayList<Excursion> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Excursion>();
        favorites.add(excursion);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Excursion excursion) {
        ArrayList<Excursion> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(excursion);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Excursion> getFavorites(Context context) {
        SharedPreferences settings;
        List<Excursion> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Excursion[] favoriteItems = gson.fromJson(jsonFavorites,
                    Excursion[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Excursion>(favorites);
        } else
            return null;

        return (ArrayList<Excursion>) favorites;
    }
}