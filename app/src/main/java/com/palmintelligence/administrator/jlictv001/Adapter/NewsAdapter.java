package com.palmintelligence.administrator.jlictv001.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.palmintelligence.administrator.jlictv001.NewsActivity;
import com.palmintelligence.administrator.jlictv001.R;
import com.palmintelligence.administrator.jlictv001.db.News;
import com.palmintelligence.administrator.jlictv001.db.Traffic;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by Administrator on 2016/8/13 0013.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NormalItemHolder> {

    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options;

    private Context mContext;
    private List<News> mDataList;
 private LayoutInflater mLayoutInflater;
    private News news;
    public NewsAdapter(Context mContext1, List<News> mDataList1) {
     mContext = mContext1;
       mDataList = mDataList1;
        mLayoutInflater = LayoutInflater.from(mContext);


    }

    //这个方法主要生成为每个Item inflater出一个View，但是该方法返回的是一个ViewHolder。
    @Override
    public NormalItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


        View view = mLayoutInflater.inflate(R.layout.news_item,viewGroup, false);
        NormalItemHolder holder= new NormalItemHolder(view);
        return holder;


    }

    // 这个方法主要用于适配渲染数据到View中。
    @Override
    public void onBindViewHolder(NormalItemHolder viewHolder,int position) {
       news= mDataList.get(position);
        if (null == news)
            return;
else {
            viewHolder.newsTime.setText(news.getNews_time());
            viewHolder.newsTitle.setText(news.getTitle());
            // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.newspic_loading) // 设置图片下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.newspic_emptyuri) // 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.newspic_fail) // 设置图片加载或解码过程中发生错误显示的图片
                    .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                   // .displayer(new RoundedBitmapDisplayer(10)) // 设置成圆角图片
                    .build(); // 构建完成

            ImageLoader.getInstance().displayImage(news.getNews_pic(),viewHolder.newsIcon,options);
        }
    }

    //得到所需Item数量
    @Override
    public int getItemCount() {
     return  mDataList.size();
    }




    public class NormalItemHolder extends RecyclerView.ViewHolder {
        TextView newsTitle,newsTime;
        ImageView newsIcon;

        public NormalItemHolder(View itemView) {
            super(itemView);
            newsTime=(TextView)itemView.findViewById(R.id.news_title_time);
            newsTitle = (TextView) itemView.findViewById(R.id.news_swipe_item_title);
            newsIcon = (ImageView) itemView.findViewById(R.id.news_swipe_item_icon);
            itemView.findViewById(R.id.news_swipe_item_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}