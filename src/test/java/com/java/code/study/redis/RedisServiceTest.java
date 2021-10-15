package com.java.code.study.redis;

import com.java.code.study.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhxiaoming1988@163.com
 * @description
 * @date 2020/1/19 15:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void setTest() {
        String key = "hello";
        String value = "redis";
        //redisService.set(key, value);
        redisService.delKey(key);
    }

}
