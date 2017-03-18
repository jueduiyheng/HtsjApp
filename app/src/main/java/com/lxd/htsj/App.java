package com.lxd.htsj;

import android.app.Application;

import com.lxd.htsj.Util.LogUtil;
import com.xiaochao.lcrapiddeveloplibrary.Exception.core.Recovery;

/**
 * Created by XiaoJianjun on 2017/1/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Looger工具
        LogUtil.init(true);
        //初始化异常管理工具
        Recovery.getInstance()
                .debug(true)//关闭后 在错误统一管理页面不显示异常数据
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)//恢复页面
                .init(this);
    }
}
