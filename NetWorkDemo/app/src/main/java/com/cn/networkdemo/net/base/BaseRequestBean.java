package com.cn.networkdemo.net.base;


/**
 * Description：基本请求类 基类
 * Created on 2018/7/3 0003
 * Author : 郭
 */
public class BaseRequestBean {

    public Integer uid;
    private Integer channelNumber;

    public Integer getUid() {
        return uid;
    }

    public BaseRequestBean() {
        setChannelNumber(1);
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    @Override
    public String toString() {
        return "BaseRequestBean{" +
                "uid=" + uid +
                ", channelNumber=" + channelNumber +
                '}';
    }
}
