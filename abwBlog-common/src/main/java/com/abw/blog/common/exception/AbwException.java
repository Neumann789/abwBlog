package com.abw.blog.common.exception;

import com.abw.blog.common.constants.RspCodeEnum;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 *
 * 封装异常类
 */

public class AbwException extends RuntimeException {
    private static final long serialVersionUID = 5318227622381092310L;
    private String code;
    private String msg;
    private String status;

    public AbwException() {
    }

    public AbwException(String errorMsg) {
        super(errorMsg);
        this.code = RspCodeEnum.FAIL.getRspCode();
        this.msg = errorMsg;
    }

    public AbwException(String errorMsg, Throwable t) {
        super(errorMsg, t);
        this.code = RspCodeEnum.FAIL.getRspCode();
        this.msg = errorMsg;
    }

    public AbwException(String code, String msg, String status) {
        super(code + "-" + msg + "-" + status);
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public AbwException(String code, String msg) {
        super(code + "-" + msg);
        this.code = code;
        this.msg = msg;
    }

    public AbwException(RspCodeEnum resp, Object... args) {
        super(getCodeAndMsg(resp, args));
        this.code = resp.getRspCode();
        if(args.length != 0) {
            this.msg = resp.getRspMsg(args);
        } else {
            this.msg = resp.getRspMsg().replaceAll("%s", "");
        }

    }

    public String getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCodeAndMsg() {
        return this.code + "-" + this.getMsg();
    }

    private static String getCodeAndMsg(RspCodeEnum resp, Object... args) {
        String code = resp.getRspCode();
        String msg = null;
        if(args.length != 0) {
            msg = resp.getRspMsg(args);
        } else {
            msg = resp.getRspMsg().replaceAll("%s", "");
        }

        return code + "-" + msg;
    }
}
