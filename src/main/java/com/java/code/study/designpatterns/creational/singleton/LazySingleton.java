package com.java.code.study.designpatterns.creational.singleton;

/**
 * @author zhangxm
 * @description 懒汉式 （线程不安全）（线程安全synchronized）
 * @create 2019-06-28 18:18
 */
public class LazySingleton {

  private static LazySingleton lazySingleton;

  private LazySingleton() { }

  public static synchronized LazySingleton getInstance() {
    if (lazySingleton == null) {
      lazySingleton = new LazySingleton();
    }

    return lazySingleton;
  }

}
