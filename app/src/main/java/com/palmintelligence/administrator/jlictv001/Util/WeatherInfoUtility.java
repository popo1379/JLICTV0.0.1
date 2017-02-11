package com.palmintelligence.administrator.jlictv001.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
public class WeatherInfoUtility {

    /**
     * 解析服务器返回的JSON数据，并将解析出的数据储存到本地
     */
    public static void handleWeatherResponse(Context context, String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            //将json对象转换成bean对象。

            JSONArray weatherInfo0=jsonObject.getJSONArray("HeWeather data service 3.0");
            JSONObject weatherInfo1=(JSONObject)weatherInfo0.get(0);
            JSONObject weatherInfo2= weatherInfo1.getJSONObject("aqi");
            JSONObject weatherInfo3=weatherInfo2.getJSONObject("city");
           String pm25=weatherInfo3.getString("pm25");
             String  qlty=weatherInfo3.getString("qlty");
            JSONObject weatherInfo_now=weatherInfo1.getJSONObject("now");
            JSONObject weatherInfo_cond=weatherInfo_now.getJSONObject("cond");
          String  txt=weatherInfo_cond.getString("txt");
          String  tmp=weatherInfo_now.getString("tmp");
            JSONObject weatherInfo_wind=weatherInfo_now.getJSONObject("wind");
          String  sc=weatherInfo_wind.getString("sc");
            JSONObject weatherInfo_suggestion=weatherInfo1.getJSONObject("suggestion");
            JSONObject weatherInfo_comf=weatherInfo_suggestion.getJSONObject("comf");
           String comf_txt=weatherInfo_comf.getString("txt");
            JSONArray weatherInfo_hourly=weatherInfo1.getJSONArray("hourly_forecast");
            JSONObject weatherInfo_hourly_0=(JSONObject)weatherInfo_hourly.get(0);
          String  data=weatherInfo_hourly_0.getString("data");
          String  pop=weatherInfo_hourly_0.getString("pop");

            saveWeatherInfo(context,pm25,qlty,txt,tmp,sc,comf_txt,data,pop);
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
    public static void saveWeatherInfo(Context context,String pm25,String qlty,String txt,String tmp,String sc,String comf_txt,String data,String pop){
        SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("pm25",pm25);
        editor.putString("qlty",qlty);
        editor.putString("tmp",tmp);
        editor.putString("data", data);
        editor.putString("comf_txt",comf_txt);
        editor.putString("pop",pop);
        editor.putString("txt",txt);
        editor.putString("sc",sc);
        //提交当前数据
        editor.commit();
    }





}
