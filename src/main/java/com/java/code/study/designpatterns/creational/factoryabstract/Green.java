package com.java.code.study.designpatterns.creational.factoryabstract;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 17:25
 */
public class Green implements Color {
  @Override
  public void fill() {
    System.out.println("Inside Green::fill() method.");
  }
}
