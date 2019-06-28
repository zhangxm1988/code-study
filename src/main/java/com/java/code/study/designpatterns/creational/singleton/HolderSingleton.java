package com.java.code.study.designpatterns.creational.singleton;

/**
 * @author zhangxm
 * @description 登记式/静态内部类
 * @create 2019-06-28 18:37
 */
public class HolderSingleton {

  private static class SingletonHolder {
    private static final HolderSingleton INSTANCE = new HolderSingleton();
  }

  private HolderSingleton(){}


  public static final HolderSingleton getInstance() {
    return SingletonHolder.INSTANCE;
  }


}
