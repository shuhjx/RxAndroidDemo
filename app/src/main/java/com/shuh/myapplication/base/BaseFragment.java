package com.shuh.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shuh.mymodule.dialog.DialogLoading;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public abstract class BaseFragment extends Fragment {

    private DialogLoading loading;
    private Toast mToast;
    /**
     * 使用CompositeSubscription来持有所有的Subscriptions
     */
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return findViews(inflater);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initListener();
    }

    protected abstract View findViews(LayoutInflater inflater);
    protected abstract void initViews();
    protected abstract void initListener();

    protected void showLoadingDialog() {
        if (loading == null) {
            loading = new DialogLoading(getActivity());
        }
        loading.show();
    }

    protected void hideLoadingDialog() {
        if (loading != null) {
            loading.dismiss();
        }

    }

    /**
     * 显示一个Toast信息
     *
     * @param content
     */
    public void showToast(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        mToast.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //一旦调用了 CompositeSubscription.unsubscribe()，这个CompositeSubscription对象就不可用了,
        // 如果还想使用CompositeSubscription，就必须在创建一个新的对象了。
        mCompositeSubscription.unsubscribe();

    }
}
