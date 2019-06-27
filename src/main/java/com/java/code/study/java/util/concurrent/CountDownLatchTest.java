package com.java.code.study.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-27 14:41
 */
public class CountDownLatchTest {

  public static void main(String[] args) {

    // CountDownLatch 闭锁
    // 使用场景：CountDownLatch也叫闭锁，使得一(多)个主线程必须等待其他线程完成操作后再执行
    concurrentTest();

  }

  /**
   * 模拟高并发情况代码
   */
  public static void concurrentTest() {

    final AtomicInteger atomicInteger = new AtomicInteger();
    // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
    final CountDownLatch countDownLatch1 = new CountDownLatch(100);
    // 保证所有线程执行完了再打印atomicInteger的值
    final CountDownLatch countDownLatch2 = new CountDownLatch(100);

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    try {
      for (int i = 0; i < 100; i++) {
        executorService.submit(new Runnable() {
          @Override
          public void run() {
            try {
              countDownLatch1.await();
            } catch (Exception ex) {
              ex.printStackTrace();
            }
            // 每个线程增加1000次，每次加1
            for (int j = 0; j < 100; j++) {
              atomicInteger.incrementAndGet();
            }
            countDownLatch2.countDown();
          }
        });
        countDownLatch1.countDown();
      }

      countDownLatch2.await();
      System.out.println("atomic integer:" + atomicInteger.intValue());
      executorService.shutdown();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
