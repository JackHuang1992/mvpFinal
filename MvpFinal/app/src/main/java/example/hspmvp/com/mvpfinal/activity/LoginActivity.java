package example.hspmvp.com.mvpfinal.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import example.hspmvp.com.mvpfinal.MainActivity;
import example.hspmvp.com.mvpfinal.R;
import example.hspmvp.com.mvpfinal.base.BaseActivity;
import example.hspmvp.com.mvpfinal.bean.UserInfo;
import example.hspmvp.com.mvpfinal.mvp.presenter.LoginPresenter;
import example.hspmvp.com.mvpfinal.utils.XToast;
import example.hspmvp.com.mvpfinal.mvp.view.ILoginView;

/**
 * author: 黄士鹏
 * created on: 2017/12/7 14:03
 * description: 登录Activity
 */

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener{
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter mUserLoginPresenter;
    private Context context;

    @Override
    protected int getLayout() { //获得布局文件
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        context = this;
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    //初始化Presenter
    @Override
    protected void initPresenter() {
        mUserLoginPresenter = new LoginPresenter(this,context);
    }

    //绑定事件监听
    @Override
    protected void initListeners() {
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    protected void initAdapters() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void loadDataSuccess(UserInfo userInfo) {
        //登录成功
        hideLoading();
        XToast.showShortMsg(context,"登录成功");
        toMainActivity();
    }

    @Override
    public void loadDataError() {
        //登录失败
        hideLoading();
        XToast.showShortMsg(context,"登录失败");
        return;
    }

    @Override
    public void loadOtherError() {
        //登录失败时服务器返回的其他信息
        hideLoading();
        XToast.showShortMsg(context,mUserLoginPresenter.getNetMessage());
        return;
    }

    @Override
    public void onUsernameEmptyError() {
        //用户名为空时的处理
        hideLoading();
        XToast.showShortMsg(context,"用户名不能为空");
        return;
    }

    @Override
    public void userCheckError() {
        //用户名格式错误时的处理
        hideLoading();
        XToast.showShortMsg(context,"用户名格式错误");
        return;
    }

    @Override
    public void onPasswordEmptyError() {
        //密码为空时的处理
        hideLoading();
        XToast.showShortMsg(context,"密码不能为空");
        return;
    }

    @Override
    public String getUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return  password.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity() { //跳转activity
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        //点击事件监听
        mUserLoginPresenter.loginListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //回收Presenter和view  节省内存 避免内存泄漏
        mUserLoginPresenter.destoryView();
    }
}
