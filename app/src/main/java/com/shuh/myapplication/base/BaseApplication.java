package com.shuh.myapplication.base;

import android.app.Application;

import com.shuh.mymodule.utils.LogUtil;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        LogUtil.initLog(true, LogUtil.Level.d);
    }
}
