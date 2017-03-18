package com.lxd.htsj.Base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.lxd.htsj.Util.listener.PermissionsResultListener;
import com.lxd.htsj.loading.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by suixiang on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private PermissionsResultListener mListener;
    private int mRequestCode;
    private long lastClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(initUI());
        ButterKnife.bind(this);
        initlayout();
    }

    /**
     * 初始activity方法
     */

    private void initlayout() {
        init();
        setListener();
        initLogic();
    }

    /**
     * 其他 Activity 继承 BaseActivity 调用 performRequestPermissions 方法
     *
     * @param desc        首次申请权限被拒绝后再次申请给用户的描述提示
     * @param permissions 要申请的权限数组
     * @param requestCode 申请标记值
     * @param listener    实现的接口
     */
    protected void performRequestPermissions(String desc, String[] permissions,
                                             int requestCode,
                                             PermissionsResultListener listener) {
        if (permissions == null || permissions.length == 0) {
            return;
        }
        mRequestCode = requestCode;
        mListener = listener;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkEachSelfPermission(permissions)) {// 检查是否声明了权限
                requestEachPermissions(desc, permissions, requestCode);
            } else {// 已经申请权限
                if (mListener != null) {
                    mListener.onPermissionGranted();
                }
            }
        } else {
            if (mListener != null) {
                mListener.onPermissionGranted();
            }
        }
    }


    /**
     * 显示默认加载动画 默认加载文字
     */
    protected void showLoadingDialog() {
        LoadingDialog.showLoadingDialog(this);
    }

    /**
     * 显示加载动画 默认加载文字
     *
     * @param type
     */
    protected void showLoadingDialog(int type) {
        LoadingDialog.showLoadingDialog(this, type);
    }

    /**
     * 显示加载动画 默认加载文字，自定义图片
     *
     * @param type
     */
    protected void showLoadingDialog(int type, int drawableId) {
        LoadingDialog.showLoadingDialog(this, type, drawableId);
    }

    /**
     * 显示默认加载动画 自定义加载文字
     *
     * @param str
     */
    protected void showLoadingDialog(String str) {
        LoadingDialog.showLoadingDialog(this, str);
    }

    /**
     * 显示加载动画 自定义加载文字
     *
     * @param type
     * @param str
     */
    protected void showLoadingDialog(int type, String str) {
        LoadingDialog.showLoadingDialog(this, type, str);
    }

    /**
     * 显示加载动画 自定义加载文字 自定义图片
     *
     * @param type
     * @param str
     */
    protected void showLoadingDialog(int type, String str, int drawable) {
        LoadingDialog.showLoadingDialog(this, type, str, drawable);
    }

    /**
     * 取消加载动画
     */
    protected void cancelLoadingDialog() {
        LoadingDialog.cancelLoadingDialog();
    }

    /**
     * 初始化layout
     */
    protected abstract int initUI();

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 设置各种事件的监听器
     */
    protected abstract void setListener();

    /**
     * 业务逻辑处理
     */
    protected abstract void initLogic();

    /**
     * View点击
     **/
    protected abstract void widgetClick(View v);

    /** ==================================点击屏幕的任何位置隐藏软键盘=============================================*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    /** ==================================防止快速点击=============================================*/
    protected boolean fastClick() {
        if (System.currentTimeMillis() - lastClick < 3500) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    /**
     * 申请权限前判断是否需要声明
     *
     * @param desc
     * @param permissions
     * @param requestCode
     */
    private void requestEachPermissions(String desc, String[] permissions, int requestCode) {
        if (shouldShowRequestPermissionRationale(permissions)) {// 需要再次声明
//            showRationaleDialog(desc, permissions, requestCode);
            ActivityCompat.requestPermissions(BaseActivity.this, permissions, requestCode);

        } else {
            ActivityCompat.requestPermissions(BaseActivity.this, permissions, requestCode);
        }
    }

    /**
     * 弹出声明的 Dialog
     *
     * @param desc
     * @param permissions
     * @param requestCode
     */
    private void showRationaleDialog(String desc, final String[] permissions, final int requestCode) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage(desc)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(BaseActivity.this, permissions, requestCode);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }


    /**
     * 再次申请权限时，是否需要声明
     *
     * @param permissions
     * @return
     */
    private boolean shouldShowRequestPermissionRationale(String[] permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 检察每个权限是否申请
     *
     * @param permissions
     * @return true 需要申请权限,false 已申请权限
     */
    private boolean checkEachSelfPermission(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return true;
            }
        }
        return false;
    }

    /**
     * 申请权限结果的回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == mRequestCode) {
            if (checkEachPermissionsGranted(grantResults)) {
                if (mListener != null) {
                    mListener.onPermissionGranted();
                }
            } else {// 用户拒绝申请权限
                if (mListener != null) {
                    mListener.onPermissionDenied();
                }
            }
        }
    }

    /**
     * 检查回调结果
     *
     * @param grantResults
     * @return
     */
    private boolean checkEachPermissionsGranted(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}
