package com.java.code.study.java.util.concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhangxm
 * @description 双端队列学习
 *
 * @create 2019-06-20 11:02
 */
public class DequeTest {

  // double ended queue
  // 双向队列，指该队列两端的元素既能入队(offer)也能出队(poll),
  // 如果将Deque限制为只能从一端入队和出队，则可实现栈的数据结构
  // 对于栈而言，有入栈(push)和出栈(pop)，遵循先进后出原则
  // Deque是一种具有队列和栈的性质的数据结构.双端队列中的元素可以从两端弹出,其限定插入和删除操作在表的两端进行

  public static void main(String[] args) {

    Deque<String> deque = new ArrayDeque<>();
    deque = new LinkedBlockingDeque<>();

    deque = new LinkedList<>();
    deque = new ConcurrentLinkedDeque<>();

  }

}
