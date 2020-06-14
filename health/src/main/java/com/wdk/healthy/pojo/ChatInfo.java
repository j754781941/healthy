package com.wdk.healthy.pojo;

import java.io.Serializable;

public class ChatInfo implements Serializable {
    private Long id;
    private String from;
    private String to;
    private String createDate;
    private String msg;
    private String username;

    public ChatInfo() {
    }

    public ChatInfo(Long id, String from, String to, String createDate, String msg, String username) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.createDate = createDate;
        this.msg = msg;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
