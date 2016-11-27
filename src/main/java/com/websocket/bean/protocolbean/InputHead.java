package com.websocket.bean.protocolbean;

/**
 * Created by andilyliao on 16-3-31.
 */
//输入类名 方法名
public class InputHead {
    private String reqName;

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getClassname() {
        String[] qn_array = getReqName().split("/");
        System.out.println(qn_array[0]);
        String class_name = qn_array[0];
        return class_name;
    }

    public String getMethodname() {
        String[] qn_array = getReqName().split("/");
        String method_name = qn_array[1];
        return method_name;
    }
}
