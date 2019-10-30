package com.jfeat.am.module.set.common;

import com.jfeat.am.module.set.model.AdvertisBrand;

import java.util.List;

//  返回的类，作用于返回数据
public class Result {

    //  返回给前端的数据
    private Object data ;
    //  返回给前端的信息
    private String message ;
    //  返回给前端的状态
    private int code  ;

    public Result(Object data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
