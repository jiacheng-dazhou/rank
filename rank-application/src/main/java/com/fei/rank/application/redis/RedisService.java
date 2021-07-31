package com.fei.rank.application.redis;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisService {
    ValueOperations value();

    HashOperations hash();

    ListOperations list();

    SetOperations set();

    ZSetOperations zSet();

    RedisTemplate template();

    ValueOperations value(String var1);

    HashOperations hash(String var1);

    ListOperations list(String var1);

    SetOperations set(String var1);

    ZSetOperations zSet(String var1);

    RedisTemplate template(String var1);
}
