package example.hspmvp.com.mvpfinal.mvp.model;

import android.content.Context;


import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.http.RequestParams;
import org.xutils.x;

import example.hspmvp.com.mvpfinal.API.API;
import example.hspmvp.com.mvpfinal.bean.UserInfo;
import example.hspmvp.com.mvpfinal.mvp.view.ILoginView;
import example.hspmvp.com.mvpfinal.netcallback.MyCallBack;

/**
 * author: 黄士鹏
 * created on: 2017/12/7 10:58
 * description: 登录Model
 */

public class LoginModel {
    UserInfo userInfo;
    String message;
    public void login(final Context context, final ILoginView loginView, final String username, final String password) {
            userInfo = new UserInfo(context);
            loginView.showLoading();
            RequestParams params = new RequestParams(API.LOGIN);
            params.addBodyParameter("phone",username);
            params.addBodyParameter("pwd",password);
            String serialNum = android.os.Build.SERIAL;
            params.addBodyParameter("addr",serialNum);  //手机序列号
            x.http().post(params,new MyCallBack(){
                @Override
                public void onSuccess(String result) {
                    super.onSuccess(result);
                    if(result!=null){
                        try {
                            JSONObject object = new JSONObject(result);
                            String status = object.getString("status");
                            if(status.equals("ok")){  //登录成功
                                JSONObject object1 = object.getJSONObject("result");
                                JSONObject object2 = object1.getJSONObject("user");
                                String id = object2.getString("id");
                                userInfo.setId(id);
                                //账号
                                String ccount = object2.getString("phone");
                                userInfo.setAccountNumber(ccount); //账号

                                String name = object2.getString("name");
                                userInfo.setName(name);

                                String picture = object2.getString("picture");
                                userInfo.setPicture(picture);
                                userInfo.setLoginToken("ok");

                                String token = object2.getString("token");
                                userInfo.setToken(token);

                                userInfo.setLoginType("");
                                loginView.loadDataSuccess(userInfo);

                            }else if(status.equals("error")){
                                message = object.getString("message");
                                loginView.loadOtherError();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else{
                        loginView.loadDataError();
                    }
                }
                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    super.onError(ex, isOnCallback);
                    loginView.loadDataError();
                }
            });
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
