package com.wdk.healthy.dao;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpertMapper {
    List<ExpertInfo> queryIndexExpert();

    ExpertInfo queryExpertInfoById(@Param("id") Long id);

    Integer queryUserExpertGoods(@Param("userId") Long userId, @Param("expertId") Long expertId);

    Integer updateUserExpertGoods(@Param("userId") Long userId, @Param("expertId") Long expertId, @Param("goods") Integer goods);

    Integer insertUserExpertGoods(@Param("userId") Long userId, @Param("expertId") Long expertId, @Param("goods") Integer goods);

    Integer queryGoodsById(@Param("id") Long id);

    Integer queryGoodFlag(@Param("userId") Long userId, @Param("expertId") Long expertId);

    Integer insertExpertInfo(@Param("expertInfo") ExpertInfo expertInfo);

    ExpertInfo queryExpertInfoByUsername(@Param("username") String username);

    List<ExpertInfo> queryAllExperts();

    List<ExpertInfo> queryUserGood(@Param("id") Long id);

    List<ChatInfo> queryChatInfoByExpertName(String username);

    Integer insertExpertInfoByRegister(@Param("expertInfo") ExpertInfo expertInfo);

    List<UserInfo> queryExpertGood(Long id);
}
