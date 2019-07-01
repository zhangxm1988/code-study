package com.java.code.study.designpatterns.structural.decorator;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 16:20
 */
public class RedShapeDecorator extends ShapeDecorator {

  public RedShapeDecorator(Shape decoratorShape) {
    super(decoratorShape);
  }

  @Override
  public void draw() {
    super.draw();
    this.setRedBorder();
  }

  public void setRedBorder() {
    System.out.println("Border Color: Red");
  }

}
