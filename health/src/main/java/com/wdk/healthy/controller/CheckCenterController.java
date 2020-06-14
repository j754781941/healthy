package com.wdk.healthy.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wdk.healthy.pojo.ChatInfo;
import com.wdk.healthy.pojo.ExpertInfo;
import com.wdk.healthy.pojo.MessageInfo;
import com.wdk.healthy.pojo.UserInfo;
import com.wdk.healthy.server.WebSocketServer;
import com.wdk.healthy.service.ExpertService;
import com.wdk.healthy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    @Autowired
    private ExpertService expertService;

    @Autowired
    private UserService userService;

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}/{message}")
    public String pushToWeb(@PathVariable String cid,@PathVariable String message) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(message);
            String sid = jsonObject.getString("from");
            String msg = jsonObject.getString("info");
            String[] obj = sid.split("&");
            String imgUrl = "";
            String name = "";
            String chatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(obj[0]+"-----"+obj[1]);
            if("expert".equals(obj[0])){
                ExpertInfo expertInfo = expertService.queryExpertInfoByUsername(obj[1]);
                imgUrl = expertInfo.getImg();
                name = expertInfo.getName();
            }else{
                UserInfo userInfo = userService.queryUserInfoByUsername(obj[1]);
                imgUrl = userInfo.getImg();
                name = userInfo.getName();
            }
            MessageInfo messageInfo = new MessageInfo(imgUrl,msg,chatDate,name,sid);
            Object msgObj = JSONArray.toJSON(messageInfo);
            String json = msgObj.toString();
            WebSocketServer.sendInfo(json,cid);
            userService.insertChatInfo(sid,cid,msg,chatDate);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }

    //查询此用户的历史消息
    @ResponseBody
    @RequestMapping("/socket/queryChatInfoByUserId")
    public List<ChatInfo> queryChatInfoByUserId(@RequestBody ChatInfo chatInfo){
        List<ChatInfo> chatInfos = new ArrayList<>();
        chatInfos = userService.queryChatInfoByUserId(chatInfo);
        return chatInfos;
    }

    @ResponseBody
    @RequestMapping("/socket/pushAll")
    public String pushAll(String message) {
        try {
            WebSocketServer.sendInfo(message,null);
        } catch (IOException e) {
            e.printStackTrace();
            return "all#"+e.getMessage();
        }
        return "all";
    }
}
