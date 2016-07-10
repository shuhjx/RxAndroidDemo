package com.shuh.myapplication.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public abstract class BaseActivity extends AppCompatActivity {

//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        findViews(savedInstanceState, persistentState);
//        initViews();
//        initListener();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews(savedInstanceState);
        initViews();
        initListener();
    }

    protected abstract void findViews(Bundle savedInstanceState);
    protected abstract void initViews();
    protected abstract void initListener();


}
