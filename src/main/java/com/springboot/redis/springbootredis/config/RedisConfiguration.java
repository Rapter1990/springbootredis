package com.springboot.redis.springbootredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfiguration {

    // Connection type
    private static final String CONNECTION_TYPE = "localhost";

    // Connection Port Number
    private static final int CONNECTION_PORT_NUMBER = 6379;

    // Define factory to connect redis with its connection type and port number (Inversion of Control(IOC))
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(CONNECTION_TYPE, CONNECTION_PORT_NUMBER);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    // Connect to redis directly (Inversion of Control(IOC))
    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
