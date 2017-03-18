package com.lxd.htsj.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by suixiang on 2017/3/14.
 */

public abstract class BaseFragment extends Fragment {

    protected View view;
    private long lastClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater, container);
        ButterKnife.bind(this, view);//绑定到butterknife
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListener();
        initData();
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container);

    protected abstract void initListener();

    protected abstract void initData();


    protected boolean fastClick() {
        if (System.currentTimeMillis() - lastClick < 3000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }
}
