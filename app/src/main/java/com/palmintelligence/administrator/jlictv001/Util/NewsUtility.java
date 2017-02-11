package com.palmintelligence.administrator.jlictv001.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class NewsUtility {
    public static void handleNewsResponse(Context context, String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray_newslist = jsonObject.getJSONArray("newslist");
            JSONObject jsonNews_0 = (JSONObject) jsonArray_newslist.get(0);
            String news_0_ctime = jsonNews_0.getString("ctime");
            String news_0_title = jsonNews_0.getString("title");
            String news_0_picUrl = jsonNews_0.getString("picUrl");
            String news_0_Url = jsonNews_0.getString("url");

            JSONObject jsonNews_1 = (JSONObject) jsonArray_newslist.get(1);
            String news_1_ctime = jsonNews_1.getString("ctime");
            String news_1_title = jsonNews_1.getString("title");
            String news_1_picUrl = jsonNews_1.getString("picUrl");
            String news_1_Url = jsonNews_1.getString("url");

            JSONObject jsonNews_2 = (JSONObject) jsonArray_newslist.get(2);
            String news_2_ctime = jsonNews_2.getString("ctime");
            String news_2_title = jsonNews_2.getString("title");
            String news_2_picUrl = jsonNews_2.getString("picUrl");
            String news_2_Url = jsonNews_2.getString("url");

            JSONObject jsonNews_3 = (JSONObject) jsonArray_newslist.get(3);
            String news_3_ctime = jsonNews_3.getString("ctime");
            String news_3_title = jsonNews_3.getString("title");
            String news_3_picUrl = jsonNews_3.getString("picUrl");
            String news_3_Url = jsonNews_3.getString("url");

            JSONObject jsonNews_4 = (JSONObject) jsonArray_newslist.get(4);
            String news_4_ctime = jsonNews_4.getString("ctime");
            String news_4_title = jsonNews_4.getString("title");
            String news_4_picUrl = jsonNews_4.getString("picUrl");
            String news_4_Url = jsonNews_4.getString("url");

            JSONObject jsonNews_5 = (JSONObject) jsonArray_newslist.get(5);
            String news_5_ctime = jsonNews_5.getString("ctime");
            String news_5_title = jsonNews_5.getString("title");
            String news_5_picUrl = jsonNews_5.getString("picUrl");
            String news_5_Url = jsonNews_5.getString("url");


            JSONObject jsonNews_6 = (JSONObject) jsonArray_newslist.get(6);
            String news_6_ctime = jsonNews_6.getString("ctime");
            String news_6_title = jsonNews_6.getString("title");
            String news_6_picUrl = jsonNews_6.getString("picUrl");
            String news_6_Url = jsonNews_6.getString("url");

            JSONObject jsonNews_7 = (JSONObject) jsonArray_newslist.get(7);
            String news_7_ctime = jsonNews_7.getString("ctime");
            String news_7_title = jsonNews_7.getString("title");
            String news_7_picUrl = jsonNews_7.getString("picUrl");
            String news_7_Url = jsonNews_7.getString("url");

            saveNewsinfo(context, news_0_ctime, news_0_title, news_0_picUrl, news_0_Url,
                    news_1_ctime,news_1_title,news_1_picUrl,news_1_Url,
                    news_2_ctime,news_2_title,news_2_picUrl,news_2_Url,
                    news_3_ctime,news_3_title,news_3_picUrl,news_3_Url,
                    news_4_ctime,news_4_title,news_4_picUrl,news_4_Url,
                    news_5_ctime,news_5_title,news_5_picUrl,news_5_Url,
                    news_6_ctime,news_6_title,news_6_picUrl,news_6_Url,
                    news_7_ctime,news_7_title,news_7_picUrl,news_7_Url);
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

    public static void saveNewsinfo(Context context, String time_0, String title_0, String picUrl_0, String url_0,
                                    String time_1, String title_1, String picUrl_1, String url_1,
                                    String time_2, String title_2, String picUrl_2, String url_2,
                                    String time_3, String title_3, String picUrl_3, String url_3,
                                    String time_4, String title_4, String picUrl_4, String url_4,
                                    String time_5, String title_5, String picUrl_5, String url_5,
                                    String time_6, String title_6, String picUrl_6, String url_6,
                                    String time_7, String title_7, String picUrl_7, String url_7) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
editor.putString("time_0",time_0);
        editor.putString("title_0",title_0);
        editor.putString("picUrl_0",picUrl_0);
        editor.putString("url_0",url_0);

        editor.putString("time_1",time_1);
        editor.putString("title_1",title_1);
        editor.putString("picUrl_1",picUrl_1);
        editor.putString("url_1",url_1);

        editor.putString("time_2",time_2);
        editor.putString("title_2",title_2);
        editor.putString("picUrl_2",picUrl_2);
        editor.putString("url_2",url_2);

        editor.putString("time_3",time_3);
        editor.putString("title_3",title_3);
        editor.putString("picUrl_3",picUrl_3);
        editor.putString("url_3",url_3);

        editor.putString("time_4",time_4);
        editor.putString("title_4",title_4);
        editor.putString("picUrl_4",picUrl_4);
        editor.putString("url_4",url_4);

        editor.putString("time_5",time_5);
        editor.putString("title_5",title_5);
        editor.putString("picUrl_5",picUrl_5);
        editor.putString("url_5",url_5);

        editor.putString("time_6",time_6);
        editor.putString("title_6",title_6);
        editor.putString("picUrl_6",picUrl_6);
        editor.putString("url_6",url_6);

        editor.putString("time_7",time_7);
        editor.putString("title_7",title_7);
        editor.putString("picUrl_7",picUrl_7);
        editor.putString("url_7",url_7);



        editor.commit();
    }
}