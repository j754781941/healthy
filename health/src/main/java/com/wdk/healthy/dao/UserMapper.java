package com.wdk.healthy.dao;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    Integer updateUserService(@Param("userId") String userId, @Param("path") String path);

    Integer updateUserInfoById(@Param("userInfo") UserInfo userInfo);

    List<UserInfo> selectUserInfoById(@Param("id") Long id);

    UserInfo queryUserInfoByUsername(@Param("username") String username);

    void insertChatInfo(@Param("sid") String sid, @Param("cid") String cid, @Param("msg") String msg, @Param("chatDate") String chatDate);

    List<ChatInfo> queryChatInfoByUserId(@Param("chatInfo") ChatInfo chatInfo);

    List<ChatInfo> queryUserChatInfoByUserName(@Param("username") String username);

    Integer insertUserInfoByRegister(@Param("userInfo") UserInfo userInfo);

    List<UserInfo> queryAllUserInfo();
}
