package com.example.weatherwoo.Commons;

import com.example.weatherwoo.R;

public class WeatherUtils {

    public static int getWeatherIcon(String icon) {
        switch (icon) {
            case "clear-day":
                return R.drawable.clear_day;
            case "clear-night":
                return 2;
            case "rain":
                return R.drawable.ic_rainy;
            case "snow":
                return R.drawable.ic_snow;
            case "sleet":
                return R.drawable.ic_sleet;
            case "wind":
                return R.drawable.ic_windy;
            case "fog":
                return R.drawable.ic_fog;
            case "cloudy":
                return R.drawable.ic_clouds;
            case "partly-cloudy-day":
                return R.drawable.partly_cloudy_day;
            case "partly-cloudy-night":
                return R.drawable.partly_cloudy_night;
            case "hail":
                return R.drawable.ic_hail;
            case "thunderstorm":
                return R.drawable.ic_thounderstorm;
            case "tornado":
                return R.drawable.ic_tornado;
            default:
                return R.drawable.ic_launcher_background;
        }

    }
}