package com.shuh.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shuh.myapplication.R;
import com.shuh.myapplication.model.F1Model;
import com.shuh.mymodule.holder.BaseViewHolder;
import com.shuh.mymodule.model.BaseModel;
import com.shuh.mymodule.utils.ViewUtil;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class F1ViewHolder extends BaseViewHolder {

    private TextView tv1, tv2;

    public F1ViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initViews(View v) {
        tv1 = ViewUtil.findViewById(v, R.id.tv1);
        tv2 = ViewUtil.findViewById(v, R.id.tv2);
    }

    @Override
    public void setDate(BaseModel model) {
        if(model != null){
            F1Model f1 = (F1Model) model;
            tv1.setText(f1.getUpdatetime());
            tv2.setText(f1.getContent());
        }
    }

}
