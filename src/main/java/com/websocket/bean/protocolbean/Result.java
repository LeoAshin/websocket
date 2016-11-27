package com.websocket.bean.protocolbean;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 18:21
 */
public class Result {

    private String head;
    private String body;
    private String code;
    private short status;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
