package com.jlkf.mvc_retrofit_rxjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jlkf.mvc_retrofit_rxjava2.net.ApiManager;
import com.jlkf.mvc_retrofit_rxjava2.net.SimpleCallback;
import com.jlkf.mvc_retrofit_rxjava2.net.UserBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiManager.getInstace().login("18589080625", "ede8fe4747908d485c17f01978e617ab", new SimpleCallback<UserBean>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onNext(UserBean userBean) {
                Toast.makeText(MainActivity.this, userBean.nickname, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}