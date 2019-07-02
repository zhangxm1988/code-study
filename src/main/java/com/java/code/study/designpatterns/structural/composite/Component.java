package com.java.code.study.designpatterns.structural.composite;

/**
 * @author zhangxm
 * @description 抽象组件
 *
 * @create 2019-07-02 11:07
 */
public abstract class Component {

  public void add(Component component) {
    // do component add
  }

  public void remove(Component component) {
    // do component remove
  }

  public void getChild(int i) {
    // do get child
  }

  public abstract void callMe();

}
