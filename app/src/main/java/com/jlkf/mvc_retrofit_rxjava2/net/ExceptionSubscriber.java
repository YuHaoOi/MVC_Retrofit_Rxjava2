package com.jlkf.mvc_retrofit_rxjava2.net;

import android.app.Application;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;

/**
 * DisposableObserver实现了Disposable接口，可以通过subscribeWith返回
 */
public class ExceptionSubscriber<T> extends DisposableObserver<T> {

    private SimpleCallback<T> simpleCallback;
    private Application application;

    public ExceptionSubscriber(SimpleCallback<T> simpleCallback, Application application) {
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (simpleCallback != null){
            simpleCallback.onCompleteRequest();
        }
    }

    @Override
    public void onComplete() {
        if (simpleCallback != null){
            simpleCallback.onCompleteRequest();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (simpleCallback != null){
            simpleCallback.onStartRequest();
        }
    }

    @Override
    public void onNext(T t) {
        if (simpleCallback != null){
            simpleCallback.onNext(t);
        }
    }
}
