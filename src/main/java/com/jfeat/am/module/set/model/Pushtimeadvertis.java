package com.jfeat.am.module.set.model;

/**
 * Pushtimeadvertis 实体类
 * @date 2019-11-01 16:52:50
 * @version 1.0
 */
public class Pushtimeadvertis implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pushadvertisname;
	private String starttime;
	private String endtime;
	private String playtime;
	private Integer uid;

	/** setter and getter method */
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setPushadvertisname(String pushadvertisname){
		this.pushadvertisname = pushadvertisname;
	}
	public String getPushadvertisname(){
		return this.pushadvertisname;
	}
	public void setStarttime(String starttime){
		this.starttime = starttime;
	}
	public String getStarttime(){
		return this.starttime;
	}
	public void setEndtime(String endtime){
		this.endtime = endtime;
	}
	public String getEndtime(){
		return this.endtime;
	}
	public void setPlaytime(String playtime){
		this.playtime = playtime;
	}
	public String getPlaytime(){
		return this.playtime;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getUid(){
		return this.uid;
	}

}