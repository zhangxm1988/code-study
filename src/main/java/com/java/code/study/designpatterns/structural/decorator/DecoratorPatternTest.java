package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description 装饰器模式
 *
 * @create 2019-07-01 15:52
 */
public class DecoratorPatternTest {

  public static void main(String[] args) {
    // 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。

    Shape circle = new Circle();
    System.out.println("Circle with normal border");
    circle.draw();

    ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
    System.out.println("\nCircle of red border");
    redCircle.draw();

    ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
    System.out.println("\nrectangle of red border");
    redRectangle.draw();
  }

}
