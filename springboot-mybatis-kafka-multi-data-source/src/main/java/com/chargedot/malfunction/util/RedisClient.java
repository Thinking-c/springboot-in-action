package com.chargedot.malfunction.util;

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
public class RedisClient {

    @Autowired
    private JedisPool jedisPool;

    public void hset(String key,String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key,field, value);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    public String hget(String key,String field) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key,field);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }  finally {
            //返还到连接池
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
            e.printStackTrace();
            return false;
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    @SuppressWarnings("deprecation")
    public long expire(String key, int seconds)  {
        Jedis jedis = null;
        long ret =0;
        try {
            jedis = jedisPool.getResource();
            ret = jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return ret;
    }
}
