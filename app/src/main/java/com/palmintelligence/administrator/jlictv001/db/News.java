package com.palmintelligence.administrator.jlictv001.db;

import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/13 0013.
 */
public class News {
    private String news_title;
    private String news_pic;
    private String news_time;
    public News(String time,String title,String pic){
    news_time=time;
     news_title=title;
        news_pic=pic;
    }
    public String getNews_time(){return news_time;}

    public String getTitle(){return news_title;}

    public String getNews_pic(){return news_pic;}

}
