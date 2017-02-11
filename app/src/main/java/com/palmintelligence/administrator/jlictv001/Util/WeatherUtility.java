package com.palmintelligence.administrator.jlictv001.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Administrator on 2016/7/30 0030.
 */
public class WeatherUtility{
    /**
     * 解析服务器返回的JSON数据，并将解析出的数据储存到本地
     */
    public static void handleWeatherResponse(Context context,String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            //将json对象转换成bean对象。
            JSONArray weatherInfo=jsonObject.getJSONArray("HeWeather data service 3.0");
            JSONObject weatherInfo1=(JSONObject)weatherInfo.get(0);
            JSONArray weatherInfo2=weatherInfo1.getJSONArray("hourly_forecast");
            JSONObject weatherInfo3=(JSONObject)weatherInfo2.get(0);
            String text=weatherInfo3.getString("pop");
            String temperature=weatherInfo3.getString("tmp");
            String time=weatherInfo3.getString("date");
            //存入储存文件中。
            saveWeatherInfo(context,text,temperature,time);
        }catch (JSONException e){
            e.printStackTrace();

        }
    }
public static void saveWeatherInfo(Context context,String text,String temperature,String time){
    SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
    editor.putString("text",text);
    editor.putString("temperature",temperature);
    editor.putString("time",time);
    //提交当前数据
    editor.commit();
}
}

