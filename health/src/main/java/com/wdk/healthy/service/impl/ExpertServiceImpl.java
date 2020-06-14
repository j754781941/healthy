package com.wdk.healthy.service.impl;

import com.wdk.healthy.dao.ExpertMapper;
import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserExpertGoods;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    public ExpertServiceImpl() {
    }

    @Override
    public List<ExpertInfo> queryIndexExpert() {
        List<ExpertInfo> expertInfos = expertMapper.queryIndexExpert();
        return expertInfos;
    }

    @Override
    public ExpertInfo queryExpertInfoById(Long id) {
        ExpertInfo expertInfo = expertMapper.queryExpertInfoById(id);
        expertInfo.setGood(expertMapper.queryGoodsById(id));
        return expertInfo;
    }

    @Override
    public Integer updateUserExpertGoods(UserExpertGoods userExpertGoods) {
        Integer good = expertMapper.queryUserExpertGoods(userExpertGoods.getUserId(),userExpertGoods.getExpertId());
        Integer goods = 1;
        Integer flag = 0;
        if(good != null){
            if(good == 0){
                flag = expertMapper.updateUserExpertGoods(userExpertGoods.getUserId(),userExpertGoods.getExpertId(),goods);
            }else{
                goods = 0;
                flag = expertMapper.updateUserExpertGoods(userExpertGoods.getUserId(),userExpertGoods.getExpertId(),goods);
            }
        }else{
            flag = expertMapper.insertUserExpertGoods(userExpertGoods.getUserId(),userExpertGoods.getExpertId(),goods);
        }
        return flag;
    }

    @Override
    public Integer queryGoodFlag(Long userId, Long expertId) {
        Integer flag = expertMapper.queryGoodFlag(userId,expertId);
        return flag;
    }

    @Override
    public Integer insertExpertInfo(ExpertInfo expertInfo) {
        Integer flag = expertMapper.insertExpertInfo(expertInfo);
        return flag;
    }

    @Override
    public ExpertInfo queryExpertInfoByUsername(String username) {
        return expertMapper.queryExpertInfoByUsername(username);
    }

    @Override
    public List<ExpertInfo> queryAllExperts() {
        return expertMapper.queryAllExperts();
    }

    @Override
    public List<ExpertInfo> queryUserGood(Long id) {
        return expertMapper.queryUserGood(id);
    }

    @Override
    public List<ChatInfo> queryChatInfoByExpertName(String username) {
        return expertMapper.queryChatInfoByExpertName(username);
    }

    @Override
    public Integer insertExpertInfoByRegister(ExpertInfo expertInfo) {
        return expertMapper.insertExpertInfoByRegister(expertInfo);
    }

    @Override
    public List<UserInfo> queryExpertGood(Long id) {
        return expertMapper.queryExpertGood(id);
    }
}
