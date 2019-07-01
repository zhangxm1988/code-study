package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description 瓶子
 * @create 2019-07-01 10:38
 */
public class Bottle implements Packing {

  @Override
  public String pack() {
    return "bottle";
  }

}
