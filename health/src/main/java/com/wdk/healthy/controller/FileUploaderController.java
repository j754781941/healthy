package com.wdk.healthy.controller;

import com.wdk.healthy.service.UserService;
import com.wdk.healthy.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/fileUploaderControl")
public class FileUploaderController {

    @Autowired
    private UserService userService;
    /**
     * 上传用户头像
     */
    @RequestMapping(value="/uploadUserImg", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Integer> images(@RequestParam("userId") String userId,@RequestParam("file") MultipartFile file){
        Map<String,Integer> map = new HashMap<>();
        System.out.println("file:"+file);
        System.out.println("userId:"+userId);
        String path = "/root/img/user/"+ userId +file.getOriginalFilename();
        File targetFile = new File(path);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            map.put("status",500);
            e.printStackTrace();
        }
        Integer flag = userService.updateUserService(userId,"user/" + userId +file.getOriginalFilename());
        if(flag > 0){
            map.put("status",200);
        }else{
            map.put("status",500);
        }
        return map;
    }

    /**
     * 上传专家头像
     */
    @RequestMapping(value="/uploadExpertImg", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Integer> expertImages(@RequestParam("userId") String expertId,@RequestParam("file") MultipartFile file){
        Map<String,Integer> map = new HashMap<>();
        System.out.println("file:"+file);
        System.out.println("expertId:"+expertId);
        String path = "/root/img/expert/"+ expertId +file.getOriginalFilename();
        File targetFile = new File(path);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            map.put("status",500);
            e.printStackTrace();
        }
        Integer flag = userService.updateUserService(expertId,"expert/" + expertId +file.getOriginalFilename());
        if(flag > 0){
            map.put("status",200);
        }else{
            map.put("status",500);
        }
        return map;
    }

}
