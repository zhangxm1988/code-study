package com.java.code.study.java.util.collection;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
    System.out.println("study HashMap end");

    // study LinkHashMap  类似HashMap + LinkList实现
    // 以HashMap维护数据结构，内部维持了一个双向链表,可以保持顺序
    // 存储数据你想保持进入的顺序与被取出的顺序一致的话，优先考虑LinkedMap
    Map<String, String> linkHashMap = new LinkedHashMap<>();
    linkHashMap.put(null, "empty");
    linkHashMap.put("key", null);
    Iterator<Map.Entry<String,String>> iterator2 = linkHashMap.entrySet().iterator();
    Map.Entry<String, String> entry1;
    while (iterator2.hasNext()) {
      entry1 = iterator2.next();
      System.out.println("key=" + entry1.getKey() + ",value=" + entry1.getValue());
    }
    System.out.println("study LinkHashMap end");

    // study HashTable 数组 + 链表
    // HashTable key和value都不允许为null
    // HashTable 线程安全的（synchronized）
    // 默认的初始化容量 11 （数组的大小） 最大容量 2的30次方
    // 默认的填充因子（扩容）0.75  并且扩容必需是双倍的容量大小 + 1
    // 迭代器与HashMap不同
    Map<String, Integer> hashTable = new Hashtable<>();
    hashTable.put("table1", 1);
    hashTable.put("table2", 2);
    for(String key1 : hashTable.keySet()) {
      System.out.println("key=" + key1 + ",value=" + hashTable.get(key1));
    }
    System.out.println("study HashTable end");

    // study Properties
    Properties properties = new Properties();
    ClassPathResource classPathResource = new ClassPathResource("application.properties");
    try {
      properties.load(classPathResource.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("study Properties:" + properties.getProperty("key"));

    // study TreeMap  红黑树
    Map<String, String> treeMap = new TreeMap<>(Comparator.comparing(Integer::parseInt));
    treeMap.put("100", "value1");
    treeMap.put("11", "value2");
    treeMap.put("20", "value3");
    treeMap.put("30", "value4");
    Iterator<String> iterator3 = treeMap.keySet().iterator();
    String key3;
    while (iterator3.hasNext()) {
      key3 = iterator3.next();
      System.out.println("key=" + key3 + ",value=" + treeMap.get(key3));
    }
    System.out.println("study treeMap end");

    // study weakHashMap  weakRefence弱引用
    // 它的特殊之处在于 WeakHashMap 里的entry可能会被GC自动删除，即使程序员没有调用remove()或者clear()方法
    // 适用场景：WeekHashMap 的这个特点特别适用于需要缓存的场景
    Map<String, String> weakHashMap = new WeakHashMap<>();

    // study ConcurrentHashMap
    // 数据结构与HashMap数据结构相同
    // key and value 不允许为null

    Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    concurrentHashMap.put("key1", "value1");
    concurrentHashMap.put("key2", "value2");
    concurrentHashMap.put("key3", "value3");

    for (String key4 : concurrentHashMap.keySet()) {
      System.out.println("key=" + key4 + ",value=" + concurrentHashMap.get(key4));
    }
    System.out.println("study concurrentHashMap end");

    int NCPU = Runtime.getRuntime().availableProcessors();
    System.out.println("cpu available number:" + NCPU);
    long freeMemory = Runtime.getRuntime().freeMemory();
    System.out.println("free memory size:" + freeMemory);

  }

}
