package com.shuh.mymodule.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shuh.mymodule.model.BaseModel;


/**
 * Created by Administrator on 2016/7/9 0009.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        initViews(itemView);
    }

    protected abstract void initViews(View v);
    public abstract void setDate(BaseModel model);
}
