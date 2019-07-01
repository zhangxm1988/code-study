package com.java.code.study.designpatterns.creational.prototype;

/**
 * @author zhangxm
 * @description 长方形
 * @create 2019-06-28 16:42
 */
public class Rectangle extends Shape {

  public Rectangle() {
    type = "rectangle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }

}
