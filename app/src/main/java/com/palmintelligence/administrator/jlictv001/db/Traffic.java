package com.palmintelligence.administrator.jlictv001.db;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class Traffic {
    private String name;
    private int imageId;
    public Traffic(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

}
