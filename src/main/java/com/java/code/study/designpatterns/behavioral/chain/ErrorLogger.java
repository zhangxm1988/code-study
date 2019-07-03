package com.java.code.study.designpatterns.behavioral.chain;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 11:34
 */
public class ErrorLogger extends AbstractLogger {

  public ErrorLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.out.println("Error Console::Logger: " + message);
  }
}
