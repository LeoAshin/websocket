package com.websocket.bean;

/**
 * Created by LeoAshin on 2016/11/10.
 * websocket_http in 09:27
 */
public class Message {

    private String head;
    private Object body;

    private String num;

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public Object getBody() {
        return body;
    }

    public String getNum() {
        return num;
    }

    public void setBody(Object body) {
        this.body = body;

    }

    public void setNum(String num) {
        this.num = num;
    }
}
