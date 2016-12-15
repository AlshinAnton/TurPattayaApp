package ru.turpattaya.turpattayaapp.weather.listener;

import ru.turpattaya.turpattayaapp.weather.data.Channel;

public interface WeatherServiceListener {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
