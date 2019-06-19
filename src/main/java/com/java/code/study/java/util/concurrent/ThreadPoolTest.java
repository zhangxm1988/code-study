package com.java.code.study.java.util.concurrent;

import com.java.code.study.java.lang.system.MyThread;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxm
 * @description 线程池学习
 *
 * @create 2019-06-18 15:57
 */
@SpringBootTest
public class ThreadPoolTest {

  // submit()，提交一个线程任务，可以接受回调函数的返回值吗，适用于需要处理返回着或者异常的业务场景
  // execute()，执行一个任务，没有返回值
  // shutdown()，表示不再接受新任务，但不会强行终止已经提交或者正在执行中的任务
  // shutdownNow()，对于尚未执行的任务全部取消，正在执行的任务全部发出interrupt()，停止执行

  @Test
  public void fixedThreadPoolTest() {
    // 固定大小的线程池
    // 创建重用固定数量线程的线程池，不能随时新建线程
    // 当所有线程都处于活动状态时，如果提交了其他任务，
    // 他们将在队列中等待一个线程可用
    // 线程会一直存在，直到调用shutdown
    // 使用场景：适用于可以预测线程数量的业务中，或者服务器负载较重，对当前线程数量进行限制。
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      executorService.submit(new MyThread());
    }

    executorService.shutdown();
  }


  @Test
  public void singleThreadExecutorTest() {
    // 单线程的线程池
    // 在任何情况下都不会有超过一个任务处于活动状态
    // 与newFixedThreadPool(1)不同是不能重新配置加入线程，使用FinalizableDelegatedExecutorService进行包装
    // 能保证执行顺序，先提交的先执行。
    // 当线程执行中出现异常，去创建一个新的线程替换之
    // 使用场景：适用于需要保证顺序执行各个任务，并且在任意时间点，不会有多个线程是活动的场景。
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 100; i++) {
      executorService.submit(new MyThread());
    }

    executorService.shutdown();
  }

  @Test
  public void cachedThreadPoolTest() {
    // 可缓存的线程池
    // 重用之前的线程
    // 调用 execute() 将重用以前构造的线程
    // 如果没有可用的线程，则创建一个新线程并添加到池中
    // 默认为60s未使用就被终止和移除
    // 长期闲置的池将会不消耗任何资源
    // 使用场景：适用于服务器负载较轻，执行很多短期异步任务。
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 100; i++) {
      executorService.submit(new MyThread());
    }

    executorService.shutdown();
  }



}
