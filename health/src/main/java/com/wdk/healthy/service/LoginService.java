package com.wdk.healthy.service;

import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;

import java.util.List;

public interface LoginService {
    List<UserInfo> queryUserInfo(String username, String username1);

    List<ExpertInfo> queryExpertInfo(String username, String password);
}
