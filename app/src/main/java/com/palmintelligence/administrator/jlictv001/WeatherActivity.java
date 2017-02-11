package com.palmintelligence.administrator.jlictv001;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.TextView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.palmintelligence.administrator.jlictv001.Util.WeatherInfoUtility;
import com.palmintelligence.administrator.jlictv001.Util.WeatherUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/7/31 0031.
 */
public class WeatherActivity extends AppCompatActivity {
 private String weatherInfo;
    private TextView weather_tmp,weather_pm25,weather_qlty,weather_txt,weatherdata,weatherpop,weather_wind,weather_comf_txt,ceshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_layout);

        initUI();
    }
    private void initUI(){
        weather_tmp=(TextView)findViewById(R.id.weather_temp);
        weather_pm25=(TextView)findViewById(R.id.weather_pm25);
        weather_qlty=(TextView) findViewById(R.id.weather_qlty);
        weather_txt=(TextView)findViewById(R.id.weather_txt);
        weatherdata=(TextView)findViewById(R.id.weather_time);
        weatherpop=(TextView) findViewById(R.id.weather_pop);
        weather_wind=(TextView)findViewById(R.id.weather_wind);
        weather_comf_txt=(TextView) findViewById(R.id.comf_txt);
        ceshi=(TextView)findViewById(R.id.ceshi);
        apiTest();
    }


    private void apiTest() {

        Parameters para = new Parameters();

        para.put("city", "jilin");
        ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        WeatherInfoUtility.handleWeatherResponse(WeatherActivity.this,responseString);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                    }

                });
        showWeather();

    }
    private void showWeather() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String pm25=prefs.getString("pm25","");
        weather_tmp.setText(prefs.getString("tmp","")+"℃");
        weather_pm25.setText(pm25);
        weather_qlty.setText(prefs.getString("qlty",""));
        weather_txt.setText(prefs.getString("txt",""));
        weatherpop.setText(prefs.getString("pop",""));
        weatherdata.setText(prefs.getString("data",""));
        weather_wind.setText(prefs.getString("sc",""));
        weather_comf_txt.setText(prefs.getString("comf_txt",""));
        ceshi.setText("111");
    }

    }










