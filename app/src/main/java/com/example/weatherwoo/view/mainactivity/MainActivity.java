package com.example.weatherwoo.view.mainactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Currently;
import com.example.weatherwoo.model.Daily;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.view.NameViewModel;
import com.example.weatherwoo.view.adapter.dailyadapter.DailyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LATITUDE = "9.081999";
    private static final String LONGITUDE = "8.675277";

    // Declaring variables
    private NameViewModel viewModel;
    private RecyclerView rvHourly, rvDaily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing variables
        viewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        rvHourly = findViewById(R.id.rv_hourly);
        setupHourlyRecyclerView();
        rvDaily = findViewById(R.id.rv_daily);
        setupDailyRecyclerView();

        LoadWeather();
    }

    private void setupHourlyRecyclerView() {

    }

    private void setupDailyRecyclerView() {
        rvDaily.setLayoutManager(new LinearLayoutManager(this));
        rvDaily.setHasFixedSize(true);
        rvDaily.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    private void LoadWeather() {
        viewModel.getWeatherCall(LATITUDE, LONGITUDE).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                WeatherResponse weatherResponse = response.body();
                if (weatherResponse != null) {
                    // Load Currently
                    // Todo:

                    //Load Hourly
                    // Todo:

                    // Load Daily
                    LoadDaily(weatherResponse.getDaily());
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "FAILURE", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void LoadCurrently(Currently currently) {

        // Todo: Pass data into views
    }

    private void LoadHourly(Hourly hourly) {

    }

    private void LoadDaily(Daily daily) {
        DailyAdapter adapter = new DailyAdapter(daily.getData());
        rvDaily.setAdapter(adapter);
    }
}