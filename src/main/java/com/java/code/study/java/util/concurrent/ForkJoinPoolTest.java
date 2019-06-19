package com.java.code.study.java.util.concurrent;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-19 17:24
 */

@SpringBootTest
public class ForkJoinPoolTest {

  // 获取当前可用的线程数量进行创建作为并行级别
  // 使用ForkJoinPool
  // 使用场景：适用于大耗时的操作，可以并行来执行

  // 线程数
  private static final int threads = 10;
  // 用于计数线程是否执行完成
  CountDownLatch countDownLatch = new CountDownLatch(threads);

  @Test
  public void test1() throws InterruptedException {
    System.out.println("---- start ----");
    ExecutorService executorService = Executors.newWorkStealingPool();
    for (int i = 0; i < threads; i++) {
      executorService.execute(() -> {
        try {
          System.out.println(Thread.currentThread().getName());
        } catch (Exception ex) {
          ex.printStackTrace();
        } finally {
          countDownLatch.countDown();
        }
      });
    }

    countDownLatch.await();
    System.out.println("---- end ----");
  }

  @Test
  public void test2() throws InterruptedException {

    System.out.println("---- start ----");
    ExecutorService executorService = Executors.newWorkStealingPool();
    for (int i = 0; i < threads; i++) {
      executorService.submit(() -> {
        try {
          System.out.println(Thread.currentThread().getName());
        } catch (Exception ex) {
          ex.printStackTrace();
        } finally {
          countDownLatch.countDown();
        }
      });
    }

    countDownLatch.await();
    System.out.println("---- end ----");

  }

  @Test
  public void test3() throws InterruptedException, ExecutionException {

    System.out.println("---- start ----");
    ExecutorService executorService = Executors.newWorkStealingPool();
    FutureTask<?> futureTask;
    for (int i = 0; i < threads; i++) {
      // Runnable 有带回值的
      futureTask = new FutureTask<>(new Callable<String>() {

        @Override
        public String call() throws Exception {
          return Thread.currentThread().getName();
        }
      });

      executorService.submit(new Thread(futureTask));
      System.out.println(futureTask.get());
    }

    System.out.println("---- end ----");
  }

}
