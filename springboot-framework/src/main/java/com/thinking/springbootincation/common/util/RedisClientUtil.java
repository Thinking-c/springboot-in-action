package com.thinking.springbootincation.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2017/11/14
 */
@Component
@Slf4j
public class RedisClientUtil {

    @Autowired
    private JedisPool jedisPool;

    public void hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            log.info("redis hset method exception happened ", e);
        } finally {
            jedis.close();
        }
    }

    public String hget(String key, String field) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key, field);
        } catch (Exception e) {
            log.info("redis hget method exception happened ", e);
            return null;
        } finally {
            jedis.close();
        }
    }

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            log.info("redis set method exception happened ", e);
        } finally {
            jedis.close();
        }
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            log.info("redis get method exception happened ", e);
            return null;
        } finally {
            jedis.close();
        }
    }

    public boolean del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            return true;
        } catch (Exception e) {
            log.info("redis del method exception happened ", e);
            return false;
        } finally {
            jedis.close();
        }
    }

    @SuppressWarnings("deprecation")
    public long expire(String key, int seconds) {
        Jedis jedis = null;
        long ret = 0;
        try {
            jedis = jedisPool.getResource();
            ret = jedis.expire(key, seconds);
        } catch (Exception e) {
            log.info("redis expire method exception happened ", e);
        } finally {
            jedis.close();
        }
        return ret;
    }
}
