package com.java.code.study.java.util.concurrent;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangxm
 * @description 非阻塞队列学习
 *
 * @create 2019-06-19 18:25
 */
@SpringBootTest
public class QueueTest {

  // 队列是一种比较特殊的线性结构。
  // 它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作。
  // 进行插入操作的端称为队尾，进行删除操作的端称为队头。
  // 队列又称为“先进先出”（FIFO—first in first out）的线性表
  // 阻塞队列和非阻塞队列

  // study 非阻塞队列
  @Test
  public void priorityQueueTest() {
    // 优先级的
    Queue<String> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
    queue.add("abc");
    queue.add("bbb");
    queue.add("aba");
    queue.add("abb");

    System.out.println(queue.peek());
  }

  @Test
  public void concurrentLinkedQueueTest() {
    // 是基于链接节点的、线程安全的队列

    Queue<String> queue = new ConcurrentLinkedQueue<>();
    queue.add("123");queue.add("234");queue.offer("345");
    queue.add("456");queue.add("567");

    System.out.println(queue.poll());

  }

}
