package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:46
 */
public class Pepsi extends ColdDrink {

  @Override
  public String name() {
    return "pepsi";
  }

  @Override
  public float price() {
    return 12.0f;
  }

}
