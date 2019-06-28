package com.java.code.study.designpatterns.creational.singleton;

/**
 * @author zhangxm
 * @description 双检锁/双重校验锁（DCL，即 double-checked locking）
 * @create 2019-06-28 18:27
 */
public class DoubleCheckedSingleton {

  private volatile static DoubleCheckedSingleton doubleCheckedSingleton;

  private DoubleCheckedSingleton(){}

  public static DoubleCheckedSingleton getInstance() {

    if (doubleCheckedSingleton == null) {
      synchronized (DoubleCheckedSingleton.class) {
        if (doubleCheckedSingleton == null) {
          doubleCheckedSingleton = new DoubleCheckedSingleton();
        }
      }
    }

    return doubleCheckedSingleton;
  }

}
