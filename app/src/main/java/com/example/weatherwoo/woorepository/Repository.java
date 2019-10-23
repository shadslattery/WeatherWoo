package com.example.weatherwoo.repository;

import android.database.Observable;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.repository.remote.RetrofitInstance;
import com.example.weatherwoo.repository.remote.WeatherService;

import retrofit2.Call;

class Repository {

    private static final String API_KEY = "";
    private WeatherService service;

    private Repository() {
        service = RetrofitInstance
                .getInstance()
                .create(WeatherService.class);
    }

    private static final class InstanceHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public Call<WeatherResponse> getWeatherCall(String longitude, String latitude) {
        return service.getWeatherCall(
                API_KEY,
                longitude,
                latitude
        );
    }

    public Observable<WeatherResponse> getWeatherObservable(String longitude, String latitude) {
        return service.getWeatherObservable(
                API_KEY,
                longitude,
                latitude
        );
    }

}