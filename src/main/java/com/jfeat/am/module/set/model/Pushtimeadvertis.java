package com.jfeat.am.module.set.model;

/**
 * Pushtimeadvertis 实体类
 * @date 2019-11-01 16:52:50
 * @version 1.0
 */
public class Pushtimeadvertis implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pushAdvertisName;
	private String startTime;
	private String endTime;
	private String playTime;
	private String uidName ;
	private String uid ;

	/** setter and getter method */
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
    public String getPushAdvertisName() {
        return pushAdvertisName;
    }
    public void setPushAdvertisName(String pushAdvertisName) {
        this.pushAdvertisName = pushAdvertisName;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getPlayTime() {
        return playTime;
    }
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
    public String getUidName() {
        return uidName;
    }
    public void setUidName(String uidName) {
        this.uidName = uidName;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
}