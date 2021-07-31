package com.fei.rank.application.redis.impl;

import com.fei.rank.application.redis.RedisService;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

@Repository
public class SingleJedisTemplate implements RedisService {
    private RedisTemplate redisTemplate;

    public SingleJedisTemplate() {
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate getRedisTemplate() {
        return this.redisTemplate;
    }

    public ValueOperations value() {
        return this.redisTemplate.opsForValue();
    }

    public HashOperations hash() {
        return this.redisTemplate.opsForHash();
    }

    public ListOperations list() {
        return this.redisTemplate.opsForList();
    }

    public SetOperations set() {
        return this.redisTemplate.opsForSet();
    }

    public ZSetOperations zSet() {
        return this.redisTemplate.opsForZSet();
    }

    public RedisTemplate template() {
        return this.redisTemplate;
    }

    public ValueOperations value(String key) {
        return this.value();
    }

    public HashOperations hash(String key) {
        return this.hash();
    }

    public ListOperations list(String key) {
        return this.list();
    }

    public SetOperations set(String key) {
        return this.set();
    }

    public ZSetOperations zSet(String key) {
        return this.zSet();
    }

    public RedisTemplate template(String key) {
        return this.redisTemplate;
    }
}

