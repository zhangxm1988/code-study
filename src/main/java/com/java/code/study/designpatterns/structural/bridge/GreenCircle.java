package com.java.code.study.designpatterns.structural.bridge;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 09:59
 */
public class GreenCircle implements DrawAPI {
  @Override
  public void drawCircle(int radius, int x, int y) {
    System.out.println("Drawing Circle[ color: green, radius: "
        + radius +", x: " +x+", "+ y +"]");
  }
}
