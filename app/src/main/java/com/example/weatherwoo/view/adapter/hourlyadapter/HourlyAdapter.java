package com.example.weatherwoo.view.adapter.hourlyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.HourlyDatum;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;


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
        }

            String getRoundedTemp(Double temp) {
            return String.valueOf(Math.round(temp));
            }
    }
}
