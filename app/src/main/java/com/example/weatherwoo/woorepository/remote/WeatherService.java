package com.example.weatherwoo.woorepository.remote;

import com.example.weatherwoo.model.WeatherResponse;

import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    /* The method takes one parameter key_element of object type and refers to the key whose associated
    value is supposed to be fetched.
     */
    @GET(RemoteConstants.WOO_PATH)
    Call<WeatherResponse> getWeatherCall(
            @Path("apiKey") String apiKey,
            @Path("Longitude") String Longitude,
            @Path("Latitude") String Latitude
    );

    // region RXJava
    @GET(RemoteConstants.WOO_PATH)
    Single<WeatherResponse> getWeatherSingle(
            @Path("apiKey") String apiKey,
            @Path("Longitude") String Longitude,
            @Path("Latitude") String Latitude
    );

    @GET(RemoteConstants.WOO_PATH)
    Observable<WeatherObservable> getWeatherObservable(
            @Path("apiKey") String apiKey,
            @Path("Longitude") String Longitude,
            @Path("Latitude") String Latitude
    );

    @GET(RemoteConstants.WOO_PATH)
    Maybe<WeatherResponse> getWeatherMaybe(
            @Path("apiKey") String apiKey,
            @Path("Longitude") String Longitude,
            @Path("Latitude") String Latitude
    );

    @GET(RemoteConstants.WOO_PATH)
    Flowable<WeatherResponse> getWeatherFlowable(
            @Path("apiKey") String apiKey,
            @Path("Longitude") String Longitude,
            @Path("Latitude") String Latitude
    );
    // endregion
}
