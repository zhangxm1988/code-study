package com.java.code.study.designpatterns.behavioral.chain;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 11:13
 */
public abstract class AbstractLogger {

  public static int INFO = 1;
  public static int DEBUG = 2;
  public static int ERROR = 3;

  protected int level;

  // 责任链中的下个元素
  protected AbstractLogger nextLogger;

  public void setNextLogger(AbstractLogger nextLogger) {
    this.nextLogger = nextLogger;
  }

  public void loadMessage(int level, String message) {
    if (this.level <= level) {
      write(message);
    }

    if (nextLogger != null) {
      nextLogger.loadMessage(level, message);
    }
  }

  abstract void write(String message);

}
