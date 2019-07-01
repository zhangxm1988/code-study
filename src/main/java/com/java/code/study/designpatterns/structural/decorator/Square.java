package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 16:43
 */
public class Square implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }

}
