package com.cn.networkdemo.request;

/**
 * Description：
 * Created on 2018/8/14 0014
 * Author : 郭
 */
public class ImaRequestBean {
    private int type;

    public ImaRequestBean(int type) {
        setType(type);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImaRequestBean{" +
                "type=" + type +
                '}';
    }
}
