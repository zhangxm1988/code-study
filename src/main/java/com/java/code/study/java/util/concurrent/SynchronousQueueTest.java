package com.java.code.study.java.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-20 18:32
 */
public class SynchronousQueueTest {

  public static void main(String[] args) {

    // 同步队列
    // 一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。
    // 它模拟的功能类似于生活中一手交钱一手交货这种情形
    final BlockingQueue<Message> blockingQueue = new SynchronousQueue<>();

    // 生产者
    new Thread(new Producer(blockingQueue)).start();

    // 消费者
    new Thread(new Consumer(blockingQueue)).start();
    new Thread(new Consumer(blockingQueue)).start();


  }

}
