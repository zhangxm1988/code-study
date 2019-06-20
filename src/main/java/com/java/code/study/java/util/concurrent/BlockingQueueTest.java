package com.java.code.study.java.util.concurrent;

import jdk.nashorn.internal.ir.Block;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @author zhangxm
 * @description 阻塞队列学习
 *
 * @create 2019-06-20 14:40
 */
@SpringBootTest
public class BlockingQueueTest {

  // 队列是一种比较特殊的线性结构。
  // 它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作。
  // 进行插入操作的端称为队尾，进行删除操作的端称为队头。
  // 队列又称为“先进先出”（FIFO—first in first out）的线性表
  // 阻塞队列

  @Test
  public void arrayBlockingQueueTest() throws InterruptedException {
    // 一个由数组支持的有界队列
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
    blockingQueue.put("a1a");
    blockingQueue.put("b2b");

    blockingQueue.poll();
    blockingQueue.put("c3c");
    blockingQueue.poll();
    blockingQueue.poll();

    blockingQueue.take();

    System.out.println(blockingQueue.peek());
  }

  @Test
  public void linkedBlockingQueueTest() throws InterruptedException {
    // 一个由链接节点支持的可选有界队列
    // 使用场景：线程池中使用LinkedBlockingQueue
    BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    blockingQueue.put("a1a");
    blockingQueue.put("b2b");
    blockingQueue.put("c3c");

    System.out.println(blockingQueue.peek());
  }

  @Test
  public void priorityBlockingQueueTest() throws InterruptedException {
    // 一个由优先级堆支持的无界优先级队列
    BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>(5,
        (a,b) -> b.compareTo(a));

    blockingQueue.put("b2b");
    blockingQueue.put("a1a");
    blockingQueue.put("c3c");
    blockingQueue.put("d4d");
    blockingQueue.put("e3e");
    blockingQueue.put("f3f");

    System.out.println(blockingQueue.peek());
  }

}
