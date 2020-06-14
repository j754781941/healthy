package com.wdk.healthy.service.impl;

import com.wdk.healthy.dao.LoginMapper;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<UserInfo> queryUserInfo(final String username, String password) {
        List<UserInfo> userInfos = loginMapper.queryUserInfo(username,password);
        return userInfos;
    }

    @Override
    public List<ExpertInfo> queryExpertInfo(String username, String password) {
        List<ExpertInfo> expertInfos = loginMapper.queryExpertInfo(username,password);
        return expertInfos;
    }
}
