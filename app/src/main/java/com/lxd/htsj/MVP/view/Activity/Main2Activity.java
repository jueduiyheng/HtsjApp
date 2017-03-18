package com.lxd.htsj.MVP.view.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lxd.htsj.Adapter.MainAdapter;
import com.lxd.htsj.Base.BaseActivity;
import com.lxd.htsj.Constant.Data;
import com.lxd.htsj.Entity.MainDateDto;
import com.lxd.htsj.R;
import com.orhanobut.logger.Logger;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;

import butterknife.BindView;

public class Main2Activity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private BaseQuickAdapter homeAdapter;

    @Override
    protected int initUI() {
        return R.layout.activity_main2;
    }

    @Override
    protected void init() {
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

    }

    @Override
    protected void widgetClick(View v) {

    }

    @Override
    public void onClick(View v) {

    }
}
