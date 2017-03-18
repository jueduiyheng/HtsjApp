package com.lxd.htsj.MVP.view.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxd.htsj.Base.BaseFragment;
import com.lxd.htsj.R;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * <pre>
 *     author : suixiang
 *     e-mail : xxx@xx
 *     time   : 2017/03/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Fragment extends BaseFragment implements View.OnClickListener {
    //    @BindView(R.id.textView)
//    TextView textView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    protected void initListener() {
        view.findViewById(R.id.textView).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (fastClick()) {
//            Toast.makeText(getActivity(), "点击", Toast.LENGTH_SHORT).show();
            Logger.d("点击");

        }
    }
}
