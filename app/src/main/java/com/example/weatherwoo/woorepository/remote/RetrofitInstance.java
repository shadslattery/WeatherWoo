package com.example.weatherwoo.woorepository.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance  {

    // Step 1: Create a Private Constructor
    private RetrofitInstance() {

    }
    // Step 2: Create Inner class to provide instance of Retrofit
    private static class InstanceHolder {
        // Create a Retrofit Instance
        private static final Retrofit INSTANCE = new Retrofit
                .Builder()
                .baseUrl(RemoteConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    // Step 3 cont: This is a optimized way for Retrofit
    public static Retrofit getInstance() {
        return InstanceHolder.INSTANCE;
    }
}