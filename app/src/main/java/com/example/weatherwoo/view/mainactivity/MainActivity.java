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
import com.example.weatherwoo.view.adapter.hourlyadapter.HourlyAdapter;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LATITUDE = "37.7749";
    private static final String LONGITUDE = "-122.4194";
// LATITUDE "41.0793"   LONGITUDE  "-85.1394"  Indianapolis
// LATITUDE "40.4406"   LONGITUDE  "-79.9959"  Pittsburgh
// LATITUDE "41.8781"   LONGITUDE  "-87.6298"  Chicago
// LATITUDE "37.7749"   LONGITUDE  "-122.4194" San Franciso
// LATITUDE "37.3382"  LONGITUDE  "-121.8863" San Jose



    // Declaring variables
    private NameViewModel viewModel;
    private RecyclerView rvHourly, rvDaily;
    private MaterialTextView tvTemp;
    private MaterialTextView tvCity;
    private MaterialTextView tvTime;


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

        tvTemp = findViewById(R.id.tv_temp);
        tvTime = findViewById(R.id.tvTime);
        tvCity = findViewById(R.id.tv_city);

        LoadWeather();
    }

    private void setupHourlyRecyclerView() {
       // rvHourly.setLayoutManager(new LinearLayoutManager(this));
        rvHourly.setHasFixedSize(true);
        rvHourly.addItemDecoration(new DividerItemDecoration(this,
                    DividerItemDecoration.HORIZONTAL));
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
                    LoadCurrently(weatherResponse);

                    //Load Hourly
                    // Todo:
                    LoadHourly(weatherResponse.getHourly());

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


    private void LoadCurrently(WeatherResponse weatherResponse) {  // this is a Parameter
        Currently currently = weatherResponse.getCurrently();
        // This Displays the Current Temperature in the Current Filed
        // Todo: Pass data into views
        Double tempAsDouble = (currently.getTemperature());
        //Toast.makeText(MainActivity.this, String.valueOf(tempAsDouble), Toast.LENGTH_SHORT).show();
        //String getRoundedTemp(Double)
        String string = String.valueOf(Math.round(currently.getTemperature()));
        tvTemp.setText(string + "\u00B0");


        String timezoneID = weatherResponse.getTimezone();
        String[] timezoneID2 = timezoneID.split("/");
        tvCity.setText(timezoneID2[1]);
        }

    private void LoadHourly(Hourly hourly) {
        HourlyAdapter adapter = new HourlyAdapter(hourly.getData());
        rvHourly.setAdapter(adapter);
    }

    private void LoadDaily(Daily daily) {
        DailyAdapter adapter = new DailyAdapter(daily.getData());
        rvDaily.setAdapter(adapter);

    }
}