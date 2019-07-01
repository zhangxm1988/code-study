package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description 圆形
 * @create 2019-06-28 16:40
 */
public class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }

}
