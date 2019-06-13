package com.java.code.study.java.lang.system;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-12 19:33
 */
public class MyThread extends Thread {

  private AtomicInteger threadNum = new AtomicInteger();

  public void run() {
    System.out.println("study Thread happy" + threadNum.incrementAndGet());
  }

}
