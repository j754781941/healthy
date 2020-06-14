package com.wdk.healthy.pojo;

import java.io.Serializable;

public class UserExpertGoods implements Serializable {
    private static final long serialVersionUID = -6171798801123296428L;
    private Integer id;
    private Long userId;
    private Long expertId;
    private Integer good;

    public UserExpertGoods(Integer id, Long userId, Long expertId, Integer good) {
        this.id = id;
        this.userId = userId;
        this.expertId = expertId;
        this.good = good;
    }

    public UserExpertGoods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }
}
