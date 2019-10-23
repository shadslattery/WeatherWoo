package com.example.weatherwoo.view.adapter.hourlyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.HourlyDatum;

import java.util.List;


public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {

    private Context context;
    private List<HourlyDatum> hourlyDatumList;

    public HourlyAdapter(List<HourlyDatum> hourlyDatumList){

        this.hourlyDatumList = hourlyDatumList;
    }

    @NonNull
    @Override
    public HourlyAdapter.HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.hourly_item,
                parent,
                false
        );
        return new HourlyAdapter.HourlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.HourlyViewHolder holder, int position) {
        HourlyDatum hourlyDatum = hourlyDatumList.get(position);
    }

    @Override
    public int getItemCount() {
        return hourlyDatumList.size();
    }

    class HourlyViewHolder extends RecyclerView.ViewHolder{
        ImageView hourlyDatumList;
        TextView forcast_Low, forcast_High, forcast_Time;

        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            hourlyDatumList = itemView.findViewById(R.id.ivWeatherIcon);
            forcast_High = itemView.findViewById(R.id.tvHigh);

        }
    }

}
