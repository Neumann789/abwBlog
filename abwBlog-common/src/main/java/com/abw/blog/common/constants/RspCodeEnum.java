package com.abw.blog.common.constants;

/**
 * Created by fanghuabao on 2018/4/21 0021.
 */
public enum RspCodeEnum {

    SUCCESS("0000","成功"),
    FAIL("9999","失败,原因:%s"),
    LOGIN_FAIL("L999","登录失败"),
    LOGIN_UN_REGIST("L001","此用户名未注册"),
    LOGIN_PSW_WRONG("L001","密码输入有误"),
    ;

    private String rspCode;
    private String rspMsg;
    RspCodeEnum(String rspCode, String rspMsg){
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
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

    public String getRspMsg(Object... args) {
        return String.format(this.rspMsg, args);
    }
}
