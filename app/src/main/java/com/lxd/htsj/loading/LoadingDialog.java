package com.lxd.htsj.loading;

import android.content.Context;


/**
 * Description: 加载数据时显示的对话框
 * date 2017/03/9 11:33
 */
public class LoadingDialog {

    private static ProgressDialog progressDialog;
    private static YzsLoadingDialog yzsLoadingDialog;
    /**
     * 默认载入loading
     */
    public static final int PROGRESS_LOADING = 0;
    /**
     * yzsLoading动画
     */
    public static final int YZS_LOADING = 1;

    /**
     * 载入loading，使用默认提示词
     *
     * @param context context
     */
    public static void showLoadingDialog(Context context, int type) {

        showLoadingDialog(context, type, null, 0);

    }

    /**
     * 载入loading，使用自定义提示词
     *
     * @param context context
     */
    public static void showLoadingDialog(Context context, int type, String message) {

        showLoadingDialog(context, type, message, 0);

    }

    /**
     * 载入loading，使用默认提示词，自定义图片
     *
     * @param context context
     */
    public static void showLoadingDialog(Context context, int type, int drawableId) {

        showLoadingDialog(context, type, null, drawableId);

    }

    /**
     * 载入loading，使用自定义提示词,自定义图片(只对YzsLoadingDialog有效果)
     *
     * @param context context
     */
    public static void showLoadingDialog(Context context, int type, String message, int drawableId) {
        if (null == context) {
            return;
        }
        switch (type) {
            case PROGRESS_LOADING:
                showProgressLoading(context, message);
                break;

            case YZS_LOADING:
                showYzsLoading(context, message, drawableId);
                break;

            default:
                showProgressLoading(context, message);
                break;
        }
    }


    private static void showProgressLoading(Context context) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context, "请稍候");
        }
        progressDialog.setCancelable(false);
        try {
            progressDialog.show();
        } catch (Exception e) {
//            Logger.e("progressDialog启动失败");
        }
    }

    private static void showProgressLoading(Context context, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context, null == message ? "请稍候" : message);
        }
        progressDialog.setCancelable(false);
        try {
            progressDialog.show();
        } catch (Exception e) {
//            Logger.e("progressDialog启动失败");
        }
    }

    private static void showYzsLoading(Context context) {
        if (yzsLoadingDialog == null) {
            yzsLoadingDialog = new YzsLoadingDialog(context, "请稍候");
        }
        yzsLoadingDialog.setCancelable(false);
        try {
            yzsLoadingDialog.show();
        } catch (Exception e) {
//            Logger.e("yzsLoadingDialog启动失败");
        }
    }

    private static void showYzsLoading(Context context, String message) {
        if (yzsLoadingDialog == null) {
            yzsLoadingDialog = new YzsLoadingDialog(context, message);
        }
        yzsLoadingDialog.setCancelable(false);
        try {
            yzsLoadingDialog.show();
        } catch (Exception e) {
//            Logger.e("yzsLoadingDialog启动失败");
        }
    }

    private static void showYzsLoading(Context context, int drawableId) {
        if (yzsLoadingDialog == null) {
            yzsLoadingDialog = new YzsLoadingDialog(context, context.getResources().getDrawable(drawableId));
//            Logger.e("初始化YzsLoading");
        }
        yzsLoadingDialog.setCancelable(false);

        try {
            yzsLoadingDialog.show();
        } catch (Exception e) {
//            Logger.e("yzsLoadingDialog启动失败");
        }
    }

    private static void showYzsLoading(Context context, String message, int drawableId) {
        if (yzsLoadingDialog == null && drawableId != 0) {
            yzsLoadingDialog = new YzsLoadingDialog(context, message, context.getResources().
                    getDrawable(drawableId));
        } else {
            yzsLoadingDialog = new YzsLoadingDialog(context, message);
        }
        yzsLoadingDialog.setCancelable(false);
        try {
            yzsLoadingDialog.show();
        } catch (Exception e) {
//            Logger.e("yzsLoadingDialog启动失败");
        }
    }


    /**
     * 默认载入loading
     *
     * @param context
     */
    public static void showLoadingDialog(Context context) {
        showLoadingDialog(context, PROGRESS_LOADING);
    }


    /**
     * 载入默认loading 自定义message
     *
     * @param context
     * @param message
     */
    public static void showLoadingDialog(Context context, String message) {
        if (null == context) {
            return;
        }
        showLoadingDialog(context, PROGRESS_LOADING, message);
    }

    /**
     * 取消loading
     */
    public static void cancelLoadingDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
//                Logger.e("progressDialog销毁失败");
            }
        }
        progressDialog = null;

        if (yzsLoadingDialog != null && yzsLoadingDialog.isShowing()) {
            try {
                yzsLoadingDialog.dismiss();
            } catch (Exception e) {
//                Logger.e("yzsLoadingDialog销毁失败");
            }
        }
        yzsLoadingDialog = null;
    }


}
