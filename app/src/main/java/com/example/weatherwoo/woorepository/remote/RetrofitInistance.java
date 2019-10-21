package com.example.weatherwoo.woorepository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.provider.SyncStateContract;

import com.google.gson.Gson;

public class RetrofitInistance  {

    // Step 1: Create a Private Constructor
    private RetrofitInistance() {

    }
    // Step 2: Create Inner class to provide instance of Retrofit
    private static class RetrofitInstanceHolder {
        // Create a Retrofit Instance
        static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(RemoteConstance.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Step 3: PUBLIC static method to access the instance of Retrofit
    public static Retrofit getInstance() {
        return RetrofitInstanceHolder.INSTANCE;
    }

    // Step 3 cont: This is a optimized way for Retrofit
    public static <S> S createService(Class<S> serviceClass) {
        return RetrofitInstanceHolder.INSTANCE.create(serviceClass);
    }


}