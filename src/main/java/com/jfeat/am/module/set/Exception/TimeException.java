package com.jfeat.am.module.set.Exception;

public class TimeException extends Exception {

    private String message ;

    public TimeException(String 时间错误输入) {
    }

    public TimeException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
