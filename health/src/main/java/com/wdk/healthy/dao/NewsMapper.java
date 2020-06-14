package com.wdk.healthy.dao;

import com.wdk.healthy.pojo.NewsInfo;

import java.util.List;

public interface NewsMapper {
    List<NewsInfo> getNews();

    String queryStringNews();
}
