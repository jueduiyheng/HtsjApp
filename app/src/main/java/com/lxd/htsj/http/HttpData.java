package com.lxd.htsj.http;

import com.lxd.htsj.Entity.Login;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by suixiang on 2017/3/7.
 * 所有的请求数据的方法集中地
 * 根据MovieService的定义编写合适的方法
 */

public class HttpData extends RetrofitUtils {
    protected static final Service service = getRetrofit().create(Service.class);

    //登录
    public void getLogin(String name, String pwd, String companyid, Observer<Login> observer) {
        Observable observable = service.getLogin(name, pwd, companyid).map(new HttpResultFunc<Login>());
        setSubscribe(observable, observer);
    }

    //测试
    public void getLogin1(Observer<Login> observer) {
        Observable observable = service.getLogin1().map(new HttpResultFunc<Login>());
        setSubscribe(observable, observer);
    }


    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (!"1".equals(httpResult.getCode())) {
                throw new ApiException(httpResult);
            }
            return httpResult.getData();
        }
    }
}
