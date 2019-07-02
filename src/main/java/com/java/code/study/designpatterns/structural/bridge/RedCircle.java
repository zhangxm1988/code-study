package com.java.code.study.designpatterns.structural.bridge;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 10:01
 */
public class RedCircle implements DrawAPI {
  @Override
  public void drawCircle(int radius, int x, int y) {
    System.out.println("Drawing Circle[ color: red, radius: "
        + radius +", x: " +x+", "+ y +"]");
  }
}
