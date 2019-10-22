package com.example.weatherwoo.view.adapter.dailyadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Daily;

import java.util.List;
import java.lang.String;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {

    private Context context;
    private List<Daily> dailyList;

public DailyAdapter(List<Daily> dailyList)
    {
        this.dailyList=dailyList;}

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.daily_item,
                parent,
                false);
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return dailyList.size();}

    class DailyViewHolder extends RecyclerView.ViewHolder {

        public DailyViewHolder(@NonNull View wooView) {
            super((wooView));
        }
    }
}