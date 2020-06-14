package com.wdk.healthy.pojo;

public class MessageInfo {
    private String imgUrl;
    private String msg;
    private String chatDate;
    private String name;
    private String username;

    public MessageInfo(String imgUrl, String msg, String chatDate, String name, String username) {
        this.imgUrl = imgUrl;
        this.msg = msg;
        this.chatDate = chatDate;
        this.name = name;
        this.username = username;
    }


    public MessageInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
