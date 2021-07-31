package com.fei.rank.application.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RedisProxy {
    private Map<String, RedisTemplate> redisMap = new HashMap();
    private List<RedisTemplate> shareList = new ArrayList();

    public RedisProxy() {
    }

    public void setRedisMap(Map<String, RedisTemplate> redisMap) {
        this.redisMap = redisMap;
    }

    public void setShareList(List<RedisTemplate> shareList) {
        this.shareList = shareList;
    }

    public RedisTemplate getRedisTemplate(String key) {
        return (RedisTemplate)this.redisMap.get(key);
    }

    public RedisTemplate autoLoadTemplate() {
        if (this.shareList.size() > 0) {
            Collections.shuffle(this.shareList);
            return (RedisTemplate)this.shareList.get(0);
        } else {
            return null;
        }
    }
}
