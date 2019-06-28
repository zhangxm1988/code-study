package com.java.code.study.designpatterns.creational.factoryabstract;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 18:06
 */
public class Main {

  public static void main(String[] args) {
    AbstractFactory abstractFactory1 = FactoryProducer.getFactory("SHAPE");
    abstractFactory1.getShape("CIRCLE").draw();

    AbstractFactory abstractFactory2 = FactoryProducer.getFactory("COLOR");
    abstractFactory2.getColor("RED").fill();

  }

}
