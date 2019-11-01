package com.jfeat.am.module.set.model;

/**
 * Showtemplate 实体类
 * @date 2019-11-01 10:33:12
 * @version 1.0
 */
public class Showtemplate implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String templateName;
	private String picPath;
	private Integer uid;

	/** setter and getter method */
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getPicPath() {
        return picPath;
    }
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getUid(){
		return this.uid;
	}

}