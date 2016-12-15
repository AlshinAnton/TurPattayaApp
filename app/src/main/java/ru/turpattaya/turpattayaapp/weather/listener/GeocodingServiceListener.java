package ru.turpattaya.turpattayaapp.weather.listener;

import ru.turpattaya.turpattayaapp.weather.data.LocationResult;

public interface GeocodingServiceListener {
    void geocodeSuccess(LocationResult location);

    void geocodeFailure(Exception exception);
}
