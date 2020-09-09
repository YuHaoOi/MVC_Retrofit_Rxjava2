package com.jlkf.mvc_retrofit_rxjava2.net;

import android.app.Application;

import com.jlkf.mvc_retrofit_rxjava2.MainApplication;

/**
 * Created by DuoNuo on 2017/9/21.
 */

public class ApiManager {

    private ApiService apiService;
    private Application application;

    private ApiManager(ApiService apiService, Application application) {
        this.apiService = apiService;
        this.application = application;
    }

    private static class OiRetrofitUtilsHolder {
        private static ApiManager oiApiManager = new ApiManager(OiApiManager.getApiServie(), MainApplication.get());
    }

    public static ApiManager getInstance() {
        return OiRetrofitUtilsHolder.oiApiManager;
    }

    public void login(String userName, String password, SimpleCallback<UserBean> simpleCallback){
        apiService.login(userName, password)
                .compose(new NetTransformer<UserBean>())
                .subscribe(new ExceptionSubscriber<>(simpleCallback, application));
    }
}
