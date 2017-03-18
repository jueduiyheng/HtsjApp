package com.lxd.htsj.MVP.presenter;

import android.os.Handler;

import com.lxd.htsj.Entity.Login;
import com.lxd.htsj.MVP.HomeRecommendFragmentView;
import com.lxd.htsj.MVP.model.HomeRecommendFragmentModel;
import com.lxd.htsj.http.OnLoadDataListListener;

/**
 * Created by XY on 2016/9/17.
 */
public class HomeRecommendFragmentPresenter implements OnLoadDataListListener<Login> {
    private HomeRecommendFragmentView mView;
    private HomeRecommendFragmentModel mModel;

    public HomeRecommendFragmentPresenter(HomeRecommendFragmentView mView) {
        this.mView = mView;
        this.mModel = new HomeRecommendFragmentModel();
        mView.showProgress();
    }

    public void LoadData() {
        mModel.loadData(this);
    }

    @Override
    public void onSuccess(final Login data) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //取消loading
                mView.newDatas(data);
                mView.hideProgress();
            }
        }, 2000);
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
