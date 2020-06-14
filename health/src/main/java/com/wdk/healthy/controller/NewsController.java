package com.wdk.healthy.controller;

import com.alibaba.fastjson.JSONObject;
import com.wdk.healthy.pojo.NewsInfo;
import com.wdk.healthy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/getNews")
    @ResponseBody
    public List<NewsInfo> getNews(){
        List<NewsInfo> newsInfoList = newsService.getNews();
//        System.out.println(newsInfoList);
        String json = JSONObject.toJSONString(newsInfoList);
        System.out.println(json);
        newsInfoList = (List<NewsInfo>) JSONObject.parse(json);
        return newsInfoList;
    }

    @RequestMapping("/getStringNews")
    @ResponseBody
    public Map<String,String> getStringNews(){
        Map<String,String> map = new HashMap<>();
        String news = newsService.getStringNews();
        map.put("news",news);
        return map;
    }
}
