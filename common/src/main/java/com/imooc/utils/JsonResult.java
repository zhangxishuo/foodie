package com.imooc.utils;

public class JsonResult {

    private Integer status;

    private String msg;

    private Object data;

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public static JsonResult error(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult ok() {
        return new JsonResult(200, "OK", null);
    }
}
