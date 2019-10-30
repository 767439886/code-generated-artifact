package com.jfeat.am.module.set.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-10-29
 */
public class Student extends Model<Student> {

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONArray images;

    public com.alibaba.fastjson.JSONArray getImages() {
        return images;
    }
    public void setImages(com.alibaba.fastjson.JSONArray images) {
        this.images = images;
    }

    @com.baomidou.mybatisplus.annotations.TableField(exist = false)
    private com.alibaba.fastjson.JSONArray tags;

    public com.alibaba.fastjson.JSONArray getTags() {
        return tags;
    }
    public void setTags(com.alibaba.fastjson.JSONArray tags) {
        this.tags = tags;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 名字
     */
	private String name;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 教师id
     */
	@TableField("teacher_id")
	private Long teacherId;


	public Long getId() {
		return id;
	}

	public Student setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Student setAge(Integer age) {
		this.age = age;
		return this;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public Student setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String AGE = "age";

	public static final String TEACHER_ID = "teacher_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Student{" +
			"id=" + id +
			", name=" + name +
			", age=" + age +
			", teacherId=" + teacherId +
			"}";
	}
}
