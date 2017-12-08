package example.hspmvp.com.mvpfinal.mvp.view;


import example.hspmvp.com.mvpfinal.base.IBaseView;
import example.hspmvp.com.mvpfinal.bean.UserInfo;

/**
 * author: 黄士鹏
 * created on: 2017/12/7 10:59
 * description: 登录View层
 */

public interface ILoginView extends IBaseView<UserInfo>{
    void onUsernameEmptyError();

    void userCheckError();

    void onPasswordEmptyError();

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity();
}
