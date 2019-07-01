package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:41
 */
public abstract class ColdDrink implements Item {

  @Override
  public Packing packing() {
    return new Bottle();
  }

  @Override
  public abstract float price();

}
