package com.java.code.study.java.util.collection;

import java.time.LocalDate;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-05-16 20:21
 */
public class Person {

  public Person(String name, LocalDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  String name;
  LocalDate birthday;

  public LocalDate getBirthday() {
    return birthday;
  }

  public static int compareByAge(Person a, Person b) {
    return a.birthday.compareTo(b.birthday);
  }

  @Override
  public String toString() {
    return this.name;
  }

}
