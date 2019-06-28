package com.java.code.study.java.util.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangxm
 * @description 显式锁(互斥锁和速写锁)相关
 *
 * @create 2019-06-24 14:54
 */
public class LocksTest {

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    // 可重入锁（递归锁）
    ReentrantLock reenTrantLock;

    // 读写锁
    ReentrantReadWriteLock readWriteLock;

    // CountDownLatch 闭锁
    // 使用场景：CountDownLatch也叫闭锁，使得一(多)个主线程必须等待其他线程完成操作后再执行
    CountDownLatch latch = new CountDownLatch(10);
    latch.countDown();
    latch.await();
    latch.await(1000, TimeUnit.MILLISECONDS);

    // CyclicBarrier  循环锁
    // 可循环调用，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
    // 所谓屏障点就是一组任务执行完毕的时刻
    CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    cyclicBarrier.await();

    // Semaphore  信号量
    Semaphore semaphore;
  }

}
