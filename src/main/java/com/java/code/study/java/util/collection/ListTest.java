package com.java.code.study.java.util.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * @author zhangxm
 * @description 有序集合 可重复
 *
 * @create 2019-05-09 17:10
 */
public class ListTest {

  public static void main(String[] args) {
    // ArrayList集合
    List<Integer> list = new ArrayList<>(3);
    // 默认容量 10
    // 扩容容量 原来的1.5倍
    // 最大容量 Integer.MAX_VALUE - 8;
    // 线程不安全的
    // 基于数组实现的非线程安全的集合。查询元素快，插入，删除中间元素慢。 读多写少
    list.add(1);list.add(2);list.add(3);
    list.add(4);list.add(5);list.add(6);list.add(7);
    list.add(8);list.add(9);list.add(10);list.add(11);

    //list.forEach(s -> {System.out.println(s);});
    System.out.println(list.contains(5));
    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    ListIterator listIterator = list.listIterator();
    while(listIterator.hasNext()) {
      System.out.println(listIterator.next());
      //System.out.println(listIterator.previous());
    }
    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.intValue() > o2.intValue()) {
          return -1;
        } else {
          return 1;
        }
      }
    });
    //list.forEach(s -> {System.out.println(s);});
    List<Integer> subList = list.subList(1, 3);
    subList.forEach(s -> {System.out.println("ArrayList:" + s);});

    // Vector集合
    List<String> vector = new Vector<>(10, 20);
    // 默认容量 10
    // 默认扩容容量 原来的2倍 也可以自己设置扩容容量
    // 最大容量 Integer.MAX_VALUE - 8;
    // 线程安全的
    vector.add("zhangxm");
    ((Vector<String>) vector).addElement("test");

    // CopyOnWriteArrayList 集合
    // 基于数组实现的线程安全的写时复制集合。线程安全（ReentrantLock加锁），性能比Vector高，适合读多写少的场景
    CopyOnWriteArrayList<Integer> cwList = new CopyOnWriteArrayList<>();
    cwList.add(36);cwList.add(38);cwList.add(40);cwList.add(24);cwList.add(28);

    // LinkedList集合
    // 数据存储是基于双向链表实现的
    // 适用场景：基于链表实现的非线程安全的集合。查询元素慢，插入，删除中间元素快。 读少写多
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(30);
    linkedList.add(20);
    linkedList.add(45);
    linkedList.add(36);
    linkedList.add(88);
    linkedList.add(3, 55);
    System.out.println("linkedList:" + linkedList);
    System.out.println("linkedList first:" + (linkedList).getFirst());
    System.out.println("linkedList last:" + (linkedList).getLast());

    //linkedList.pollFirst();
    //linkedList.pollLast();
    //linkedList.pop();
    //linkedList.push(10);
    System.out.println(linkedList.peek());
    System.out.println(linkedList.peekLast());

    Iterator<Integer> iterator1 = linkedList.listIterator();
    while(iterator1.hasNext()) {
      System.out.println("LinkedList:" + iterator1.next());
    }
  }

}
