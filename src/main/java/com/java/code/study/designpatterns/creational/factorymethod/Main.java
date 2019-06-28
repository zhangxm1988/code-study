package com.java.code.study.designpatterns.creational.factorymethod;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 16:49
 */
public class Main {

  public static void main(String[] args) {
    ShapeFactory factory = new ShapeFactory();

    Shape shape1 = factory.getShape("CIRCLE");
    shape1.draw();

    Shape shape2 = factory.getShape("RECTANGLE");
    shape2.draw();

    Shape shape3 = factory.getShape("SQUARE");
    shape3.draw();
  }

}
