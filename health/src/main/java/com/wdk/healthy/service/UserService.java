package com.wdk.healthy.service;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.UserInfo;

import java.util.List;

public interface UserService {


    Integer updateUserService(String userId, String path);

    Integer updateUserInfoById(UserInfo userInfo);

    List<UserInfo> selectUserInfoById(Long id);

    UserInfo queryUserInfoByUsername(String username);

    void insertChatInfo(String sid, String cid, String msg, String chatDate);

    List<ChatInfo> queryChatInfoByUserId(ChatInfo chatInfo);

    List<ChatInfo> queryUserChatInfoByUserName(String username);

    Integer insertUserInfoByRegister(UserInfo userInfo);

    List<UserInfo> queryAllUserInfo();
}
