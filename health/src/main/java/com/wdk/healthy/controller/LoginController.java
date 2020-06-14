package com.wdk.healthy.controller;

import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public Map<String,String> userLogin(@RequestBody UserInfo userInfo){
        Map<String,String> map = new HashMap<>();
        List<UserInfo> flag = loginService.queryUserInfo(userInfo.getUsername(),userInfo.getPassword());
        System.out.println(userInfo.getPassword());
        System.out.println(userInfo.getUsername());
        if(flag.size() > 0){
            map.put("flag",String.valueOf(1));
            map.put("userId",String.valueOf(Integer.parseInt(flag.get(0).getId().toString())));
            map.put("name",flag.get(0).getName());
            map.put("tele",flag.get(0).getTele());
            map.put("email",flag.get(0).getEmail());
            map.put("qq",flag.get(0).getQq());
            map.put("username",flag.get(0).getUsername());
            map.put("password",flag.get(0).getPassword());
            map.put("age",flag.get(0).getAge().toString());
            map.put("sex",flag.get(0).getSex());
            map.put("img",flag.get(0).getImg());
        }else{
            map.put("flag",String.valueOf(-1));
        }
        return map;
    }

    @RequestMapping("/expertLogin")
    @ResponseBody
    public Map<String,String> userLogin(@RequestBody ExpertInfo expertInfo){
        Map<String,String> map = new HashMap<>();
        List<ExpertInfo> expertInfos = loginService.queryExpertInfo(expertInfo.getUsername(),expertInfo.getPassword());
        if(expertInfos.size() > 0){
            map.put("flag",String.valueOf(2));
            map.put("sex",expertInfos.get(0).getSex());
            map.put("name",expertInfos.get(0).getName());
            map.put("tele",expertInfos.get(0).getTele());
            map.put("email",expertInfos.get(0).getEmail());
            map.put("qq",expertInfos.get(0).getQq());
            map.put("username",expertInfos.get(0).getUsername());
            map.put("password",expertInfos.get(0).getPassword());
            map.put("img",expertInfos.get(0).getImg());
            map.put("content",expertInfos.get(0).getContent());
            map.put("address",expertInfos.get(0).getAddress());
            map.put("designation",expertInfos.get(0).getDesignation());
            map.put("id",expertInfos.get(0).getId().toString());
        }else{
            map.put("flag",String.valueOf(-1));
        }
        return map;
    }
}
