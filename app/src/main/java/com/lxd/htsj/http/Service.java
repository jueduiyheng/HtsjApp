package com.lxd.htsj.http;

import com.lxd.htsj.Entity.Login;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by suixiang on 2017/3/3.
 * API接口
 */

public interface Service {
    //登录
    @FormUrlEncoded
    @POST("User.asmx/Login")
    Observable<HttpResult<Login>> getLogin(@Field("name") String name, @Field("pwd") String pwd, @Field("companyid") String companyid);

    @GET("login1.txt")
    Observable<HttpResult<Login>> getLogin1();
}
