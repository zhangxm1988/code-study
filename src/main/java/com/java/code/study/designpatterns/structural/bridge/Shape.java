package com.java.code.study.designpatterns.structural.bridge;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 09:57
 */
public abstract class Shape {

  protected DrawAPI drawAPI;

  public Shape(DrawAPI drawAPI) {
    this.drawAPI = drawAPI;
  }

  public abstract void draw();

}
