package com.example.weatherwoo.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.woorepository.Repository;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;

public class NameViewModel extends AndroidViewModel {
    // Declare Repo
    private Repository repo;


    public NameViewModel(@NonNull Application application) {
        super(application);
        this.repo = Repository.getInstance();
    }

    public Call<WeatherResponse> getWeatherCall(String longitude, String latitude) {
        return repo.getWeatherCall(longitude, latitude);
    }

    public Observable<WeatherResponse> getWeatherObservable(String longitude, String latitude){
        return repo.getWeatherObservable(longitude, latitude);
    }

    public Single<WeatherResponse> getWeatherSingle(String longitude, String latitude) {
        return repo.getWeatherSingle(longitude,latitude);
    }
}