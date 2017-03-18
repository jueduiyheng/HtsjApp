package com.lxd.htsj.MVP.model;


import com.lxd.htsj.Entity.Login;
import com.lxd.htsj.Util.LogUtil;
import com.lxd.htsj.http.HttpData;
import com.lxd.htsj.http.OnLoadDataListListener;

import rx.Observer;

/**
 * Created by XY on 2016/9/17.
 */
public class HomeRecommendFragmentModel {

    public void loadData(final OnLoadDataListListener listener) {
        HttpData.getInstance().getLogin1(new Observer<Login>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
                LogUtil.d(e.toString());
            }

            @Override
            public void onNext(Login login) {
                listener.onSuccess(login);
                LogUtil.d("请求成功");
            }
        });
    }
}
