package com.jfeat.am.module.set.model;

public class Area {

    //  城市id
    private int id ;
    //  城市的名字
    private String cityName ;
    //  城市的父id
    private int parentId ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
