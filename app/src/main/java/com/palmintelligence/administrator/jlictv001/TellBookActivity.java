package com.palmintelligence.administrator.jlictv001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;


import com.palmintelligence.administrator.jlictv001.Adapter.TellbookAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class TellBookActivity extends AppCompatActivity {
    private List<String>tellBooklist=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.tellbook_layout);
        //初始化数据
        initTellbook();
        //设置RecyclerView
        RecyclerView tellbook_RV=(RecyclerView)findViewById(R.id.tellbook_rv);
        //固定控件大小提高性能
        tellbook_RV.setHasFixedSize(true);
        //数据传入构造器
        TellbookAdapter adapter=new TellbookAdapter(TellBookActivity.this,tellBooklist);
        //组合配适器
        tellbook_RV.setAdapter(adapter);
        //设置布局管理器
        //列数为两列
        int spanCount = 3;
        //设置布局为瀑布流
       StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(
                spanCount,
                StaggeredGridLayoutManager.VERTICAL);
        tellbook_RV.setLayoutManager(mLayoutManager);
        //设置Toolbar
        Toolbar tellbook_toolbar=(Toolbar)findViewById(R.id.tellbook_toolbar);

        tellbook_toolbar.setTitle("化工学院各办公室电话查询(仅演示功能)");
        setSupportActionBar(tellbook_toolbar);
        tellbook_toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        tellbook_toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
            onBackPressed();
        }
        });
}

private void initTellbook(){
    String number1=new String("党委办公室、校长办公室：63083027");
    tellBooklist.add(number1);
    String number2=new String("招生电话：本(专)科生:0432-63083056");
   tellBooklist.add(number2);
    String number3=new String("研究生:0432-63081060");
    tellBooklist.add(number3);
    String number4=new String ("图书馆：63083149");
    tellBooklist.add(number4
    );

}
}