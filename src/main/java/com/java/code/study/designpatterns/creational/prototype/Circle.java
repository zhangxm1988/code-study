package com.java.code.study.designpatterns.creational.prototype;

/**
 * @author zhangxm
 * @description 圆形
 * @create 2019-06-28 16:40
 */
public class Circle extends Shape {

  public Circle() {
    type = "circle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }

}
