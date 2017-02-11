package com.palmintelligence.administrator.jlictv001;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.palmintelligence.administrator.jlictv001.Adapter.TrafficAdapter;
import com.palmintelligence.administrator.jlictv001.db.Traffic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class TrafficActivity extends AppCompatActivity {
    private List<Traffic> busList = new ArrayList<Traffic>();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.traffic_layout);
        initTraffic();//初始化交通数据
        TrafficAdapter adapter = new TrafficAdapter(TrafficActivity.this, R.layout.traffic_item, busList);
        ListView listView = (ListView) findViewById(R.id.list_View);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (busList.get(position)==busList.get(0)) {

                  //  getIntent().setData(Uri.parse("http://wapbaike.baidu.com/link?url=3cTH67LM4yUdMl9d2gstqqti1j6ufeRNHWHjivjDoDywIrHic8301AkPmsJHccPcAeluFFtu72SemT5kxAkZMks3jlxh2BQvuetdoxudUj2qNps_f4YTTXSmkpnJJtLJ"));

                    Uri uri2=Uri.parse("http://wapbaike.baidu.com/link?url=3cTH67LM4yUdMl9d2gstqqti1j6ufeRNHWHjivjDoDywIrHic8301AkPmsJHccPcAeluFFtu72SemT5kxAkZMks3jlxh2BQvuetdoxudUj2qNps_f4YTTXSmkpnJJtLJ");
                    Intent it2 = new Intent(Intent.ACTION_VIEW,uri2);
                    startActivity(it2);
                }
                if(busList.get(position)==busList.get(1)){
                    Uri uri2=Uri.parse("http://wapbaike.baidu.com/link?url=Xbq_EaP_2D4Tl6hqSu_WSXfh-LeZOh0bMQlmwlcL8BOOWQ-PoU_F2AEHgs8TcfLnLwoB8yEfRcWXf3_TC06vqRfO9faRE1OzUBfurXLLbAL2HePxsvxanv2aoxTmQl57");
                    Intent it2 = new Intent(Intent.ACTION_VIEW,uri2);
                    startActivity(it2);
                }
                if (busList.get(position)==busList.get(2)){
                  //  Intent intent = new Intent(Intent.ACTION_VIEW);
                   // getIntent().setData(Uri.parse("http://wapbaike.baidu.com/link?url=Xbq_EaP_2D4Tl6hqSu_WSXfh-LeZOh0bMQlmwlcL8BOOWQ-PoU_F2AEHgs8TcfLnLwoB8yEfRcWXf3_TC06vqRfO9faRE1OzUBfurXLLbAL2HePxsvxanv2aoxTmQl57"));
                  //  startActivity(intent);
                    Uri uri2=Uri.parse("http://wapbaike.baidu.com/link?url=Xbq_EaP_2D4Tl6hqSu_WSXfh-LeZOh0bMQlmwlcL8BOOWQ-PoU_F2AEHgs8TcfLnLwoB8yEfRcWXf3_TC06vqRfO9faRE1OzUBfurXLLbAL2HePxsvxanv2aoxTmQl57");
                    Intent it2 = new Intent(Intent.ACTION_VIEW,uri2);
                    startActivity(it2);
                }
            }
        });












        //Toolbar设置
       android.support.v7.widget.Toolbar traffic_toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.traffic_toolbar);
        traffic_toolbar.setTitle("校园周边公交查询（仅作功能演示）");
      //  traffic_toolbar.setNavigationIcon(android.R.id.home);
        setSupportActionBar(traffic_toolbar);
        traffic_toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        traffic_toolbar.setNavigationOnClickListener(new View.OnClickListener() { @Override public void onClick(View v)
        {   onBackPressed();
        } });
    }

    private void initTraffic() {
        Traffic bus1 = new Traffic("       30路车", R.drawable.bus1);
        busList.add(bus1);
        Traffic bus2=new Traffic("       15路车",R.drawable.bus1);
        busList.add(bus2);
        Traffic bus3=new Traffic("       6路车",R.drawable.bus2);
        busList.add(bus3);
    }


}