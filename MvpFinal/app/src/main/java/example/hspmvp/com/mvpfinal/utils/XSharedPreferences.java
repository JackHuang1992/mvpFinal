/*
 * Copyright (c) 2016 gzmhxx.com created by xjl
 * ProjectName: Doctor
 * ModuleName: app
 * FileName: XSharedPreferences.java
 * ClassName: XSharedPreferences
 * LastModified: 16-11-7 上午11:20
 */

package example.hspmvp.com.mvpfinal.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: 黄士鹏
 * created on: 2017/11/29 11:59
 * description: SharedPreferences工具类
 */

public class XSharedPreferences {

    private static SharedPreferences sp;

    /**
     * 保存int信息的操作
     */
    public static void saveInt(Context context, String key, int value){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        //保存数据
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 获取int信息的操作
     */
    public static Integer getInt(Context context, String key, int value){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp.getInt(key,value);
    }
    /**
     * 保存boolean信息的操作
     */
    public static void saveBoolean(Context context, String key, boolean value){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        //保存数据
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取boolean信息的操作
     */
    public static boolean getBoolean(Context context, String key, boolean defValue){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }


    /**
     * 保存String信息的操作
     */
    public static void saveString(Context context, String key, String value){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        //保存数据
        sp.edit().putString(key, value).commit();
    }

    /**
     * 获取String信息的操作
     */
    public static String getString(Context context, String key, String defValue){
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 移除某个key值已经对应的值
     * @param context
     * @param key
     */
    public static void remove(Context context, String key)
    {
        SharedPreferences sp = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     * @param context
     */
    public static void clear(Context context, String string)
    {
        SharedPreferences sp = context.getSharedPreferences(string,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }


    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     *
     */
    private static class SharedPreferencesCompat
    {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        private static Method findApplyMethod()
        {
            try
            {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e)
            {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor)
        {
            try
            {
                if (sApplyMethod != null)
                {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e)
            {
            } catch (IllegalAccessException e)
            {
            } catch (InvocationTargetException e)
            {
            }
            editor.commit();
        }
    }


}
