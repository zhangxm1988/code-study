package com.java.code.study.java.util.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangxm
 * @description jdk1.8 方法引用
 *
 * @create 2019-05-16 20:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MethodReferenceTest {

  @Test
  public void testMethodReference() {

    Person[] pArr = new Person[]{
        new Person("003", LocalDate.of(2016,9,1)),
        new Person("001", LocalDate.of(2016,2,1)),
        new Person("002", LocalDate.of(2016,3,1)),
        new Person("004", LocalDate.of(2016,12,1))};
    Arrays.sort(pArr, new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
      }
    });

    Arrays.sort(pArr, (a, b) -> Person.compareByAge(b, a));

    System.out.println(Arrays.asList(pArr));
  }


  public static void main(String[] args) {
    // 方法引用
    String[] stringsArray = new String[]{"a", "b", "f", "c", "d", "e"};
    Arrays.sort(stringsArray, (a, b) -> a.compareToIgnoreCase(b));
    System.out.println(Arrays.toString(stringsArray));
    Arrays.sort(stringsArray, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(stringsArray));
    // 方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。
    // 方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。
    // 计算时，方法引用会创建函数式接口的一个实例。
    // 注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。


  }

}
