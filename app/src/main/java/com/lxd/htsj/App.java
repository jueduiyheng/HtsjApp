package com.lxd.htsj;

import android.app.Application;

import com.lxd.htsj.Util.LogUtil;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Created by XiaoJianjun on 2017/1/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Looger工具
        LogUtil.init(true);
        // 必须在 Application 的 onCreate 方法中执行 BGASwipeBackManager.getInstance().init(this) 来初始化滑动返回
        BGASwipeBackManager.getInstance().init(this);

    }
}
