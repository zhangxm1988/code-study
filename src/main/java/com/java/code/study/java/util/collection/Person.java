package com.java.code.study.java.util.collection;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-20 14:06
 */
@Getter @Setter
public class Person {

  private String id;
  private String name;

  public Person(String id, String name) {
    this.id = id;
    this.name = name;
  }

}
