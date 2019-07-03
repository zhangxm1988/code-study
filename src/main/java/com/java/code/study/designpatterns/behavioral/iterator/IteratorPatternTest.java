package com.java.code.study.designpatterns.behavioral.iterator;

/**
 * @author zhangxm
 * @description 迭代器模式
 *
 * @create 2019-07-03 10:19
 */
public class IteratorPatternTest {

  public static void main(String[] args) {
    // 迭代器模式（Iterator Pattern）这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。

    // 意图：提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
    // 主要解决：不同的方式来遍历整个整合对象。
    // 何时使用：遍历一个聚合对象。
    // 如何解决：把在元素之间游走的责任交给迭代器，而不是聚合对象。
    // 关键代码：定义接口：hasNext, next。
    // 应用实例：JAVA 中的 iterator。

    NameRepository nameRepository = new NameRepository();

    for (Iterator iterator = nameRepository.getIterator(); iterator.haveNext();) {
      String name = (String) iterator.next();
      System.out.println("Name : " + name);
    }

  }

}
