package com.thinking.springbootincation.project;

import com.thinking.springbootincation.project.system.test.domain.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisSet(){
        redisTemplate.opsForValue().set("test:redisTemplate", "testValue");
        stringRedisTemplate.opsForValue().set("test:StringRedisTemplate", "testValue1");
        stringRedisTemplate.opsForValue().set("test:StringRedisTemplate1", "我是谁，你是谁。");

        Object redisTemplateTest = redisTemplate.opsForValue().get("test:redisTemplate");
        System.out.println("test:redisTemplate:" + redisTemplateTest);

        String stringRedisTemplateTest = stringRedisTemplate.opsForValue().get("test:StringRedisTemplate");
        System.out.println("test:StringRedisTemplate:" + stringRedisTemplateTest);

        String stringRedisTemplateTest1 = stringRedisTemplate.opsForValue().get("test:StringRedisTemplate1");
        System.out.println("test:StringRedisTemplate:" + stringRedisTemplateTest1);
    }

    @Test
    public void redisTemplateTest(){

        TestUser testUser = new TestUser();
        testUser.setId(1);
        testUser.setPassword("12356");
        testUser.setUsername("redisTemplate");

        redisTemplate.opsForValue().set("testUser", testUser.toString());

        System.out.println(redisTemplate.opsForValue().get("testUser"));

    }
}
