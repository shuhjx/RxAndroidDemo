package com.shuh.mymodule.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuh.mymodule.holder.BaseViewHolder;
import com.shuh.mymodule.model.BaseModel;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class BaseRecyclerAdapter<H extends BaseViewHolder> extends RecyclerView.Adapter<H> {

    private List<? extends BaseModel> list;
    private Context context;
    private Class<H> cls;
    private @LayoutRes int resId;

    public BaseRecyclerAdapter(Context context, List<? extends BaseModel> list, @LayoutRes int resId, Class<H> cls){
        this.list = list;
        this.context = context;
        this.cls = cls;
        this.resId = resId;
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            Constructor c1 = cls.getDeclaredConstructor(new Class[]{View.class});
            return (H) c1.newInstance(LayoutInflater.from(context).inflate(resId, parent, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(H holder, int position) {
        holder.setDate(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
