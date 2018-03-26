package com.example.mvpdemo.View;

/**
 * Created by shangyulin on 2018/3/26.
 */

public interface IWeatherView {

    void onInfoUpdate(String info);

    void showWaitingDialog();

    void dismissWaitingDialog();
}
