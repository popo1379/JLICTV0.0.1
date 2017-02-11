package com.palmintelligence.administrator.jlictv001.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.palmintelligence.administrator.jlictv001.R;
import com.palmintelligence.administrator.jlictv001.db.Traffic;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class TrafficAdapter extends ArrayAdapter<Traffic> {
    private int resourceId;
    public TrafficAdapter(Context context, int textViewsourceId, List<Traffic> object){
        super(context,textViewsourceId,object);
        resourceId=textViewsourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Traffic traffic=getItem(position);//获取当前Traffic实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView busImage=(ImageView)view.findViewById(R.id.bus_image);
        TextView busName=(TextView)view.findViewById(R.id.bus_name);
        busImage.setImageResource(traffic.getImageId());
        busName.setText(traffic.getName());
        return view;

    }

}
