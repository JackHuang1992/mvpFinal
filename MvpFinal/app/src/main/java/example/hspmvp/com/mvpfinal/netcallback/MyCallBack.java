package example.hspmvp.com.mvpfinal.netcallback;

import org.xutils.common.Callback;

/**
 * author: 黄士鹏
 * created on: 2017/12/4 14:06
 * description: 网络请求回调类
 */

public class MyCallBack implements Callback.CommonCallback<String>{
    @Override
    public void onSuccess(String s) {

    }

    @Override
    public void onError(Throwable throwable, boolean b) {

    }

    @Override
    public void onCancelled(CancelledException e) {

    }

    @Override
    public void onFinished() {

    }
}
