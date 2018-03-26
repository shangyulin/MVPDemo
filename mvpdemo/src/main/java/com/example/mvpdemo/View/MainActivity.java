package com.example.mvpdemo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpdemo.Presenter.WeatherPresenter;
import com.example.mvpdemo.R;

public class MainActivity extends AppCompatActivity  implements IWeatherView, View.OnClickListener {

    private WeatherPresenter presenter;
    private TextView content;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new WeatherPresenter(this);
        content = findViewById(getResources().getIdentifier("weather_info", "id", getPackageName()));
        pb = findViewById(getResources().getIdentifier("pb", "id", getPackageName()));
        findViewById(getResources().getIdentifier("query", "id", getPackageName())).setOnClickListener(this);
    }

    @Override
    public void onInfoUpdate(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                content.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void dismissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        presenter.requestNetworkData();
    }
}
