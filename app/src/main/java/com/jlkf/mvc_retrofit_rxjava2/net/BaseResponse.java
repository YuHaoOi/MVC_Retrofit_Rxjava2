package com.jlkf.mvc_retrofit_rxjava2.net;

/**
 * Created by DuoNuo on 2017/9/15.
 */

public class BaseResponse<T> {

    public int code;
    public String msg;
    public T data;

}
