package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:39
 */
public abstract class Burger implements Item {

  @Override
  public Packing packing() {
    return new Wrapper();
  }

  @Override
  public abstract float price();
  
}
