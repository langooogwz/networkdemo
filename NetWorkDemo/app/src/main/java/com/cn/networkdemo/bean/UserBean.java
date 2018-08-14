package com.cn.networkdemo.bean;

import java.io.Serializable;

/**
 * Description：
 * Created on 2017/10/19
 * Author : 郭
 */

public class UserBean implements Serializable {

    private Integer uid;

    private String name;

    private Integer sex;

    private String img;

    private String telephone;

    private String password;

    private String wechatNo;

    private String wechatToken;

    private String qqNo;

    private String qqToken;

    private Integer loginStatus;

    private Integer loginType;

    private Integer source;

    private Integer createUser;

    private Integer appTheme;

    private Integer jobId;

    private String deviceToken;

    private String jobStr;
    private String updateDateStr;
    private String createDateStr;
    private String birthdayStr;
    private String loginLastDateStr;

    public UserBean() {
        super();
    }

    public UserBean(Integer uid, String name, Integer sex, String img, String telephone, String password, String wechatNo, String wechatToken, String qqNo, String qqToken, Integer loginStatus, Integer loginType, Integer source, Integer createUser, Integer appTheme, Integer jobId, String deviceToken, String jobStr, String updateDateStr, String createDateStr, String birthdayStr, String loginLastDateStr) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.img = img;
        this.telephone = telephone;
        this.password = password;
        this.wechatNo = wechatNo;
        this.wechatToken = wechatToken;
        this.qqNo = qqNo;
        this.qqToken = qqToken;
        this.loginStatus = loginStatus;
        this.loginType = loginType;
        this.source = source;
        this.createUser = createUser;
        this.appTheme = appTheme;
        this.jobId = jobId;
        this.deviceToken = deviceToken;
        this.jobStr = jobStr;
        this.updateDateStr = updateDateStr;
        this.createDateStr = createDateStr;
        this.birthdayStr = birthdayStr;
        this.loginLastDateStr = loginLastDateStr;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getWechatToken() {
        return wechatToken;
    }

    public void setWechatToken(String wechatToken) {
        this.wechatToken = wechatToken;
    }

    public String getQqNo() {
        return qqNo;
    }

    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
    }

    public String getQqToken() {
        return qqToken;
    }

    public void setQqToken(String qqToken) {
        this.qqToken = qqToken;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getAppTheme() {
        return appTheme;
    }

    public void setAppTheme(Integer appTheme) {
        this.appTheme = appTheme;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getJobStr() {
        return jobStr;
    }

    public void setJobStr(String jobStr) {
        this.jobStr = jobStr;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getLoginLastDateStr() {
        return loginLastDateStr;
    }

    public void setLoginLastDateStr(String loginLastDateStr) {
        this.loginLastDateStr = loginLastDateStr;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", wechatNo='" + wechatNo + '\'' +
                ", wechatToken='" + wechatToken + '\'' +
                ", qqNo='" + qqNo + '\'' +
                ", qqToken='" + qqToken + '\'' +
                ", loginStatus=" + loginStatus +
                ", loginType=" + loginType +
                ", source=" + source +
                ", createUser=" + createUser +
                ", appTheme=" + appTheme +
                ", jobId=" + jobId +
                ", deviceToken='" + deviceToken + '\'' +
                ", jobStr='" + jobStr + '\'' +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", createDateStr='" + createDateStr + '\'' +
                ", birthdayStr='" + birthdayStr + '\'' +
                ", loginLastDateStr='" + loginLastDateStr + '\'' +
                '}';
    }
}
