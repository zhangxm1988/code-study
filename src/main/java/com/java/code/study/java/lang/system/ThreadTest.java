package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description Thread study
 * @create 2019-06-12 18:49
 */
public class ThreadTest {

  public static void main(String[] args) {
    Thread thread1 = new MyThread();
    System.out.println("thread1 state:" + thread1.getState());
    thread1.start();
    System.out.println("thread1 state:" + thread1.getState());

    Thread thread2 = new MyThread();
    System.out.println("thread2 state:" + thread2.getState());
    thread2.start();
    System.out.println("thread2 state:" + thread2.getState());

  }

}
