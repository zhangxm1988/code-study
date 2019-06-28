package com.java.code.study.designpatterns.creational.singleton;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 18:44
 */
public class Main {

  public static void main(String[] args) {
    EnumSingleton enumSingleton = EnumSingleton.INTANCE;

    enumSingleton.doSomething();
  }

}
