package com.example.weatherwoo.woorepository;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.woorepository.remote.RetrofitInstance;
import com.example.weatherwoo.woorepository.remote.WeatherService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;

public class Repository {

    private static final String API_KEY = "57c8ab4731ae54d48badbe0a62e924dd";
    private WeatherService service;

    private  Repository() {
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

        public Call<WeatherResponse> getWeatherCall(String latitude, String longitude) {
            return service.getWeatherCall(
                    API_KEY,
                    latitude,
                    longitude
            );
        }
        public Single<WeatherResponse> getWeatherSingle(String latitude, String longitude) {
            return service.getWeatherSingle(

                    API_KEY,
                    latitude,
                    longitude

                    /*@Path("apiKey") String API_KEY,
                    @Path("latitude") String latitude,
                    @Path("longitude") String longitude*/
            );
        }
        public Observable<WeatherResponse> getWeatherObservable(String latitude, String longitude ) {
            return service.getWeatherObservable(
                    API_KEY,
                    latitude,
                    longitude
            );
        }

        public Maybe<WeatherResponse> getWeatherMaybe(String latitude, String longitude ) {
            return service.getWeatherMaybe(
                    API_KEY,
                    latitude,
                    longitude
            );
        }

        public Flowable<WeatherResponse> getWeatherFlowable(String latitude , String longitude) {
            return service.getWeatherFlowable(
                    API_KEY,
                    latitude,
                    longitude
            );
        }

}