package com.palmintelligence.administrator.jlictv001;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Application;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.baidu.location.service.LocationService;
import com.palmintelligence.administrator.jlictv001.Util.WeatherUtility;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.prefs.PreferenceChangeEvent;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewPager;
    private ArrayList<View> listpager;
    private Button traffic_button, tellbook_button,news_button,location_button,subject_button,score_button;
    private TextView weather_state, temperature,time;
    private CardView cardView;
    private String weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        news_button=(Button)findViewById(R.id.news_button);
        news_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });
        cardView = (CardView) findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);

                startActivity(intent);
            }
        });
        location_button=(Button)findViewById(R.id.location_button);
        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });
        subject_button=(Button)findViewById(R.id.subject_button);
        subject_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        score_button=(Button)findViewById(R.id.score_button);
        score_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        // new Thread() {
        //   @Override
        //  public void run() {
        //创建url对象
        // String httpUrl = "https://api.heweather.com/x3/citylist?search=CN101060201&key=7e9167d04c884cb3b7ecedd3808d7467";
        // URL url = new URL(httpUrl)
//                    InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), "utf-8");
        //      int i;

        //      // read
        //     while ((i = isr.read()) != -1) {
        //        String x=(String)i;
        //        WeatherUtility.handleWeatherResponse(MainActivity.this,x);

        //     isr.close();
        //     showWeather();


        //   }


        //     };

        //    showWeather();

        initUI();
        //交通按钮事件设置：
        traffic_button = (Button) findViewById(R.id.traffic_button);
        traffic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrafficActivity.class);
                startActivity(intent);
            }
        });

        tellbook_button = (Button) findViewById(R.id.tellbook_button);
        tellbook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TellBookActivity.class);
                startActivity(intent);
            }
        });
        //Toolbar设置：
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("吉林化工学院");
        setSupportActionBar(toolbar);

        //右下角圆标控件设置：
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        //滑动界面设置
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //设置Toolbar侧滑按钮
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
      //  EditText editText=(EditText)findViewById(R.id.nav_edit);
     //   editText.setText("未登录");
        //VIEWPAGER控件设置：
        viewPager = (ViewPager) findViewById(R.id.main_viewpager_id);
        LayoutInflater inflater = getLayoutInflater().from(this);
        View view1 = inflater.inflate(R.layout.item1, null);
        View view2 = inflater.inflate(R.layout.item2, null);
        listpager = new ArrayList<View>();
        listpager.add(view1);
        listpager.add(view2);

        PagerAdapter mPagerAdapter = new PagerAdapter() {


            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return listpager.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(listpager.get(position));

            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(listpager.get(position));
                return listpager.get(position);
            }

        };
        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tieba) {
           Uri uri1=Uri.parse("http://tieba.baidu.com/f?kw=%BC%AA%C1%D6%BB%AF%B9%A4%D1%A7%D4%BA");
            Intent it1=new Intent(Intent.ACTION_VIEW,uri1);
            startActivity(it1);
        } else if (id == R.id.nav_huayuanren) {
            Uri uri2=Uri.parse("http://m.huayuan.ren/ShopSelect.aspx");
            Intent it2 = new Intent(Intent.ACTION_VIEW,uri2);
            startActivity(it2);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            //分享功能
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my Share text.");
            shareIntent.setType("text/plain");

            //设置分享列表的标题，并且每次都显示分享列表
            startActivity(Intent.createChooser(shareIntent, "分享到"));
        } else if (id == R.id.nav_send) {
            Intent intent=new Intent(MainActivity.this,LocationActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initUI() {
        weather_state = (TextView) findViewById(R.id.weather_state);
        temperature = (TextView) findViewById(R.id.temp);
        time=(TextView) findViewById(R.id.weather_time);
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
                        WeatherUtility.handleWeatherResponse(MainActivity.this, responseString);

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
        temperature.setText(prefs.getString("temperature", "")+"℃");
        weather_state.setText("降雨概率："+prefs.getString("text", "")+"%");
        time.setText(prefs.getString("time",""));
    }

}