package com.baidu.apistore.sdk;

import android.app.Application;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Vibrator;

import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.location.service.LocationService;
import com.baidu.mapapi.SDKInitializer;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;


/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class MyApplication extends Application {
    public LocationService locationService;
    public Vibrator mVibrator;
    @Override
    public void onCreate() {
        // TODO 您的其他初始化流程
        ApiStoreSDK.init(this, "7ab839a48a5f673749783092be8f77aa");
        initImageLoader(getApplicationContext());
        super.onCreate();
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
    }
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(context)
                .memoryCacheExtraOptions(100, 100) // max width, max height，即保存的每个缓存文件的最大长宽

                .threadPoolSize(5)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100) //缓存的文件数
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(context, 20* 1000, 60 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();//开始构建
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

}


