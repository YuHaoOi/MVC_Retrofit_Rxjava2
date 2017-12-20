package com.jlkf.mvc_retrofit_rxjava2.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DuoNuo on 2017/9/21.
 */
public interface ApiService {
    @GET("user/login.do")
    Observable<BaseResponse<UserBean>> login(@Query("loginName") String userName, @Query("password") String password);
}
