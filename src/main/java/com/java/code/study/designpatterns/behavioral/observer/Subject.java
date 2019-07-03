package com.java.code.study.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxm
 * @description 被观察者
 *
 * @create 2019-07-03 10:03
 */
public class Subject {

  private List<Observer> observers = new ArrayList<>();

  // 修改
  public void updateMessage(String message) {
    this.notifyAll(message);
  }

  // 订阅
  public void addAttach(Observer observer) {
    observers.add(observer);
  }

  // 通知观察者
  private void notifyAll(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

}
