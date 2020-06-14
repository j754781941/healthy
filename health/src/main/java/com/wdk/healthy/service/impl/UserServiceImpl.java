package com.wdk.healthy.service.impl;

import com.wdk.healthy.dao.UserMapper;
import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    @Override
    public Integer updateUserService(String userId, String path) {
        Integer integer = userMapper.updateUserService(userId, path);
        return integer
                ;
    }

    @Override
    public Integer updateUserInfoById(UserInfo userInfo) {
        Integer flag = userMapper.updateUserInfoById(userInfo);
        return flag;
    }

    @Override
    public List<UserInfo> selectUserInfoById(Long id) {
        List<UserInfo> userInfos = userMapper.selectUserInfoById(id);
        return userInfos;
    }

    @Override
    public UserInfo queryUserInfoByUsername(String username) {
        return userMapper.queryUserInfoByUsername(username);
    }

    @Override
    public void insertChatInfo(String sid, String cid, String msg, String chatDate) {
        userMapper.insertChatInfo(sid,cid,msg,chatDate);
    }

    @Override
    public List<ChatInfo> queryChatInfoByUserId(ChatInfo chatInfo) {
        return userMapper.queryChatInfoByUserId(chatInfo);
    }

    @Override
    public List<ChatInfo> queryUserChatInfoByUserName(String username) {
        return userMapper.queryUserChatInfoByUserName(username);
    }

    @Override
    public Integer insertUserInfoByRegister(UserInfo userInfo) {
        return userMapper.insertUserInfoByRegister(userInfo);
    }

    @Override
    public List<UserInfo> queryAllUserInfo() {
        return userMapper.queryAllUserInfo();
    }
}
