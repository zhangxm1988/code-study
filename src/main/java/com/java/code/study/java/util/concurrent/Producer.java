package com.java.code.study.java.util.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangxm
 * @description 生产者
 *
 * @create 2019-06-20 18:43
 */
public class Producer implements Runnable {

  protected BlockingQueue<Message> blockingQueue;

  public Producer(BlockingQueue<Message> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    Message message;
    int index = 1;
    while (true) {
      try {
        String data = UUID.randomUUID().toString();
        System.out.println("Put: " + data);
        message = new Message(index++, data, 0);
        blockingQueue.put(message);
        Thread.sleep(1000);
        if (index > 10) {
          Thread.interrupted();
          break;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
