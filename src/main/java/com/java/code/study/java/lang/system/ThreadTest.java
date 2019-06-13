package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description Thread study
 * @create 2019-06-12 18:49
 */
public class ThreadTest {

  public static void main(String[] args) {
    Thread thread1 = new MyThread();
    thread1.start();

    Thread thread2 = new MyThread();
    thread2.start();

  }

}
