package com.example.weatherwoo.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.woorepository.Repository;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
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

    public Call<WeatherResponse> getWeatherCall(String latitude, String longitude) {
        return repo.getWeatherCall(latitude, longitude);
    }

    public Single<WeatherResponse> getWeatherSingle(String latitude, String longitude ) {
        return repo.getWeatherSingle(latitude, longitude);
    }

    public Observable<WeatherResponse> getWeatherObservable(String latitude, String longitude ){
        return repo.getWeatherObservable(latitude, longitude);
    }

    public Maybe<WeatherResponse> getWeatherMaybe(String latitude, String longitude ) {
        return repo.getWeatherMaybe(latitude, longitude);
    }

    public Flowable<WeatherResponse> getWeatherFlowable(String latitude, String longitude) {
        return repo.getWeatherFlowable(latitude, longitude);
    }

    }
