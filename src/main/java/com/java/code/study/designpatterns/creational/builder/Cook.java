package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:45
 */
public class Cook extends ColdDrink {

  @Override
  public String name() {
    return "cook";
  }

  @Override
  public float price() {
    return 10.0f;
  }

}
