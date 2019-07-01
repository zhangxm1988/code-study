package com.java.code.study.designpatterns.creational.prototype;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 16:43
 */
public class Square extends Shape {

  public Square() {
    type = "square";
  }

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }

}
