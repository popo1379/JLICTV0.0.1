package com.palmintelligence.administrator.jlictv001;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.palmintelligence.administrator.jlictv001.Adapter.NewsAdapter;
import com.palmintelligence.administrator.jlictv001.Util.NewsUtility;
import com.palmintelligence.administrator.jlictv001.Util.WeatherUtility;
import com.palmintelligence.administrator.jlictv001.db.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12 0012.
 */
public class NewsActivity extends AppCompatActivity {
   private RecyclerView mRecyclerView;
    private List<News> mdatas=new ArrayList<News>();
private String time_0,title_0,picUrl_0,url_0,time_1,title_1,picUrl_1,url_1,time_2,title_2,picUrl_2,url_2,time_3,title_3,picUrl_3,url_3,time_4,title_4,picUrl_4,url_4,time_5,title_5,picUrl_5,url_5,time_6,title_6,picUrl_6,url_6,time_7,title_7,picUrl_7,url_7;
 private SwipeRefreshLayout swipeRefreshLayout;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);
        initUI();

        News new0=new News(time_0,title_0,picUrl_0);
        News new1=new News(time_1,title_1,picUrl_1);
        News new2=new News(time_2,title_2,picUrl_2);
        News new3=new News(time_3,title_3,picUrl_3);
        News new4=new News(time_4,title_4,picUrl_5);
        News new5=new News(time_5,title_5,picUrl_5);
        News new6=new News(time_6,title_6,picUrl_6);
        News new7=new News(time_7,title_7,picUrl_7);

        mdatas.add(new0);
        mdatas.add(new1);
        mdatas.add(new2);
        mdatas.add(new3);
        mdatas.add(new4);
        mdatas.add(new5);
        mdatas.add(new6);
        mdatas.add(new7);


        NewsAdapter mAdapter=new NewsAdapter(NewsActivity.this, mdatas);
        mRecyclerView.setAdapter(mAdapter);


        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipRefresh);
        //改变加载显示的颜色
        swipeRefreshLayout.setColorSchemeColors(R.color.swipe_color_1,R.color.swipe_color_2);

        //设置初始时的大小
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);

        //设置向下拉多少出现刷新
        swipeRefreshLayout.setDistanceToTriggerSync(100);
        //设置刷新出现的位置
        swipeRefreshLayout.setProgressViewEndTarget(false, 200);

        //设置监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mdatas.clear();

                News new0 = new News(time_0, title_0, picUrl_0);
                News new1 = new News(time_1, title_1, picUrl_1);
                News new2 = new News(time_2, title_2, picUrl_2);
                News new3 = new News(time_3, title_3, picUrl_3);
                News new4 = new News(time_4, title_4, picUrl_5);
                News new5 = new News(time_5, title_5, picUrl_5);
                News new6 = new News(time_6, title_6, picUrl_6);
                News new7 = new News(time_7, title_7, picUrl_7);

                mdatas.add(new0);
                mdatas.add(new1);
                mdatas.add(new2);
                mdatas.add(new3);
                mdatas.add(new4);
                mdatas.add(new5);
                mdatas.add(new6);
                mdatas.add(new7);


                swipeRefreshLayout.setRefreshing(false);

            }
        });

        //Toolbar设置
        android.support.v7.widget.Toolbar traffic_toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.news_toolbar);
        traffic_toolbar.setTitle("校园新闻(仅演示功能)");
        //  traffic_toolbar.setNavigationIcon(android.R.id.home);
        setSupportActionBar(traffic_toolbar);
        traffic_toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        traffic_toolbar.setNavigationOnClickListener(new View.OnClickListener() { @Override public void onClick(View v)
        {   onBackPressed();
        } });







        }


        private void initUI(){
    mRecyclerView=(RecyclerView)findViewById(R.id.news_RV_list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    apiTest();

}



    private void apiTest() {

        Parameters para = new Parameters();
        para.put("num", "10");

        ApiStoreSDK.execute("http://apis.baidu.com/txapi/social/social",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        NewsUtility.handleNewsResponse(NewsActivity.this,responseString);

                    }
                });
        showNews();
    }

private void showNews(){
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    time_0=prefs.getString("time_0","");
    title_0=prefs.getString("title_0","");
    picUrl_0=prefs.getString("picUrl_0","");
    url_0=prefs.getString("url_0","");

    time_1=prefs.getString("time_1","");
    title_1=prefs.getString("title_1","");
    picUrl_1=prefs.getString("picUrl_1","");
    url_1=prefs.getString("url_1","");

    time_2=prefs.getString("time_2","");
    title_2=prefs.getString("title_2","");
    picUrl_2=prefs.getString("picUrl_2","");
    url_2=prefs.getString("url_2","");

    time_3=prefs.getString("time_3","");
    title_3=prefs.getString("title_3","");
    picUrl_3=prefs.getString("picUrl_3","");
    url_3=prefs.getString("url_3","");

    time_4=prefs.getString("time_4","");
    title_4=prefs.getString("title_4","");
    picUrl_4=prefs.getString("picUrl_4","");
    url_4=prefs.getString("url_4","");

    time_5=prefs.getString("time_5","");
    title_5=prefs.getString("title_5","");
    picUrl_5=prefs.getString("picUrl_5","");
    url_5=prefs.getString("url_5","");

    time_6=prefs.getString("time_6","");
    title_6=prefs.getString("title_6","");
    picUrl_6=prefs.getString("picUrl_6","");
    url_6=prefs.getString("url_6","");

    time_7=prefs.getString("time_7","");
    title_7=prefs.getString("title_7","");
    picUrl_7=prefs.getString("picUrl_7","");
    url_7=prefs.getString("url_7","");
}

}

