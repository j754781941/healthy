package com.wdk.healthy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 5615993073235050890L;
    private String name;
    private String username;
    private String password;
    private Long id;
    private String tele;
    private String sex;
    private String email;
    private String qq;
    private Date createDate;
    private String img;
    private Integer age;

    public UserInfo() {
    }

    public UserInfo(String name, String username, String password, Long id, String tele, String sex, String email, String qq, Date createDate, String img, Integer age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
        this.tele = tele;
        this.sex = sex;
        this.email = email;
        this.qq = qq;
        this.createDate = createDate;
        this.img = img;
        this.age = age;
    }

    public UserInfo(String name, String username, String password, String tele, String sex, String email, String qq, Integer age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.tele = tele;
        this.sex = sex;
        this.email = email;
        this.qq = qq;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
