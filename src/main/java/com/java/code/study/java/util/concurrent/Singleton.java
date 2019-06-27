package com.java.code.study.java.util.concurrent;

/**
 * @author zhangxm
 * @description 线程安全的单例
 *
 * @create 2019-06-25 16:09
 */
public class Singleton {

  private volatile static Singleton singleton;

  private Singleton() {}

  private static Singleton getInstance() {
    if (singleton == null) {
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }

    return singleton;
  }


  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    System.out.println(singleton1 == singleton2);

    // volatile 关键字，可深入到Java VM内存相关
    // synchronized 关键字，可深入到Java锁机制，高并发相关
    // new 关键字，可深入到Java VM类加载机制相关

    // 学习的知识点  volatile
    // volatile关键字修饰的变量看到的随时是自己的最新值

  }
}
