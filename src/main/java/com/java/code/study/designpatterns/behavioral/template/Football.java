package com.java.code.study.designpatterns.behavioral.template;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 09:18
 */
public class Football extends Game {
  @Override
  void initialize() {
    System.out.println("Football Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Football Game Started. Enjoy the game!");
  }

  @Override
  void endPlay() {
    System.out.println("Football Game Finished!");
  }
}
