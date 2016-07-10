package com.shuh.myapplication.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.shuh.myapplication.R;
import com.shuh.myapplication.base.BaseFragment;
import com.shuh.mymodule.utils.ViewUtil;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class Fragment02 extends BaseFragment {

    private View root;
    @Override
    protected View findViews(LayoutInflater inflater) {
        root = inflater.inflate(R.layout.fragment02, null);
        return root;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListener() {

    }
}
