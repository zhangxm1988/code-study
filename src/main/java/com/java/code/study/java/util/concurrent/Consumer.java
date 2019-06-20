package com.java.code.study.java.util.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangxm
 * @description 消费者
 * @create 2019-06-20 17:21
 */
public class Consumer implements Runnable {

  private BlockingQueue<Message> blockingQueue;

  public Consumer(BlockingQueue<Message> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Message message = blockingQueue.take();
        System.out.println(Thread.currentThread().getName() +
            ",消费id:" + message.getId() + ",消费body:" + message.getBody());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
