package com.jlkf.mvc_retrofit_rxjava2.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DuoNuo on 2017/9/28.
 */

class NetTransformer<T> implements ObservableTransformer<BaseResponse<T>, T> {

    @Override
    public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
        return upstream.flatMap(new BaseResponseFunc<T>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
