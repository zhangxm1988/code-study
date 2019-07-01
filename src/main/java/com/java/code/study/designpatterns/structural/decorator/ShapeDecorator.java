package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description 装饰器模式
 * @create 2019-07-01 16:15
 */
public abstract class ShapeDecorator implements Shape {

  private Shape decoratorShape;

  public ShapeDecorator(Shape decoratorShape) {
    this.decoratorShape = decoratorShape;
  }

  public void draw() {
    decoratorShape.draw();
  }

}
