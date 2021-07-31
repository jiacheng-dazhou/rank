package com.fei.rank.application.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fei.rank.application.redis.impl.SingleJedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class SessionRedisConfig
{
    @Bean(name = "rankRedis")
    public SingleJedisTemplate singleJedisTemplate(
            @Value("${redis.session.hostName}") String hostName,
            @Value("${redis.session.port}") int port,
            @Value("${redis.session.password}") String password,
            @Value("${redis.session.maxIdle}") int maxIdle,
            @Value("${redis.session.maxTotal}") int maxTotal,
            @Value("${redis.session.index}") int index,
            @Value("${redis.session.maxWaitMillis}") long maxWaitMillis,
            @Value("${redis.session.testOnBorrow}") boolean testOnBorrow
    )
    {
        SingleJedisTemplate singleJedisTemplate = new SingleJedisTemplate();
        singleJedisTemplate.setRedisTemplate(getRedisTemplate(hostName, port, password, maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));
        return singleJedisTemplate;
    }

    public RedisTemplate getRedisTemplate(String hostName, int port,
                                          String password, int maxIdle, int maxTotal, int index,
                                          long maxWaitMillis, boolean testOnBorrow)
    {
        RedisTemplate redisTemplate = new RedisTemplate();
        /*<property name="connectionFactory" ref="adminJedisConnectionFactory"/>
                <property name="keySerializer">
                    <bean class="org.springframework.data.redis.serializer.StringRedisSerializer">
                        <constructor-arg name="charset" value="UTF-8"/>
                    </bean>
                </property>
                <property name="valueSerializer">
                    <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
                </property>
                */
        redisTemplate.setConnectionFactory(connectionFactory(hostName, port, password, maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));

        //设置序列化方式
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(redisSerializer);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //设置value和hashValue的序列化方式。
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /*@Bean(name = "redis123Template")
    public StringRedisTemplate getRedisTemplate(
            @Value("${redis123.hostName}") String hostName,
            @Value("${redis123.port}") int port,
            @Value("${redis123.password}") String password,
            @Value("${redis123.maxIdle}") int maxIdle,
            @Value("${redis123.maxTotal}") int maxTotal,
            @Value("${redis123.index}") int index,
            @Value("${redis123.maxWaitMillis}") long maxWaitMillis,
            @Value("${redis123.testOnBorrow}") boolean testOnBorrow)
    {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password, maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));
        return temple;
    }*/

    public RedisConnectionFactory connectionFactory(String hostName, int port,
                                                    String password, int maxIdle, int maxTotal, int index,
                                                    long maxWaitMillis, boolean testOnBorrow)
    {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        jedis.setHostName(hostName);
        jedis.setPort(port);
        if (!StringUtils.isEmpty(password))
        {
            jedis.setPassword(password);
        }
        if (index != 0)
        {
            jedis.setDatabase(index);
        }
        jedis.setPoolConfig(poolCofig(maxIdle, maxTotal, maxWaitMillis, testOnBorrow));
        // 初始化连接pool
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;

        return factory;
    }

    public JedisPoolConfig poolCofig(int maxIdle, int maxTotal, long maxWaitMillis, boolean testOnBorrow)
    {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWaitMillis);
        poolCofig.setTestOnBorrow(testOnBorrow);
        return poolCofig;
    }
}
