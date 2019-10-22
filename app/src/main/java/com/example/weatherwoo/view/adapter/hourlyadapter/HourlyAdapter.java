package com.example.weatherwoo.view.adapter.hourlyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.view.adapter.hourlyadapter.HourlyAdapter;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {

    private Context context;
    private List<Hourly> hourlyList;

    public HourlyAdapter(List<Hourly> hourlyList)
    {
        this.hourlyList=hourlyList;}

    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.hourly_item,
                parent,
                false);
        return new HourlyViewHolder(view);
        //return new HourlyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.HourlyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return hourlyList.size();}

    class HourlyViewHolder extends RecyclerView.ViewHolder {

        public HourlyViewHolder(@NonNull View wooView) {
            super((wooView));
        }
    }


}

