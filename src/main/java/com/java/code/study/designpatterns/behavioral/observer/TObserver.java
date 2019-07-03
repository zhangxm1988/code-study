package com.java.code.study.designpatterns.behavioral.observer;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 10:03
 */
public class TObserver extends Observer {
  @Override
  public void update(String message) {
    System.out.println(TObserver.class.getName() + " : " + message);
  }
}
