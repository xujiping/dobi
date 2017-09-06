package com.xjp.result;

/**
 * 返回对象
 * Created by xjpdy on 2017/8/1.
 */
public class ReturnBean {
    private int code;
    private String msg;
    private Object data;

    /**
     * 成功
     */
    public ReturnBean(){
        this.code = ReturnCode.SUCCESS.code();
        this.msg = ReturnCode.SUCCESS.msg();
    }

    /**
     * 错误码
     * @param code 错误码
     */
    public ReturnBean(ReturnCode code) {
        this.code = code.code();
        this.msg = code.msg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
