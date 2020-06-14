package com.wdk.healthy.service;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserExpertGoods;
import com.wdk.healthy.pojo.UserInfo;

import java.util.List;

public interface ExpertService {
    List<ExpertInfo> queryIndexExpert();

    ExpertInfo queryExpertInfoById(Long id);

    Integer updateUserExpertGoods(UserExpertGoods userExpertGoods);

    Integer queryGoodFlag(Long userId, Long expertId);

    Integer insertExpertInfo(ExpertInfo expertInfo);

    ExpertInfo queryExpertInfoByUsername(String username);

    List<ExpertInfo> queryAllExperts();

    List<ExpertInfo> queryUserGood(Long id);

    List<ChatInfo> queryChatInfoByExpertName(String username);

    Integer insertExpertInfoByRegister(ExpertInfo expertInfo);

    List<UserInfo> queryExpertGood(Long id);
}
