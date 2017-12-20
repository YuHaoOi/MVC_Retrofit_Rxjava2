package com.jlkf.mvc_retrofit_rxjava2.net;

/**
 * 当不需要处理 onStart和onComplete事件时，调用网络请求时可以直接使用这个回调
 */
public abstract class OiSimpleCallback<T> implements SimpleCallback<T> {
    public void onStart(){}
    public void onComplete(){}
}
