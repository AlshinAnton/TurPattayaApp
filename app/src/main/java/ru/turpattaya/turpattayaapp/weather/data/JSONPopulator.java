package ru.turpattaya.turpattayaapp.weather.data;

import org.json.JSONObject;

/**
 * Created by MSI on 12/15/2016.
 */

public interface JSONPopulator {
    void populate(JSONObject data);

    JSONObject toJSON();
}
