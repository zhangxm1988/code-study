package com.java.code.study.designpatterns.behavioral.chain;

/**
 * @author zhangxm
 * @description 责任链模式
 *
 * @create 2019-07-03 11:02
 */
public class ChainPatternTest {

  private static AbstractLogger getChainOfLoggers() {
    AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
    AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
    AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

    errorLogger.setNextLogger(fileLogger);
    fileLogger.setNextLogger(consoleLogger);

    return errorLogger;
  }


  public static void main(String[] args) {
    // 责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。
    // 这种模式给予请求的类型，对请求的发送者和接收者进行解耦。

    // 在这种模式中，通常每个接收者都包含对另一个接收者的引用。
    // 如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
    // 过滤器（Filter）
    AbstractLogger chainLogger = getChainOfLoggers();

    chainLogger.loadMessage(AbstractLogger.INFO, "This is an information.");
    System.out.println();
    chainLogger.loadMessage(AbstractLogger.DEBUG, "This is a debug level information.");
    System.out.println();
    chainLogger.loadMessage(AbstractLogger.ERROR, "This is an error information.");
  }

}
