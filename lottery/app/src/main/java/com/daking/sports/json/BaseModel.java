package com.daking.sports.json;

import com.daking.sports.base.SportsAPI;

import java.io.Serializable;

/**
 * Created by SUNNY18 on 2018/3/5.
 */

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

    private int errno;
    private Object error;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
