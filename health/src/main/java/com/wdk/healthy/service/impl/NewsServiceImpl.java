package com.wdk.healthy.service.impl;

import com.wdk.healthy.dao.NewsMapper;
import com.wdk.healthy.pojo.NewsInfo;
import com.wdk.healthy.service.NewsService;
import com.wdk.healthy.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<NewsInfo> getNews() {
        List<NewsInfo> newsInfoList = newsMapper.getNews();
        return newsInfoList;
    }


    public String getStringNews(){
        String stringNews = "";
        if(redisUtil.hasStringKey("news")){
            stringNews = redisUtil.getStringKey("news");
        }else{
            stringNews = newsMapper.queryStringNews();
            redisUtil.setStringValue("news",stringNews);
            redisUtil.setTimeOut("news");
        }
        return stringNews;
    }
}
