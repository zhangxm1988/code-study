package com.java.code.study.java.util.concurrent;

import com.java.code.study.java.lang.system.MyThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-19 16:59
 */
public class ScheduledThreadPoolTest {

  public static void main(String[] args) {
    // 定时以及周期性执行线程的线程池
    // 设定延迟时间，定期执行
    // 空闲线程会进行保留
    // 使用场景：适用于需要多个后台线程执行周期任务的场景。
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(6);
    for (int i = 0; i < 100; i++) {
      executorService.submit(new MyThread());
    }

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("delay executor thread start.......");
    executorService.schedule(new MyThread(), 1000, TimeUnit.MILLISECONDS);
    executorService.schedule(new MyThread(), 2000, TimeUnit.MILLISECONDS);
    executorService.shutdown();
  }
}
