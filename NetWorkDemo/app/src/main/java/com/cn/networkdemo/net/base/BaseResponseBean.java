package com.cn.networkdemo.net.base;

/**
 * Description：请求完成返回的数据 基类
 * Created on 2018/7/3 0003
 * Author : 郭
 */
public class BaseResponseBean<T> {
    private T result;
    private String code;
    private String message;
    private String dateTime;
    private Object obj;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "BaseResponseBean{" +
                "result=" + result +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", obj=" + obj +
                '}';
    }
}
