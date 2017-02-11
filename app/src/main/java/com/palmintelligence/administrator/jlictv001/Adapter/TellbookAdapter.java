package com.palmintelligence.administrator.jlictv001.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.palmintelligence.administrator.jlictv001.R;

import java.util.List;

public class TellbookAdapter extends RecyclerView.Adapter<TellbookAdapter.MyViewHolder>{
    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

        public TellbookAdapter(Context context, List<String> datas){
        this.mContext=context;
        this.mDatas=datas;
        inflater=LayoutInflater.from(mContext);
    }
    //得到所需Item数量
    @Override
    public int getItemCount() {

        return mDatas.size();
    }
//这个方法主要生成为每个Item inflater出一个View，但是该方法返回的是一个ViewHolder。
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.tellbook_item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }
    // 这个方法主要用于适配渲染数据到View中。
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv.setText( mDatas.get(position));
        //设置瀑布流高度
        holder.tv.setHeight(200 + (position % 3) * 100);
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tellbook_name);

        }
    }



}
