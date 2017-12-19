package com.jlkf.mvc_retrofit_rxjava2;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication mainApplication;

    public static MainApplication get(){
        return mainApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
    }
}
