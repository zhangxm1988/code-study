package com.java.code.study.designpatterns.behavioral.template;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 09:17
 */
public class Cricket extends Game {
  @Override
  void initialize() {
    System.out.println("Cricket Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Cricket Game Started. Enjoy the game!");
  }

  @Override
  void endPlay() {
    System.out.println("Cricket Game Finished!");
  }
}
