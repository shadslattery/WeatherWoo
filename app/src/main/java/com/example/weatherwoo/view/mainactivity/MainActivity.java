package com.example.weatherwoo.view.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.view.NameViewModel;

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
        setupHourlyRecyclerView;
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
}
