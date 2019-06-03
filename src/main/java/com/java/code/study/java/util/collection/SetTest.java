package com.java.code.study.java.util.collection;

import java.util.*;

/**
 * @author zhangxm
 * @description 无序 不可重复集合
 *
 * @create 2019-06-03 19:19
 */
public class SetTest {

  public static void main(String[] args) {
    // 元素是无序的（存入和取出的顺序不一定一致）。
    // 元素不可以重复

    // study hashSet
    Set<String> stringSet = new HashSet<>();
    stringSet.add(String.valueOf(10));
    stringSet.add(String.valueOf(20));
    stringSet.add(String.valueOf(40));
    stringSet.add(String.valueOf(30));
    stringSet.add(String.valueOf(50));
    stringSet.forEach(System.out::println);
    System.out.println("study hashSet end");

    // study TreeSet
    SortedSet<String> sortedSet = new TreeSet<>(Comparator.comparingInt(Integer::parseInt));
    sortedSet.add(String.valueOf(20));
    sortedSet.add(String.valueOf(100));
    sortedSet.add(String.valueOf(11));
    sortedSet.add(String.valueOf(40));
    sortedSet.contains(String.valueOf(40));
    sortedSet.forEach(System.out::println);
    System.out.println("study TreeSet end");

    // study LinkedHashSet
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    linkedHashSet.add(String.valueOf(100));
    linkedHashSet.add(String.valueOf(500));
    linkedHashSet.add(String.valueOf(300));
    linkedHashSet.add(String.valueOf(200));
    linkedHashSet.add(String.valueOf(600));
    linkedHashSet.add(String.valueOf(100));

    linkedHashSet.forEach(System.out::println);
    System.out.println("study LinkedHashSet end");

  }

}
