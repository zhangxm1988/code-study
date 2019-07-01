package com.java.code.study.designpatterns.creational.prototype;

import com.google.common.collect.HashBasedTable;

import java.util.Hashtable;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 11:26
 */
public class ShapeCache {

  private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

  // 对每种形状都运行数据库查询，并创建该形状
  // shapeMap.put(shapeKey, shape);
  // 例如，我们要添加三种形状
  public static void loadCache() {
    Circle circle = new Circle();
    circle.setId("1");
    shapeMap.put(circle.getId(), circle);

    Rectangle rectangle = new Rectangle();
    rectangle.setId("2");
    shapeMap.put(rectangle.getId(), rectangle);

    Square square = new Square();
    square.setId("3");
    shapeMap.put(square.getId(), square);
  }

  public static Shape getShape(String id) {
    Shape shape = shapeMap.get(id);

    return (Shape) shape.clone();
  }

}
