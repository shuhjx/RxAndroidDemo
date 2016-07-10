package com.shuh.mymodule.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class ViewUtil {

    /**
     * 禁止实例化该类
     */
    private ViewUtil() {
        throw new UnsupportedOperationException("The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    public static <V extends View> V findViewById(Activity activity, @IdRes int resId){
        return (V) activity.findViewById(resId);
    }

    public static <V extends View> V findViewById(View view, @IdRes int resId){
        if(view == null)
            throw new IllegalArgumentException("The argument view can not be null,please check your argument!");
        return (V) view.findViewById(resId);
    }
}
