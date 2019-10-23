package com.example.weatherwoo.woorepository;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.woorepository.remote.RetrofitInstance;
import com.example.weatherwoo.woorepository.remote.WeatherService;

import java.util.Observable;

import retrofit2.Call;

 public  class Repository {

    private static final String API_KEY = "";
        private WeatherService service;

    private Repository() {
        service = RetrofitInstance
                .getInstance()
                .create(WeatherService.class);
    }

    private static final class InstanceHolder { /* modules are responsible for handling data operations. */
       private static final Repository INSTANCE = new Repository(); /* Objects to store their states */
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
