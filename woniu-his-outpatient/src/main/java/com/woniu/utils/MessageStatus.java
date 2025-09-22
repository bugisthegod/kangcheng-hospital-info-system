package com.woniu.utils;

public enum MessageStatus {


    SUCCESS(1,"消息已发送"),UNSEND(0,"消息未发送");
    private MessageStatus(Integer status, String msg){
        this.status = status;
        this.msg = msg;
    }
    private Integer status;
    public Integer getStatus() {
        return status;
    }


    private String msg;
    public String getMsg() {
        return msg;
    }
}
