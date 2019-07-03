package com.java.code.study.designpatterns.behavioral.template;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 09:15
 */
public abstract class Game {

  abstract void initialize();
  abstract void startPlay();
  abstract void endPlay();

  public final void play() {
    initialize();
    startPlay();
    endPlay();
  }
}
