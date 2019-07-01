package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:43
 */
public class VegBurger extends Burger {

  @Override
  public String name() {
    return "veg burger";
  }

  @Override
  public float price() {
    return 25.0f;
  }

}
