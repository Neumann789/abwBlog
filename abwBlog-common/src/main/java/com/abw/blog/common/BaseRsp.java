package com.abw.blog.common;

import com.abw.blog.common.constants.RspCodeEnum;

import java.io.Serializable;

/**
 * Created by fanghuabao on 2018/4/13 0013.
 */
public class BaseRsp<T> implements Serializable{

    /**
     * rspCode: 响应码.
     */
    private String rspCode;

    /**
     * rspMsg: 响应描述.
     */
    private String rspMsg;

    /**
     * data: 消息体.
     */
    private T data;

    public BaseRsp(){}
    public BaseRsp(String rspCode,String rspMsg){
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public BaseRsp(RspCodeEnum rspCodeEnum){
        this.rspCode = rspCodeEnum.getRspCode();
        this.rspMsg = rspCodeEnum.getRspMsg();
    }

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BaseRsp returnSuccss(){
        return new BaseRsp(RspCodeEnum.SUCCESS);
    }

    public static BaseRsp returnFail(){
        return new BaseRsp(RspCodeEnum.FAIL);
    }

    public static <RspDTO>BaseRsp returnSuccss(RspDTO rspDTO){
        BaseRsp baseRsp = new BaseRsp(RspCodeEnum.SUCCESS);
        baseRsp.setData(rspDTO);
        return baseRsp;
    }

    public static BaseRsp returnRsp(RspCodeEnum rspCodeEnum){
        return new BaseRsp(rspCodeEnum);
    }
}
