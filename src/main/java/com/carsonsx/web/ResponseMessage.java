package com.carsonsx.web;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * Created by carsonsx on 2017/3/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {

    private int code = 0;

    private String msg;

    private Object data;

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

    public static ResponseMessage ok() {
        ResponseMessage msg = new ResponseMessage();
        msg.msg = "ok";
        return msg;
    }

    public static ResponseMessage data(String data) {
        ResponseMessage msg = ok();
        msg.data = data;
        return msg;
    }

    public static ResponseMessage notExists(String val) {
        ResponseMessage msg = new ResponseMessage();
        msg.code = 1000;
        msg.msg = "Not Existed";
        return msg;
    }
}
