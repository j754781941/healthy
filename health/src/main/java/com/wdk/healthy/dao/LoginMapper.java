package com.wdk.healthy.dao;

import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    List<UserInfo> queryUserInfo(@Param("username") String username, @Param("password") String password);

    List<ExpertInfo> queryExpertInfo(@Param("username") String username, @Param("password") String password);
}
