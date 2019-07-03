package com.java.code.study.designpatterns.behavioral.chain;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 11:32
 */
public class FileLogger extends AbstractLogger {

  public FileLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.out.println("file::Logger: " + message);
  }

}
