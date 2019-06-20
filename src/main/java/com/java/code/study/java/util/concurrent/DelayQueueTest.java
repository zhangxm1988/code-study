package com.java.code.study.java.util.concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxm
 * @description 延迟队列学习
 *
 * @create 2019-06-20 17:04
 */
public class DelayQueueTest {

  public static void main(String[] args) {
    // 一个由优先级堆支持的、基于时间的调度队列。
    DelayQueue<Message> blockingQueue = new DelayQueue<>();

    // 添加延时消息,m1 延时3s
    Message m1 = new Message(1, "world", 3000);
    // 添加延时消息,m2 延时10s
    Message m2 = new Message(2, "hello", 10000);
    blockingQueue.offer(m2);
    blockingQueue.offer(m1);

    // 消费
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.execute(new Consumer(blockingQueue));

    executorService.shutdown();


    // 业务场景一：多考生考试
    // 业务场景二：具有过期时间的缓存
  }

}
