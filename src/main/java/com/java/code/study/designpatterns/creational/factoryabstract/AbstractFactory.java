package com.java.code.study.designpatterns.creational.factoryabstract;

import com.java.code.study.designpatterns.creational.factorymethod.Shape;

/**
 * @author zhangxm
 * @description 抽象工厂
 * @create 2019-06-28 17:29
 */
public abstract class AbstractFactory {

  public abstract Shape getShape(String shapeType);

  public abstract Color getColor(String colorType);

}
