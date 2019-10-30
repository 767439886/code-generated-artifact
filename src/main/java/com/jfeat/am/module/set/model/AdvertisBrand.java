package com.jfeat.am.module.set.model;

public class AdvertisBrand {

    //  广告的标题和名字
    private String advertisingName ;
    private int id ;
    //  所属的格式，此广告是属于哪个后缀名的
    private String format ;
    //  表示所在的取域，使用于该模板是属于哪个取域的
    private String area ;
    //  表示该是否已经转码了
    private String iftranscoding ;
    //  记录的区域id
    private String categoryId ;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getIftranscoding() {
        return iftranscoding;
    }

    public void setIftranscoding(String iftranscoding) {
        this.iftranscoding = iftranscoding;
    }

    public String getAdvertisingName() {
        return advertisingName;
    }

    public void setAdvertisingName(String advertisingName) {
        this.advertisingName = advertisingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
