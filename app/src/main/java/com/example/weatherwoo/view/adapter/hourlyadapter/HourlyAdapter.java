package com.example.weatherwoo.view.adapter.hourlyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwoo.Commons.WeatherUtils;
import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.HourlyDatum;
import com.google.android.material.textview.MaterialTextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {

    private Context context;
    private List<HourlyDatum> hourlyDatumList;

    public HourlyAdapter(List<HourlyDatum> hourlyDatumList){

        this.hourlyDatumList = hourlyDatumList;
    }

    public HourlyAdapter(Hourly hourly) {
        this.hourlyDatumList = hourly.getData();
    }

    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View theView = LayoutInflater.from(context).inflate(
                R.layout.hourly_item,
                parent,
                false
        );
        return new HourlyViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyViewHolder holder, int position) {
        HourlyDatum data = hourlyDatumList.get(position);
        holder.setHourlyWeather(data);
        int icon = WeatherUtils.getWeatherIcon(data.getIcon());
        Glide.with(context).load(icon).into(holder.ivWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return hourlyDatumList.size();
    }

    class HourlyViewHolder extends RecyclerView.ViewHolder{
        private MaterialTextView tvTime, tvtemp;
        private ImageView ivWeatherIcon;

        HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvtemp = itemView.findViewById(R.id.tv_temp);
            ivWeatherIcon = itemView.findViewById(R.id.ivWeatherIcon);
        }



        void setHourlyWeather (HourlyDatum data) {
            String high = getRoundedTemp(data.getTemperature());
            // String low = getRoundedTemp(data.getTemperature());

                tvtemp.setText(high);
               // tvLow.setText(low);

            // This is to Display the Time into the Hourly fields -- NOT working Correctly
            long matTime = (data.getTime());

            SimpleDateFormat dateFormat = new SimpleDateFormat("ha", Locale.getDefault());

        //Toast.makeText(MainActivity.this, String.valueOf(matTime), Toast.LENGTH_SHORT).show();
            String formattedDate = (dateFormat.format(matTime * 1000));
        //Toast.makeText(MainActivity.this, String.valueOf(dateFormat), Toast.LENGTH_SHORT).show();
            tvTime.setText(formattedDate);

            }

            String getRoundedTemp(Double temp) {
            return String.valueOf(Math.round(temp));
            }
    }
}
