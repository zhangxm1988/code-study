package com.java.code.study.redis.repository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaoming.zhang@zhiyoubao.com
 * @description
 * @date 2020/1/20 14:26
 */
@Data
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    private int age;
    private int sex;
    private String mobile;

}
