package com.java.code.study.java.util.collection;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangxm
 * @description 函数式编程
 *
 * @create 2019-05-14 15:56
 */
public class StreamTest {

  public static void print(String text) {
    // 这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。
    Optional.ofNullable(text).ifPresent(System.out::println);
  }

  public static int getLength(String text) {
    // 这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。
    return Optional.ofNullable(text).map(String::length).orElse(-1);
  }

  public static void main(String[] args) {

    // stream is what
    // Java 8 中的 Stream 是对集合（Collection）对象功能的增强，
    // 它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate operation），
    // 或者大批量数据操作 (bulk data operation)

    // study Arrays.stream()
    Integer[] numberArray = new Integer[]{1,2,3,4,5,6,7,8,9,0};
    Arrays.stream(numberArray).forEach(num -> {System.out.print(num);});
    System.out.println("\nstudy Arrays.stream");
    Stream.of(numberArray).forEach(num -> {System.out.print(num);});
    System.out.println("\nstudy Stream.of");

    // study collection.stream()
    List<Integer> list = new ArrayList<>();
    list.add(1);list.add(2);list.add(3);list.add(4);
    list.add(5);list.add(6);list.add(7);
    list.stream().forEach(num -> {System.out.print(num);});
    System.out.println("\nstudy collection.stream");
    list.parallelStream().forEach(num -> {System.out.print(num);});
    System.out.println("\nstudy collection.parallelStream");

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

    // study Optional
    StreamTest.print("study optional");
    int length = StreamTest.getLength("study optional");
    System.out.println("Optional length:" + length);

    // 自己生成流
    // 生成10个随机整数
    Random random = new Random(10);
    Supplier<Integer> supplier = random::nextInt;
    Stream.generate(supplier).limit(2).forEach(System.out::println);

    // Another way
    IntStream.generate(() -> (int) (System.nanoTime() % 100)).
        limit(10).forEach(System.out::println);

    // study Stream.iterate
    Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);

    // 用 Collectors 来进行 reduction 操作

    // 用 Collectors 来进行 collect 操作
    List<Person> personList = new ArrayList<>();
    personList.add(new Person("1001", "小华"));
    personList.add(new Person("1001", "小红"));
    personList.add(new Person(null, "小丽"));

    Map<String, String> personMap = personList.stream()
        .collect(Collectors.toMap(Person::getId, Person::getName,
            (key1, key2) -> key2 + "," + key1));
    System.out.println(personMap);

    Map<String, List<String>> map = personList.stream()
        .collect(Collectors.toMap(Person::getId,
        p ->  {
          List<String> getNameList = new ArrayList<>();
          getNameList.add(p.getName());
          return getNameList;
        },
        (List<String> value1, List<String> value2) -> {
          value1.addAll(value2);
          return value1;
        }
    ));

    System.out.println(map);

  }

}
