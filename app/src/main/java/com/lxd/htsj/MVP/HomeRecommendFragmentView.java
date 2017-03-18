package com.lxd.htsj.MVP;

import com.lxd.htsj.Entity.Login;

/**
 * Created by XY on 2016/9/17.
 */
public interface HomeRecommendFragmentView {
    //显示加载页
    void showProgress();

    //关闭加载页
    void hideProgress();

    //加载新数据
    void newDatas(Login data);

    //显示加载失败
    void showLoadFailMsg();

}
