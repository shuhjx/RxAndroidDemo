package com.shuh.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shuh.myapplication.adapter.PageAdapter;
import com.shuh.myapplication.base.BaseActivity;
import com.shuh.myapplication.fragment.Fragment01;
import com.shuh.myapplication.fragment.Fragment02;
import com.shuh.myapplication.fragment.Fragment03;
import com.shuh.mymodule.utils.ViewUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private TabLayout tabLayout;
    private ViewPager viewPage;
    private PageAdapter pageAdapter;
    private List<Fragment> fragments;

    @Override
    protected void findViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        toolbar = ViewUtil.findViewById(this, R.id.toolbar);
        fab = ViewUtil.findViewById(this, R.id.fab);
        tabLayout = ViewUtil.findViewById(this, R.id.tablayout);
        viewPage = ViewUtil.findViewById(this, R.id.viewpage);
    }


    @Override
    protected void initViews() {
        setSupportActionBar(toolbar);
        String[] titles = {"第一个", "第二个", "第三个"};
        tabLayout.setTabTextColors(Color.WHITE, Color.GRAY);//设置文本在选中和为选中时候的颜色
        tabLayout.addTab(tabLayout.newTab(), true);//添加 Tab,默认选中
        tabLayout.addTab(tabLayout.newTab(), false);//添加 Tab,默认不选中
        tabLayout.addTab(tabLayout.newTab(), false);//添加 Tab,默认不选中

        fragments = new ArrayList<>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        fragments.add(new Fragment03());

        pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        viewPage.setAdapter(pageAdapter);
        pageAdapter.setTitles(titles);
        //用来设置tab的，同时也要覆写  PagerAdapter 的 CharSequence getPageTitle(int position) 方法，要不然 Tab 没有 title
        tabLayout.setupWithViewPager(viewPage);
        //关联 TabLayout viewpager
        tabLayout.setTabsFromPagerAdapter(pageAdapter);

    }

    @Override
    protected void initListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
