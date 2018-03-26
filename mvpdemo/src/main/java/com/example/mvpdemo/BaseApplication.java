package com.example.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by shangyulin on 2018/3/26.
 */

public class BaseApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
