package com.meteor.scorpio.handler.base;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 3958029137214136306L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult() {
        this.code = 0;
        this.msg = null;
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
