package com.jlkf.mvc_retrofit_rxjava2.net;

import com.jlkf.mvc_retrofit_rxjava2.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DuoNuo on 2017/12/15.
 */

public class OiApiManager {

    private OiApiManager() {
    }

    private static class OiRetrofitUtilsHolder {
        private static OiApiManager apiManager = new OiApiManager();
    }


    public OiApiManager getInstace() {
        return OiRetrofitUtilsHolder.apiManager;
    }

    public static ApiService getApiServie() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            //添加网络日志
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpBuilder.addInterceptor(httpLoggingInterceptor);
        }
        //连接时间
        okHttpBuilder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                //超时时间
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.client(okHttpBuilder.build())
                .baseUrl(Http.ROOT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder.build().create(ApiService.class);
    }

}
