package com.jlkf.mvc_retrofit_rxjava2.net;

/**
 * Created by DuoNuo on 2017/9/21.
 */
public interface SimpleCallback<T> {
    void onStartRequest();
    void onNext(T t);
    void onCompleteRequest();
}
