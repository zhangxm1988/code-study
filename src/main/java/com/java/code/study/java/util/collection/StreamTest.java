package com.java.code.study.java.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zhangxm
 * @description 函数式编程
 *
 * @create 2019-05-14 15:56
 */
public class StreamTest {

  public static void main(String[] args) {

    // study Arrays.stream()
    Integer[] numberArray = new Integer[]{1,2,3,4,5,6,7,8,9,0};
    Arrays.stream(numberArray).forEach(num -> {System.out.print(num);});
    System.out.println();
    // study collection.stream()
    List<Integer> list = new ArrayList<>();
    list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);
    list.stream().forEach(num -> {System.out.print(num);});
    System.out.println();
    list.parallelStream().forEach(num -> {System.out.print(num);});
    System.out.println();
    // 流的操作类型 1.Intermediate(中间) 2.Terminal（终止）
    // study Intermediate   这类操作都是惰性化的（lazy）
    list.parallelStream()
        .filter(num -> num > 2)
        .filter(num -> num < 5)
        .filter(num -> num % 2 == 0)
        .forEach(num -> { System.out.println(num);});
    Arrays.stream("1,2,3".split(","))
        .mapToInt(Integer::valueOf).toArray();
    Arrays.stream("4,5,6".split(",")).flatMap(Stream::of);


  }

}
