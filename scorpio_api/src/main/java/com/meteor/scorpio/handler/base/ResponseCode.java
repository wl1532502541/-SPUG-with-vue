package com.meteor.scorpio.handler.base;

public enum ResponseCode {

    /**
     * 成功返回的状态码
     */
    SUCCESS(0,"请求成功"),

    /**
     * 请求失败的状态码
     */
    ERROR(-1,"请求失败"),


    PARAM_ERROR(-2,"业务参数错误"),

    Unauthorized(-3,"无权限访问"),

    /**
     * 资源不存在的状态码
     */
    RESOURCE_NOT_EXIST(-1,"RESOURCE NOT EXIST"),


    /**
     * 无权限的状态码
     */
    NO_PERMISSION(-2, "NO PERMISSION"),

    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(-3,"SERVICE_ERROR");

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
