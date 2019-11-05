package com.jfeat.am.module.set.model;

/**
 * Terminalmanager 实体类
 * @date 2019-11-04 17:20:25
 * @version 1.0
 */
public class Terminalmanager implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String model;
	private String area;
	private String city;
	private String updateTime;
	private Long interval;
	private String resolution;
	private String control;
	private String updateState;

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
	public void setModel(String model){
		this.model = model;
	}
	public String getModel(){
		return this.model;
	}
	public void setArea(String area){
		this.area = area;
	}
	public String getArea(){
		return this.area;
	}
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public void setInterval(Long interval){
		this.interval = interval;
	}
	public Long getInterval(){
		return this.interval;
	}
	public void setResolution(String resolution){
		this.resolution = resolution;
	}
	public String getResolution(){
		return this.resolution;
	}
	public void setControl(String control){
		this.control = control;
	}
	public String getControl(){
		return this.control;
	}
    public String getUpdateState() {
        return updateState;
    }
    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}