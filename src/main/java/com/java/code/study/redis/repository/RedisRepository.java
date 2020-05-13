package com.java.code.study.redis.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author xiaoming.zhang@zhiyoubao.com
 * @description
 * @date 2020/1/20 14:22
 */
@Service
public class RedisRepository {

    @Cacheable(value = "redisCache", key = "'redis_user_'+#id", condition = "#result !=''")
    public UserInfo getUserInfo(Long id) {

        return null;
    }

    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    public UserInfo saveUserInfo(UserInfo userInfo) {

        // TODO 保存数据库

        return userInfo;
    }

    @CacheEvict(value = "redisCache", key = "'redis_user_'+#id", beforeInvocation = false)
    public void deleteUserInfo(Long id) {
        // TODO 数据库数据删除
    }

}
