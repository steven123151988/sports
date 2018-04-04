package com.daking.sports.json;

import com.daking.sports.base.SportsAPI;

import java.io.Serializable;


public class BaseModel implements Serializable {

    /**
     * 状态码
     */
    protected int code;

    /**
     * 错误信息
     */
    protected String msg;


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


    public String getErrorCodeInfo() {
        return SportsAPI.getErrorCodeInfo(msg);
    }

    private int errnum;
    private Object error;
    private String sign;

    public int getErrnum() {
        return errnum;
    }

    public void setErrnum(int errnum) {
        this.errnum = errnum;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
