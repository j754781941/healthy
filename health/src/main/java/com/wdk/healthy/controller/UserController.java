package com.wdk.healthy.controller;

import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.service.ExpertService;
import com.wdk.healthy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExpertService expertService;

    @RequestMapping("/updateUserInfoById")
    @ResponseBody
    public Map<String,String> updateUserInfoById(@RequestBody UserInfo userInfo){
        Map<String,String> map = new HashMap<>();
        if(userInfo != null){
            Integer flag = userService.updateUserInfoById(userInfo);
            if( flag > 0 ){
                map.put("flag","1");
            }else{
                map.put("flag","-1");
            }
        }else{
            map.put("flag","-1");
        }
        return map;
    }

    @RequestMapping("/selectUserInfoById")
    @ResponseBody
    public UserInfo selectUserInfoById(@RequestBody UserInfo userInfo){
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos = userService.selectUserInfoById(userInfo.getId());
        return userInfos.get(0);
    }

    /**
     * 根据用户Id查找用户聊天信息
     */
    @RequestMapping("/queryUserChatInfoByUserName")
    @ResponseBody
    public List<ChatInfo> queryUserChatInfoByUserName(@RequestBody UserInfo userInfo){
        List<ChatInfo> chatInfos = userService.queryUserChatInfoByUserName(userInfo.getUsername());
        for(int i=0;i<chatInfos.size();i++){
            String str;
            if(!chatInfos.get(i).getFrom().equals(userInfo.getUsername())){
                str = chatInfos.get(i).getFrom();
                chatInfos.get(i).setFrom(chatInfos.get(i).getTo());
                chatInfos.get(i).setTo(str);
            }
        }
        for(int i=0;i<chatInfos.size();i++){
            for(int j=i;j<chatInfos.size();j++){
                if(j != i){
                    if(chatInfos.get(i).getTo().equals(chatInfos.get(j).getTo())){
                        chatInfos.remove(i);
                    }
                }
            }
        }
        for(int i=0;i<chatInfos.size();i++){
            String username;
            String from;
            Long id;
            if(chatInfos.get(i).getTo().contains("expert&")){
                ExpertInfo expertInfo = expertService.queryExpertInfoByUsername(chatInfos.get(i).getTo().substring(7));
                username = expertInfo.getName();
                from = expertInfo.getImg();
                id = expertInfo.getId();
            }else{
                UserInfo userInfo1 = userService.queryUserInfoByUsername(chatInfos.get(i).getTo().substring(5));
                username = userInfo1.getName();
                from = userInfo1.getImg();
                id = userInfo1.getId();
            }
            chatInfos.get(i).setUsername(username);
            chatInfos.get(i).setFrom(from);
            chatInfos.get(i).setId(id);
        }
        return chatInfos;
    }

    /**
     * 我的赞界面功能
     */
    @RequestMapping("/queryUserGood")
    @ResponseBody
    public List<ExpertInfo> queryUserGood(@RequestBody UserInfo userInfo){
        List<ExpertInfo> expertInfos = expertService.queryUserGood(userInfo.getId());
        return expertInfos;
    }

    /**
     * 赞我的界面功能
     */
    @RequestMapping("/queryExpertGood")
    @ResponseBody
    public List<UserInfo> queryExpertGood(@RequestBody ExpertInfo expertInfo){
        List<UserInfo> userInfos = expertService.queryExpertGood(expertInfo.getId());
        return userInfos;
    }

    /**
     * 用户注册功能
     */
    @RequestMapping(value = "/insertUserInfoByRegister")
    @ResponseBody
    public Map<String,Integer> insertUserInfoByRegister(@RequestBody  UserInfo userInfo){
        Map<String,Integer> map = new HashMap<>();
        map.put("flag",0);
        Integer flag = userService.insertUserInfoByRegister(userInfo);
        if(flag > 0){
            map.put("flag",1);
        }
        return map;
    }

    /**
     * 查询全部用户
     */
    @RequestMapping("/queryAllUserInfo")
    @ResponseBody
    public List<UserInfo> queryAllUserInfo(){
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos = userService.queryAllUserInfo();
        return userInfos;
    }
}
