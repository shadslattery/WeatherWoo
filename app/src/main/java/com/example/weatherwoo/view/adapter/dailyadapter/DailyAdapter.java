package com.example.weatherwoo.view.adapter.dailyadapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwoo.Commons.WeatherUtils;
import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Daily;
import com.example.weatherwoo.model.DailyDatum;
import com.google.android.material.textview.MaterialTextView;

import java.util.Calendar;
import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {

    private Context context;
    private List<DailyDatum> dailyDatumList;

    // Can use this constructor or one below
    public DailyAdapter(List<DailyDatum> dailyDatumList) {
        this.dailyDatumList = dailyDatumList;
    }

    // Can use this Constructor or one above
    public DailyAdapter(Daily daily) {
        this.dailyDatumList = daily.getData();
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View theView = LayoutInflater.from(context).inflate(
                R.layout.daily_item,
                parent,
                false
        );
        return new DailyViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        DailyDatum data = dailyDatumList.get(position);
        holder.setDailyWeather(data);
       int icon = WeatherUtils.getWeatherIcon(data.getIcon()); // Getter: Gets the Information from data does the process
                // process for getWeatherIcon, which is located in WeatherUtils. Saves getIcon into the icon.
        Glide.with(context).load(icon).into(holder.ivWeatherIcon); // Setter: sits the icon into the ivWeatherIcon
                // Glide has more memory space,
    }

    @Override
    public int getItemCount() {
        return dailyDatumList.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView tvTime, tvHigh, tvLow;
        private ImageView ivWeatherIcon;

        DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvHigh = itemView.findViewById(R.id.tvHigh);
            tvLow = itemView.findViewById(R.id.tvLow);
            ivWeatherIcon = itemView.findViewById(R.id.ivWeatherIcon);
        }


        void setDailyWeather(DailyDatum data) {
            String day = getDayOfWeek(data.getTime());
            String high = getRoundedTemp(data.getTemperatureHigh());
            String low = getRoundedTemp(data.getTemperatureLow());

            tvHigh.setText(high);
            tvLow.setText(low);
            tvTime.setText(day);

        }

            /**
             * this method will convert a long into Current Day in the week
             * @param time takes a long type
             * @return string day of the week
             */

            String getDayOfWeek ( long time){
                // Instance of Calendar
                Calendar calendar = Calendar.getInstance();

                // Set the time parameter to calender
                calendar.setTimeInMillis(time * 1000);

                return DateFormat.format("EEEE", calendar).toString();
            }


        }
            //Using format we extract the current day of the week


        String getRoundedTemp(Double temp) {
            return String.valueOf(Math.round(temp));
        }
    }


