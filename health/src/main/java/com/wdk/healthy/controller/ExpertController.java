package com.wdk.healthy.controller;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserExpertGoods;
import com.wdk.healthy.service.ExpertService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @RequestMapping("/queryIndexExpert")
    @ResponseBody
    public List<ExpertInfo> queryIndexExpert(){
        List<ExpertInfo> expertInfos = expertService.queryIndexExpert();
        return expertInfos;
    }

    @RequestMapping("/queryExpertInfoById")
    @ResponseBody
    public ExpertInfo queryExpertInfoById(@RequestBody ExpertInfo expertInfos){
        ExpertInfo expertInfo = new ExpertInfo();
        Long id = expertInfos.getId();
        if(id != null){
            System.out.println(id);
            expertInfo = expertService.queryExpertInfoById(id);
            System.out.println(expertInfo.getId());
        }else{
            return expertInfos;
        }

        return expertInfo;
    }

    @RequestMapping("/updateUserExpertGoods")
    @ResponseBody
    public Map<String,Integer> updateUserExpertGoods(@RequestBody UserExpertGoods userExpertGoods){
//        System.out.println(userExpertGoods.getUserId() + "---" + userExpertGoods.getExpertId());
        Map<String,Integer> map = new HashMap<>();
        if(userExpertGoods.getUserId() == null || userExpertGoods.getExpertId() == null){
            map.put("flag",-1);
        }else{
            Integer flag = expertService.updateUserExpertGoods(userExpertGoods);
            if(flag > 0){
                map.put("flag",1);
            }else{
                map.put("flag",0);
            }
        }
        return map;
    }

    @RequestMapping("/queryGoodFlag")
    @ResponseBody
    public Map<String,Integer> queryGoodFlag(@RequestBody UserExpertGoods userExpertGoods){
        Map<String,Integer> map = new HashMap<>();
        if(userExpertGoods.getUserId() == null || userExpertGoods.getExpertId() == null){
            map.put("flag",-1);
        }else{
            Integer flag = expertService.queryGoodFlag(userExpertGoods.getUserId(),userExpertGoods.getExpertId());
            if(flag > 0){
                map.put("flag",1);
            }else{
                map.put("flag",0);
            }
        }
        return map;
    }

    @RequestMapping("/insertExpertInfo")
    @ResponseBody
    public Map<String,Integer> insertExpertInfo(@RequestBody ExpertInfo expertInfo){
        Map<String,Integer> map = new HashMap<>();
        System.out.println("expertInfo----->"+(expertInfo==null));
        if( expertInfo == null ){
            map.put("flag",-1);
        }else{
            Integer flag = expertService.insertExpertInfo(expertInfo);
            System.out.println("flag---->"+flag);
            if(flag > 0){
                map.put("flag",1);
            }else{
                map.put("flag",-1);
            }
        }
        return map;
    }


    @RequestMapping("/queryAllExperts")
    @ResponseBody
    public List<ExpertInfo> queryAllExperts(){
        List<ExpertInfo> expertInfos = expertService.queryAllExperts();
        return expertInfos;
    }

    /**
     * 初始化专家界面消息
     */
    @RequestMapping("/queryChatInfoByExpertName")
    @ResponseBody
    public List<ChatInfo> queryChatInfoByExpertName(@RequestBody ExpertInfo expertInfo){
        List<ChatInfo> chatInfos = expertService.queryChatInfoByExpertName(expertInfo.getUsername());
        //进行格式整理，让from和to保持一致
        for(int i=0;i<chatInfos.size();i++){
            String str;
            if(!chatInfos.get(i).getFrom().equals(expertInfo.getUsername())){
                str = chatInfos.get(i).getFrom();
                chatInfos.get(i).setFrom(chatInfos.get(i).getTo());
                chatInfos.get(i).setTo(str);
            }
        }
        //去掉重复的
        for(int i=0;i<chatInfos.size();i++){
            for(int j=i+1;j<chatInfos.size();j++){
                if(chatInfos.get(i).getTo().equals(chatInfos.get(j).getTo())){
                    chatInfos.remove(i);
                }
            }
        }
        for(int i=0;i<chatInfos.size();i++){
            ExpertInfo expertInfos = expertService.queryExpertInfoByUsername(chatInfos.get(i).getTo().substring(7));
            chatInfos.get(i).setUsername(expertInfos.getName());
            chatInfos.get(i).setFrom(expertInfos.getImg());
        }
        return chatInfos;
    }

    @RequestMapping("/insertExpertInfoByRegister")
    @ResponseBody
    public Map<String,Integer> insertExpertInfoByRegister(@RequestBody ExpertInfo expertInfo){
        Map<String,Integer> map = new HashMap<>();
        map.put("flag",0);
        Integer flag = expertService.insertExpertInfoByRegister(expertInfo);
        if(flag>0){
            map.put("flag",1);
        }
        return map;
    }
}
