package com.java.code.study.redis;

import com.java.code.study.redis.repository.RedisRepository;
import com.java.code.study.redis.repository.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhxiaoming1988@163.com
 * @description
 * @date 2020/1/20 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private RedisRepository redisRepository;

    @Test
    public void saveUserInfoTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1024L);
        userInfo.setName("程序员");
        userInfo.setAge(30);
        userInfo.setSex(1);
        userInfo.setMobile("13096853210");

        redisRepository.saveUserInfo(userInfo);
    }

    @Test
    public void getUserInfoTest() {
        redisRepository.getUserInfo(1024L);
    }

    @Test
    public void deleteUserInfoTest() {
        redisRepository.deleteUserInfo(1024L);
    }

}
