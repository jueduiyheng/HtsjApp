package com.lxd.htsj.Util.listener;

/**
 * Created by Fussen on 2017/1/11.
 */

public interface PermissionsResultListener {
    void onPermissionGranted();

    void onPermissionDenied();
}
