package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:44
 */
public class ChickenBurger extends Burger {

  @Override
  public String name() {
    return "chicken burger";
  }

  @Override
  public float price() {
    return 50.0f;
  }

}
