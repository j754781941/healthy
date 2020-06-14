package com.wdk.healthy.pojo;

import java.io.Serializable;

public class ImgInfo implements Serializable {
    private static final long serialVersionUID = -6633526912563098373L;
    String imgDatas;
    String id;
    String picNum;

    public ImgInfo() {
    }

    public ImgInfo(String imgDatas, String id, String picNum) {
        this.imgDatas = imgDatas;
        this.id = id;
        this.picNum = picNum;
    }

    public String getImgDatas() {
        return imgDatas;
    }

    public void setImgDatas(String imgDatas) {
        this.imgDatas = imgDatas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicNum() {
        return picNum;
    }

    public void setPicNum(String picNum) {
        this.picNum = picNum;
    }
}
