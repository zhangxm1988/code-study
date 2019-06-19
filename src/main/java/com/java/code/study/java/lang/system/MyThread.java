package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-12 19:33
 */
public class MyThread extends Thread {

  public void run() {
    System.out.println(Thread.currentThread().getName() + "正在执行。。。");
  }

}
