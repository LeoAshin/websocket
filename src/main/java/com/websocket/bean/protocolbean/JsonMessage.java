package com.websocket.bean.protocolbean;

/**
 * Created by andilyliao on 16-3-31.
 */
//输入报文
public class JsonMessage {
    private String head;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
