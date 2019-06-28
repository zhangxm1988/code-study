package com.java.code.study.designpatterns.creational.singleton;

/**
 * @author zhangxm
 * @description 饿汉式
 *
 * @create 2019-06-28 18:22
 */
public class EagerSingleton {

  private static EagerSingleton eagerSingleton = new EagerSingleton();

  private EagerSingleton(){}

  public static EagerSingleton getInstance() {
    return eagerSingleton;
  }

}
