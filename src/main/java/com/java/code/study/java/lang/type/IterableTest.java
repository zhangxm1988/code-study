package com.java.code.study.java.lang.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-05-07 19:34
 */
public class IterableTest {

  // Iterable接口是Collection的顶层接口，所以Iterable是数据结构，用来存放数据的地方。
  // 迭代器模式的核心就是把遍历集合对象的行为与集合类进行分离了，遍历集合对象的类叫做迭代器。
  // 区别就是Iterable接口是专门创建新的迭代器的，Iterator接口是一个专门设计迭代器的。

  // 而Iterable则不然，每次调用都会返回一个从头开始计数的迭代器。多个迭代器是互不干扰的。

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("123");
    list.add("456");
    list.add("789");

    list.forEach(s -> {System.out.println(s);});

    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
