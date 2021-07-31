package com.fei.rank.application.redis.impl;

import com.fei.rank.application.redis.RedisProxy;
import com.fei.rank.application.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

@Repository("defaultRedisService")
public class JedisTemplate implements RedisService {
    @Autowired
    private RedisProxy redisProxy;

    private String defaultRedisKey = "default";

    public JedisTemplate() {
    }

    public JedisTemplate(String redisKey) {
        this.defaultRedisKey = redisKey;
    }

    public RedisProxy getRedisProxy() {
        return this.redisProxy;
    }

    public ValueOperations value() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey).opsForValue();
    }

    public HashOperations hash() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey).opsForHash();
    }

    public ListOperations list() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey).opsForList();
    }

    public SetOperations set() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey).opsForSet();
    }

    public ZSetOperations zSet() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey).opsForZSet();
    }

    public RedisTemplate template() {
        return this.redisProxy.getRedisTemplate(this.defaultRedisKey);
    }

    public HashOperations hash(String key) {
        return this.redisProxy.getRedisTemplate(key).opsForHash();
    }

    public ValueOperations value(String key) {
        return this.redisProxy.getRedisTemplate(key).opsForValue();
    }

    public ListOperations list(String key) {
        return this.redisProxy.getRedisTemplate(key).opsForList();
    }

    public SetOperations set(String key) {
        return this.redisProxy.getRedisTemplate(key).opsForSet();
    }

    public ZSetOperations zSet(String key) {
        return this.redisProxy.getRedisTemplate(key).opsForZSet();
    }

    public RedisTemplate template(String key) {
        return this.redisProxy.getRedisTemplate(key);
    }

    public boolean acquireLock(final String lockName, final long expire) {
        final RedisTemplate redisTemplate = this.template();
        return (Boolean)redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) {
                try {
                    byte[] lockBytes = redisTemplate.getStringSerializer().serialize(lockName);
                    boolean locked = connection.setNX(lockBytes, lockBytes);
                    if (locked) {
                        connection.expire(lockBytes, expire);
                        Boolean var4 = true;
                        return var4;
                    }
                } finally {
                    connection.close();
                }

                return false;
            }
        });
    }

    public void releaseLock(String lockName) {
        RedisTemplate redisTemplate = this.template();
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

        try {
            connection.del(new byte[][]{lockName.getBytes()});
        } finally {
            connection.close();
        }

    }
}
