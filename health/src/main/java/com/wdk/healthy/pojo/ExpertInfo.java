package com.wdk.healthy.pojo;

import java.util.Date;

public class ExpertInfo {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Integer age;
    private String tele;
    private String sex;
    private String email;
    private Date createDate;
    private String designation;
    private Integer good;
    private String content;
    private String address;
    private String img;
    private String qq;

    public ExpertInfo() {
    }

    public ExpertInfo(Long id, String name, String username, String password, Integer age, String tele, String sex, String email, Date createDate, String designation, Integer good, String content, String address, String img, String qq) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.tele = tele;
        this.sex = sex;
        this.email = email;
        this.createDate = createDate;
        this.designation = designation;
        this.good = good;
        this.content = content;
        this.address = address;
        this.img = img;
        this.qq = qq;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }
}
