package com.example.weatherwoo.view.adapter.dailyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.DailyDatum;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {

    private Context context;
    private List<DailyDatum> dailyDatumList;

    public DailyAdapter(List<DailyDatum> dailyDatumList){

        this.dailyDatumList = dailyDatumList;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.daily_item,
                parent,
                false
        );
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        DailyDatum dailyDatum = dailyDatumList.get(position);
    }

    @Override
    public int getItemCount() {
        return dailyDatumList.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder{
        ImageView dailyDatumList;
      TextView forcast_Low, forcast_High, forcast_Time;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            dailyDatumList = itemView.findViewById(R.id.ivWeatherIcon);
            forcast_High = itemView.findViewById(R.id.tvHigh);

        }
    }

}