package com.shuh.myapplication.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shuh.mymodule.utils.LogUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class PageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private String[] titles;
    public PageAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    public void setTitles(String[] titles){
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(titles == null) return null;
        try{
            return titles[position];
        }catch (Exception exc){
            return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
