/*
 * Copyright (c) 2016 gzmhxx.com created by xjl
 * ProjectName: Doctor
 * ModuleName: app
 * FileName: XToast.java
 * ClassName: XToast
 * LastModified: 16-10-27 下午4:41
 */

package example.hspmvp.com.mvpfinal.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * author: 黄士鹏
 * created on: 2017/11/29 11:59
 * description: Toast工具类
 */
public class XToast {

    private XToast() {
        //Empty
    }

    public static void showShortMsg(Context context, String msg) {
        Toast toast = getToast(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLongMsg(Context context, String msg) {
        Toast toast = getToast(context, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private static Toast getToast(Context context, String msg, int length) {
        return Toast.makeText(context, msg, length);
    }

}
