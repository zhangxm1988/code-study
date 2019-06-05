package com.java.code.study.java.util.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhangxm
 * @description Map 提供了一个更通用的元素存储方法。
 * Map 集合类用于存储元素对（称作“键”和“值”），其中每个键映射到一个值
 *
 * @create 2019-06-04 09:25
 */
public class MapTest {

  public static void main(String[] args) {

    // study HashMap 业务
    // HashMap最多只允许一条记录的键为Null(多条会覆盖);允许多条记录的值为 Null。非同步的

    // jdk1.8源码分析： 数组 + 链表 + 红黑树
    // 默认的初始化容量 16 （数组的大小） 最大容量 2的30次方
    // 默认的填充因子（扩容）0.75  并且扩容必需是双倍的容量大小
    // 链表转换成红黑树条件：链表的长度大于等于8时并且数组的长度大于等于64
    // 当红黑树的长度小于等于6时由红黑树转换成链表

    Map<String, String> map = new HashMap(8);
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    map.put("key5", "value5");
    map.put("key6", "value6");
    map.put("key7", "value7");
    map.put("key8", "value8");
    map.put(null, "empty");
    map.put("key9", null);

    // 1、增强for循环使用方便，但性能较差，不适合处理超大量级的数据。
    // 2、迭代器的遍历速度要比增强for循环快很多，是增强for循环的2倍左右。
    // 3、使用entrySet遍历的速度要比keySet快很多，是keySet的1.5倍左右。

    // 增强for循环 keySet迭代
    for (String key : map.keySet()) {
      System.out.println("key=" + key + ",value=" + map.get(key));
    }

    // 增强for循环 entrySet迭代
    for(Map.Entry entry : map.entrySet()) {
      System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
    }

    // 迭代器，keySet迭代
    Iterator<String> iterator = map.keySet().iterator();
    String key;
    while (iterator.hasNext()) {
      key = iterator.next();
      System.out.println("key=" + key + ",value=" + map.get(key));
    }

    // 迭代器，entrySet迭代
    Iterator<Map.Entry<String,String>> iterator1 = map.entrySet().iterator();
    Map.Entry<String,String> entry;
    while(iterator1.hasNext()) {
      entry = iterator1.next();
      System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
    }

  }

}
