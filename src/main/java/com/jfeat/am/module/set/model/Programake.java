package com.jfeat.am.module.set.model;

/**
 * Programake 实体类
 * @date 2019-11-05 14:32:47
 * @version 1.0
 */
public class Programake implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer playLength;
	private String resolution;
	private String upLoadFile;
	private String city ;
	private String area;

	/** setter and getter method */
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
    public Integer getPlayLength() {
        return playLength;
    }
    public void setPlayLength(Integer playLength) {
        this.playLength = playLength;
    }
    public String getUpLoadFile() {
        return upLoadFile;
    }
    public void setUpLoadFile(String upLoadFile) {
        this.upLoadFile = upLoadFile;
    }
    public void setResolution(String resolution){
		this.resolution = resolution;
	}
	public String getResolution(){
		return this.resolution;
	}
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}