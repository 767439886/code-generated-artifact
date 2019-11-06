package com.jfeat.am.module.set.model;

public class AdvertisBrand {

    //  广告的标题和名字
    private String brandName ;
    private int id ;
    //  所属的格式，此广告是属于哪个后缀名的
    private String format ;
    //  表示所在的取域的名字
    private String type ;
    //  表示该是否已经转码了
    private String iftranscoding ;
    //  记录的类型id
    private String typeId ;
    //  第一类所属
    private String first ;
    //  第二类所属
    private String second ;

    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getSecond() {
        return second;
    }
    public void setSecond(String second) {
        this.second = second;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getIftranscoding() {
        return iftranscoding;
    }
    public void setIftranscoding(String iftranscoding) {
        this.iftranscoding = iftranscoding;
    }
    public String getAdvertisingName() {
        return brandName;
    }
    public void setAdvertisingName(String advertisingName) {
        this.brandName = advertisingName;
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
}
