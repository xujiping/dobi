package com.xjp.result;

/**
 * Created by xjpdy on 2017/7/31.
 */
public enum ReturnCode {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    LOGINFAIL(3, "登录失败，账号或密码错误");

    private int code;
    private String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
