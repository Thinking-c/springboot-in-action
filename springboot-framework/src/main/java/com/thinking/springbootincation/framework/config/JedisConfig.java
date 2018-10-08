package com.thinking.springbootincation.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/18
 */
@Configuration
@EnableCaching
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-active}")
    private long maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWait;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);

        return jedisPool;
    }
}
