package com.java.code.study.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zhangxm
 * @description 信号量
 * @create 2019-06-28 10:18
 */
public class SemaphoreTest {

  // Semaphore是一种在多线程环境下使用的设施，该设施负责协调各个线程，
  // 以保证它们能够正确、合理的使用公共资源的设施，
  // 也是操作系统中用于控制进程同步互斥的量。

  // 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。

  // 应用场景：1、我们以一个停车场运作为例来说明信号量的作用。
  // 假设停车场只有三个车位，一开始三个车位都是空的。
  // 这时如果同时来了三辆车，看门人允许其中它们进入进入，然后放下车拦。
  // 以后来的车必须在入口等待，直到停车场中有车辆离开。
  // 这时，如果有一辆车离开停车场，看门人得知后，打开车拦，放入一辆，
  // 如果又离开一辆，则又可以放入一辆，如此往复。
  // 2、并发线程数控制，比例接口允许最大的并发数。

  private Semaphore semaphore = new Semaphore(3);
  private Random random = new Random();

  class TaskThread implements Runnable {
    private String id;

    public TaskThread(String id) {
      this.id = id;
    }

    @Override
    public void run() {
      try {
        semaphore.acquire();
        System.out.println("Thread " + id + " is working");
        Thread.sleep(random.nextInt(1000));
        semaphore.release();

        System.out.println("Thread " + id + " is over");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();

    SemaphoreTest semaphoreTest = new SemaphoreTest();

    executorService.submit(semaphoreTest.new TaskThread("a"));
    executorService.submit(semaphoreTest.new TaskThread("b"));
    executorService.submit(semaphoreTest.new TaskThread("c"));
    executorService.submit(semaphoreTest.new TaskThread("d"));
    executorService.submit(semaphoreTest.new TaskThread("e"));
    executorService.submit(semaphoreTest.new TaskThread("f"));
    executorService.submit(semaphoreTest.new TaskThread("g"));

    executorService.shutdown();
  }

}
