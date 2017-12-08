package example.hspmvp.com.mvpfinal.mvp.presenter;

import android.content.Context;

import example.hspmvp.com.mvpfinal.base.BasePresenter;
import example.hspmvp.com.mvpfinal.mvp.model.LoginModel;
import example.hspmvp.com.mvpfinal.mvp.view.ILoginView;
import example.hspmvp.com.mvpfinal.utils.XStringCheckUtils;

/**
 * author: 黄士鹏
 * created on: 2017/12/7 11:01
 * description: 登录Presenter层
 */

public class LoginPresenter implements BasePresenter {
    private LoginModel loginModel;
    private Context context;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView,Context context) {
        this.loginModel = new LoginModel();
        this.iLoginView = iLoginView;
        this.context = context;
    }

    public void loginListener() {
        if (iLoginView != null) {
            iLoginView.showLoading();
        }
        if (XStringCheckUtils.isEmpty(iLoginView.getUserName())) {
            iLoginView.onUsernameEmptyError();
        } else if (!XStringCheckUtils.isMobileNO(iLoginView.getUserName())) {
            iLoginView.userCheckError();
        } else if (XStringCheckUtils.isEmpty(iLoginView.getPassword())) {
            iLoginView.onPasswordEmptyError();
        } else {
            loginModel.login(context, iLoginView, iLoginView.getUserName(), iLoginView.getPassword());
        }
    }

    public String getNetMessage(){
        return loginModel.getMessage();
    }

    @Override
    public void destoryView() {
        iLoginView = null;
        loginModel = null;
    }
}
