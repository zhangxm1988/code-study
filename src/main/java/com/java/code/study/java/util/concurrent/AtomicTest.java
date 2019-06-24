package com.java.code.study.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxm
 * @description 原子性
 *
 * @create 2019-06-21 10:29
 */
public class AtomicTest {

  private static AtomicInteger number = new AtomicInteger(0);

  public static void main(String[] args) {
    CountDownLatch countDownLatch = new CountDownLatch(2);

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5000; i++) {
          number.incrementAndGet();
        }
        countDownLatch.countDown();
      }
    });

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int k = 0; k < 5001; k++) {
          number.incrementAndGet();
        }
        countDownLatch.countDown();
      }
    });

    thread1.start();
    thread2.start();

    try {
      countDownLatch.await();
      System.out.println("number is " + number);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
