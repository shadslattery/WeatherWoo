package com.example.weatherwoo.Commons;

import com.example.weatherwoo.R;

public class WeatherUtils {

    public static int getWeatherIcon(String icon) {
        switch (icon) {
            case "clear-day":
                return 0;
            case "1":
                return 2;
            default:
                return R.drawable.ic_launcher_background;
        }

    }
}
