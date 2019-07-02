package com.java.code.study.designpatterns.structural.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 15:12
 */
@Getter @Setter
public class Circle implements Shape {
  private String color;
  private int x;
  private int y;
  private int radius;

  @Override
  public void draw() {
    System.out.println("Circle: Draw() [Color : " + color
        +", x : " + x +", y :" + y +", radius :" + radius);
  }
}
