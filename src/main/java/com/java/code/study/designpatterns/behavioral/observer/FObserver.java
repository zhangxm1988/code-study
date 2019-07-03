package com.java.code.study.designpatterns.behavioral.observer;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 10:01
 */
public class FObserver extends Observer {
  @Override
  public void update(String message) {
    System.out.println(FObserver.class.getName() + " : " + message);
  }
}
