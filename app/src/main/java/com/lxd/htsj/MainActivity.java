package com.lxd.htsj;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lxd.htsj.Base.BaseActivity;
import com.lxd.htsj.Constant.Constant;
import com.lxd.htsj.Entity.Login;
import com.lxd.htsj.Entity.TabEntity;
import com.lxd.htsj.MVP.HomeRecommendFragmentView;
import com.lxd.htsj.MVP.presenter.HomeRecommendFragmentPresenter;
import com.lxd.htsj.MVP.view.Activity.Main2Activity;
import com.lxd.htsj.Util.TitleBuilder;
import com.lxd.htsj.Util.listener.PermissionsResultListener;
import com.orhanobut.logger.Logger;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements HomeRecommendFragmentView {
    @BindView(R.id.main_progress)
    ProgressActivity mainProgress;
    @BindView(R.id.vp_2)
    ViewPager vp2;
    @BindView(R.id.tl_2)
    CommonTabLayout tl2;
    @BindView(R.id.titlebar_iv_left)
    TextView titlebarIvLeft;
    @BindView(R.id.titlebar_tv_right)
    TextView titlebarTvRight;

    private HomeRecommendFragmentPresenter presenter;
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments2 = new ArrayList();

    private int[] mIconUnselectIds = {R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect, R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {R.mipmap.tab_home_select, R.mipmap.tab_speech_select, R.mipmap.tab_contact_select, R.mipmap.tab_more_select};

    @Override
    protected int initUI() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        new TitleBuilder(this).setLeftText("厦门").setTitleText("妹子").setRightText("消息")
                .setLeftOnClickListener(this)
                .setRightOnClickListener(this)
                .build();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        for (int i = 0; i < mTitles.length; i++) {
            mFragments2.add(new com.lxd.htsj.MVP.view.Fragment.Fragment());
        }
        vp2.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tl_2();
        //三位数
        tl2.showMsg(1, 100);
        tl2.setMsgMargin(1, -5, 5);
    }

    private void tl_2() {
        tl2.setTabData(mTabEntities);
        tl2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp2.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                Logger.d("点击了" + mTitles[position]);
                if (position == 1) {
                    tl2.hideMsg(1);
                }
            }
        });

        vp2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tl2.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        vp2.setCurrentItem(0);
    }

    @Override
    protected void setListener() {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments2.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments2.get(position);
        }
    }

    @Override
    protected void initLogic() {
//        RxView.clicks(titlebarIvLeft).throttleFirst(3000, TimeUnit.MILLISECONDS).subscribe(new Action1<Void>() {
//            @Override
//            public void call(Void aVoid) {
//                Logger.d("点击厦门");
//            }
//        });
    }

    @Override
    protected void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.titlebar_iv_left:
                presenter = new HomeRecommendFragmentPresenter(this);
                presenter.LoadData();
                Logger.d("返回");
                break;
            case R.id.titlebar_tv_right:
                performRequestPermissions("定位", new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION}
                        , 1, new PermissionsResultListener() {
                            @Override
                            public void onPermissionGranted() {
                                Toast.makeText(MainActivity.this, "已申请权限", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onPermissionDenied() {
                                Toast.makeText(MainActivity.this, "拒绝申请权限", Toast.LENGTH_LONG).show();
                            }
                        });
                Logger.d("保存");
                break;
        }

    }

    @Override
    public void showProgress() {
        titlebarIvLeft.setEnabled(false);
        mainProgress.showLoading();

        showLoadingDialog(1, "获取中...", R.drawable.ic_launcher);
    }

    @Override
    public void hideProgress() {
        cancelLoadingDialog();
        mainProgress.showContent();

    }

    @Override
    public void newDatas(Login data) {
        cancelLoadingDialog();
        titlebarIvLeft.setEnabled(true);
//        titlebarIvLeft.setClickable(true);
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    @Override
    public void showLoadFailMsg() {
        cancelLoadingDialog();
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
