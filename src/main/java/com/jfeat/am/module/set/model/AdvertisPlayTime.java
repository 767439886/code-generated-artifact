package com.jfeat.am.module.set.model;


import java.util.Date;

public class AdvertisPlayTime {

    private Integer id ;
    private String playTime ;
    private String pushAdvertisName ;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPlayTime() {
        return playTime;
    }
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
    public String getPushAdvertisName() {
        return pushAdvertisName;
    }
    public void setPushAdvertisName(String pushAdvertisName) {
        this.pushAdvertisName = pushAdvertisName;
    }
}
