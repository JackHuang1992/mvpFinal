package example.hspmvp.com.mvpfinal.bean;

import android.content.Context;

import example.hspmvp.com.mvpfinal.utils.XSharedPreferences;

/**
 * author: 黄士鹏
 * created on: 2017/12/4 13:52
 * description:
 */

public class UserInfo {
    public Context mContext;
    public String id;  //用户id
    public String accountNumber; //账号
    public String phone; //手机号
    public String name ; //昵称
    public String picture; //头像链接
    public String rid;   //角色编号
    public String perm; //权限信息
    public String token; //登录信息
    public String loginToken; //登录状态【值“ok”表示登录状态,值“no”表示未登录状态】
    public String isGuide; //是否需要启动页 值为yes需要，值为no不需要
    public String IMEI; //手机序列号
    private String loginType; //登录方式:QQ 微信
    public UserInfo(Context context){
        this.mContext = context;
    }

    public String getId() {
        return XSharedPreferences.getString(mContext,"id","");
    }

    public void setId(String id){
        XSharedPreferences.saveString(mContext,"id",id);
    }

    public String getAccountNumber() {
        return XSharedPreferences.getString(mContext,"accountNumber","");
    }

    public void setAccountNumber(String accountNumber) {
        XSharedPreferences.saveString(mContext,"accountNumber",accountNumber);
    }

    public String getPhone() {
        return XSharedPreferences.getString(mContext,"phone","");
    }

    public void setPhone(String phone) {
        XSharedPreferences.saveString(mContext,"phone",phone);
    }

    public String getName() {
        return XSharedPreferences.getString(mContext,"name","");
    }

    public void setName(String name) {
        XSharedPreferences.saveString(mContext,"name",name);
    }

    public String getPicture() {
        return XSharedPreferences.getString(mContext,"picture",picture);
    }

    public void setPicture(String picture) {
        XSharedPreferences.saveString(mContext,"picture",picture);
    }


    public String getRid() {
        return XSharedPreferences.getString(mContext,"rid","");
    }

    public void setRid(String rid) {
        XSharedPreferences.saveString(mContext,"rid",rid);
    }


    public String getLoginToken() {
        return XSharedPreferences.getString(mContext,"loginToken","");
    }

    public void setLoginToken(String loginToken) {
        XSharedPreferences.saveString(mContext,"loginToken",loginToken);
    }

    public String getPerm() {
        return XSharedPreferences.getString(mContext,"perm","");
    }

    public void setPerm(String perm) {
        XSharedPreferences.saveString(mContext,"perm",perm);
    }

    public String getToken() {
        return XSharedPreferences.getString(mContext,"token","");
    }

    public void setToken(String token) {
        XSharedPreferences.saveString(mContext,"token",token);
    }


    public String getIMEI() {
        //序列号:741AECQJ25DBA
        return IMEI;
    }

    public String getIsGuide() {
        return XSharedPreferences.getString(mContext,"isGuide","");
    }

    public void setIsGuide(String isGuide) {
        XSharedPreferences.saveString(mContext,"isGuide",isGuide);
    }


    public String getLoginType() {
        return XSharedPreferences.getString(mContext,"loginType","");
    }

    public void setLoginType(String loginType) {
        XSharedPreferences.saveString(mContext,"loginType",loginType);
    }
}
