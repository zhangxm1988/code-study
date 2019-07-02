package com.java.code.study.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 15:14
 */
public class ShapeFactory {

  private static Map<String, Shape> shapeMap = new HashMap<>();

  public static Shape getShape(String color) {
    Circle circle = (Circle) shapeMap.get(color);

    if (circle == null) {
      circle = new Circle();
      shapeMap.put(color, circle);
      System.out.println("Creating circle of color : " + color);
    }

    return circle;
  }

}
