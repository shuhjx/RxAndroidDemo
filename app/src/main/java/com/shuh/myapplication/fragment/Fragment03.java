package com.shuh.myapplication.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.shuh.myapplication.R;
import com.shuh.myapplication.base.BaseFragment;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class Fragment03 extends BaseFragment {

    private View root;
    @Override
    protected View findViews(LayoutInflater inflater) {
        root = inflater.inflate(R.layout.fragment03, null);
        return root;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListener() {

    }
}
