package example.hspmvp.com.mvpfinal.application;

import android.app.Application;

import org.xutils.x;

/**
 * author: 黄士鹏
 * created on: 2017/12/4 14:20
 * description:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //全局初始化xutils3
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
