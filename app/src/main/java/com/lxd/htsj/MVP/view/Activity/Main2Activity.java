package com.lxd.htsj.MVP.view.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lxd.htsj.Adapter.MainAdapter;
import com.lxd.htsj.Base.BaseActivity;
import com.lxd.htsj.Constant.Constant;
import com.lxd.htsj.Constant.Data;
import com.lxd.htsj.Entity.Login;
import com.lxd.htsj.Entity.MainDateDto;
import com.lxd.htsj.MVP.HomeRecommendFragmentView;
import com.lxd.htsj.MVP.presenter.HomeRecommendFragmentPresenter;
import com.lxd.htsj.R;
import com.orhanobut.logger.Logger;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;

import butterknife.BindView;

public class Main2Activity extends BaseActivity implements HomeRecommendFragmentView {
    @BindView(R.id.main_progress)
    ProgressActivity mainProgress;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private BaseQuickAdapter homeAdapter;
    private HomeRecommendFragmentPresenter presenter;

    @Override
    protected int initUI() {
        return R.layout.activity_main2;
    }

    @Override
    protected void init() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("测试 RecyclerView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置RecyclerView的显示模式ListVew
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        homeAdapter = new MainAdapter(R.layout.main_item_layout, Data.getData());
        //将适配器添加到RecyclerView
        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    protected void setListener() {
        homeAdapter.setOnRecyclerViewItemClickListener(
                new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MainDateDto mainDateDto = Data.getData().get(position);
                        Toast.makeText(Main2Activity.this, mainDateDto.getTitle(), Toast.LENGTH_SHORT).show();
                        Logger.d(mainDateDto.getTitle());
                    }
                });
    }

    @Override
    protected void initLogic() {

        presenter = new HomeRecommendFragmentPresenter(this);
        presenter.LoadData();
    }

    @Override
    protected void widgetClick(View v) {

    }

    @Override
    public void showProgress() {
        mainProgress.showLoading();
    }

    @Override
    public void hideProgress() {
        mainProgress.showContent();
    }

    @Override
    public void newDatas(Login data) {

    }

    @Override
    public void showLoadFailMsg() {
        toError();
    }

    public void toError() {
        mainProgress.showError(getResources().getDrawable(
                R.mipmap.load_error), Constant.ERROR_TITLE,
                Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON,
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainProgress.showLoading();
                        //重试
                        presenter.LoadData();
                    }
                });
    }
}
