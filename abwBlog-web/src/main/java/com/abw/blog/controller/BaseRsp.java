package com.abw.blog.controller;

import java.io.Serializable;

/**
 * Created by fanghuabao on 2018/4/13 0013.
 */
public class BaseRsp<T> implements Serializable{

    /**
     * code: 响应码.
     */
    private String code;

    /**
     * msg: 响应描述.
     */
    private String msg;

    /**
     * data: 消息体.
     */
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
