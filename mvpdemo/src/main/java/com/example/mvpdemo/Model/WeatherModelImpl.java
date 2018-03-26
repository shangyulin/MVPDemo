package com.example.mvpdemo.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvpdemo.BaseApplication;

/**
 * Created by shangyulin on 2018/3/26.
 */

public class WeatherModelImpl implements IWeatherModel {

    private Context context;
    private SharedPreferences sp;

    public WeatherModelImpl() {
        context = BaseApplication.getContext();
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    @Override
    public String getLocalData() {
        String weather_info = sp.getString("weather_info", "");
        return weather_info;
    }

    @Override
    public void setData(String data) {
        sp.edit().putString("weather_info", data).commit();
    }
}
