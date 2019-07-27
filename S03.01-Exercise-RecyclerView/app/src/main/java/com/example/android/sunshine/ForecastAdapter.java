package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{

    private String[] mWeatherData;

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView=view.findViewById(R.id.tv_weather_data);
        }

    }

    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItemView = R.layout.forecast_list_item;
        View view= LayoutInflater.from(context).inflate(layoutIdForListItemView,viewGroup,false);
        ForecastAdapterViewHolder viewHolder=new ForecastAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int i) {
        String weatherForThisDay=mWeatherData[i];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        if (null==mWeatherData) return 0;
        return mWeatherData.length;
    }

    public void setWeatherData(String[] weatherData){
        mWeatherData=weatherData;
        notifyDataSetChanged();
    }
}
