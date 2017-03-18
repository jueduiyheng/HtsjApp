package com.lxd.htsj.MVP.view;

/**
 * Created by suixiang on 2017/3/8.
 */

public interface loginview {

    //显示加载页
    void showProgress();

    //关闭加载页
    void hideProgress();

    //加载新数据
//    void newDatas(Login data);

    //显示加载失败
    void showLoadFailMsg();
}
