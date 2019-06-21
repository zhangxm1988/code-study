package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-12 19:33
 */
public class MyThread extends Thread {

  private MyThreadLocal myThreadLocal = new MyThreadLocal();

  public MyThread() {}

  public MyThread(MyThreadLocal myThreadLocal) {
    this.myThreadLocal = myThreadLocal;
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println(Thread.currentThread().getName() + "\t" + myThreadLocal.getNextNum());
    }

    myThreadLocal.remove();
  }

}
