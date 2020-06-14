package com.wdk.healthy.util;

import org.apache.http.annotation.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    RedisTemplate redisTemplate;//操作k-v为对象的

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串对象的

    @SuppressWarnings("unchecked")
    public boolean hasHashKey(Object h,Object o){
        return redisTemplate.opsForHash().hasKey(h,o);
    }

    @SuppressWarnings("unchecked")
    public Object getHashValue(Object h,Object o){
        return redisTemplate.opsForHash().get(h,o);
    }

    @SuppressWarnings("unchecked")
    public void putHash(Object h,Object hk,Object hv){
        redisTemplate.opsForHash().put(h,hk,hv);
    }


    @SuppressWarnings("ConstantConditions")
    public boolean hasStringKey(String key){
        return stringRedisTemplate.hasKey(key);
    }

    public String getStringKey(Object key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setStringValue(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public void setTimeOut(String key){
        stringRedisTemplate.expire(key,2, TimeUnit.HOURS);
    }
}
