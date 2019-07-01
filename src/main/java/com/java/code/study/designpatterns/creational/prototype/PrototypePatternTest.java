package com.java.code.study.designpatterns.creational.prototype;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 11:03
 */
public class PrototypePatternTest {

  public static void main(String[] args) {
    // 原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。
    // 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
    // 应用实例： 1、细胞分裂。 2、JAVA 中的 Object clone() 方法。

    ShapeCache.loadCache();

    Shape cloneShape1 = ShapeCache.getShape("1");
    System.out.println("Shape : " + cloneShape1.getType());

    Shape cloneShape2 = ShapeCache.getShape("2");
    System.out.println("Shape : " + cloneShape2.getType());

    Shape cloneShape3 = ShapeCache.getShape("3");
    System.out.println("Shape : " + cloneShape3.getType());

  }


}
