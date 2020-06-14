package com.wdk.healthy.service;

import com.wdk.healthy.pojo.NewsInfo;

import java.util.List;

public interface NewsService {
    List<NewsInfo> getNews();

    String getStringNews();
}
