package com.java.code.study.java.util.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-05-07 10:28
 */
public class IteratorTest {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("123");
    list.add("456");
    list.add("789");

    // Iterator迭代器
    // 迭代器模式的核心就是把遍历集合对象的行为与集合类进行分离了，遍历集合对象的类叫做迭代器。
    // 区别就是Iterable接口是专门创建新的迭代器的，Iterator接口是一个专门设计迭代器的。
    // 迭代器（iterator）是一种对象，它能够用来遍历标准模板库容器中的部分或全部元素，每个迭代器对象代表容器中的确定的地址

    // 迭代器循环
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());

      // iterator.remove();
    }
  }

}
