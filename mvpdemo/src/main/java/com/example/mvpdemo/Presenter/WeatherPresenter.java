package com.example.mvpdemo.Presenter;

import android.text.TextUtils;

import com.example.mvpdemo.Model.IWeatherModel;
import com.example.mvpdemo.Model.WeatherModelImpl;
import com.example.mvpdemo.View.IWeatherView;

/**
 * Created by shangyulin on 2018/3/26.
 */

public class WeatherPresenter {

    IWeatherModel model;
    IWeatherView view;

    public WeatherPresenter(IWeatherView view) {
        this.view = view;
        this.model = new WeatherModelImpl();
    }

    public void requestNetworkData(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //打开等待对话框
                    showWaitingDialog();
                    //模拟网络耗时
                    Thread.sleep(4000);

                    String info;

                    info = getInfo();

                    if(TextUtils.isEmpty(info)){
                        info = "天气晴朗";
                    }

                    saveInfo(info);

                    //通知View层改变视图
                    updateWetherInfo(info);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //取消对话框
                    dismissWaitingDialog();
                }
            }
        }).start();
    }

    private String getInfo() {
        return model.getLocalData();
    }

    private void saveInfo(String info) {
        model.setData(info);
    }

    private void showWaitingDialog(){
        if (view != null) {
            view.showWaitingDialog();
        }
    }

    private void dismissWaitingDialog(){
        if (view != null) {
            view.dismissWaitingDialog();
        }
    }

    private void updateWetherInfo(String info){
        if (view != null) {
            view.onInfoUpdate(info);
        }
    }
}
