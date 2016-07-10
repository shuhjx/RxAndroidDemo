package com.shuh.mymodule.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class LogUtil {
    private static String TAG = "LogUtil";
    /**
     * 禁止实例化该类
     */
    private LogUtil() {
        throw new UnsupportedOperationException("The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    /**
     * 打印日志级别的枚举
     */
    public enum Level {
        v(0),/*** v级别的日志 ***/
        d(1),/*** d级别的日志 ***/
        i(2),/*** i级别的日志 ***/
        w(3),/*** w级别的日志 ***/
        e(4);/*** e级别的日志 ***/
        private int value;
        public int getValue() {
            return value;
        }
        private Level(int value) {
            this.value = value;
        }
    }

    /**
     * 默认的日志级别是e级别的
     */
    private static Level mLevel = Level.e;

    /**
     * 是否是Debug模式，可以在全局的application中设置是否打印日志。
     * true:会打印日志。false:不答应日志
     */
    public static boolean isDebug = true;

    /**
     * 在应用程序的Application里面调用该方法设置是否是Debug模式和日志打印界别，默认级别是e级别
     *
     * @param debug 是否是debug模式
     * @param level 日志级别
     */
    public static void initLog(boolean debug, Level level) {
        isDebug = debug;
        mLevel = level;
    }

    /**
     * 根据当前设置的日志界别打印日志
     *
     * @param tag TAG
     * @param msg 需要打印的信息
     */
    public static void log(String tag, String msg) {
        if (isDebug) {
            if (TextUtils.isEmpty(tag))
                tag = TAG;
            if (TextUtils.isEmpty(msg))
                msg = "Your print msg is null or \"\",please check your msg first !";
            switch (mLevel.getValue()) {
                case 0://v级别
                    Log.v(tag, msg);
                    break;
                case 1://d级别
                    Log.d(tag, msg);
                    break;
                case 2://i级别
                    Log.i(tag, msg);
                    break;
                case 3://w级别
                    Log.w(tag, msg);
                    break;
                case 4://e级别
                    Log.e(tag, msg);
                    break;
            }
        }

    }

    public static void log(Object tag, String msg) {
        if (null == tag)
            log(null, msg);
        else
            log(tag.getClass().getSimpleName(), msg);

    }

    public static void log(String msg) {
        log(null, msg);
    }

    public static void log(Object msg) {
        log(null, msg);
    }

    public static void log(Object tag, Object msg) {
        log(tag, String.valueOf(msg));
    }


}
