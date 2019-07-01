package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description 长方形
 * @create 2019-06-28 16:42
 */
public class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }

}
