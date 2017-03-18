package com.lxd.htsj.http;

/**
 * Created by suixiang on 2017/3/2.
 * 网络请求结果 基类
 * 按照接口需求来  不可直接套用
 */

public class HttpResult<T> {
    public String code;
    public String msg;
    public T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
