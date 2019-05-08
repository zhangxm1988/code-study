package com.java.code.study.java.util.collection;

import java.util.*;

/**
 * @author zhangxm
 * @description Collection集合study
 *
 * @create 2019-05-07 19:06
 */
public class CollectionTest {

  public static void main(String[] args) {

    // 顶级接口 Collection
    Collection collection = null;

    // List集合
    List<Integer> list = new ArrayList<>(3);
    // 默认容量 10
    // 扩容容量 原来的1.5倍
    // 最大容量 Integer.MAX_VALUE - 8;
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
    subList.forEach(s -> {System.out.println(s);});

    // Set集合

    // Map

  }

}
