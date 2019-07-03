package com.java.code.study.designpatterns.behavioral.chain;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 11:30
 */
public class ConsoleLogger extends AbstractLogger {

  public ConsoleLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.out.println("Standard Console::Logger: " + message);
  }

}
