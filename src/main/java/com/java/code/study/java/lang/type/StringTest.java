package com.java.code.study.java.lang.type;

/**
 * @author zhangxm
 * @description java.lang中String学习
 *
 * @create 2019-04-10 19:13
 */
public class StringTest {

  public Void studyVoid() {
    System.out.println("study void");

    return null;
  }

  public void studyVoid1() {
    System.out.println("study void");
  }

  /**
   * 测试主方法
   *
   * @param args
   */
  public static void main(String[] args) {

    // 学习jvm内存分配机制
    String str1 = "hello";
    String str2 = "hello";
    String str3 = new String("hello");
    System.out.println(str1 == str2);//true
    System.out.println(str1 == str3);//fasle
    System.out.println(str2 == str3);//fasle
    System.out.println(str1.equals(str2));//true
    System.out.println(str1.equals(str3));//true
    System.out.println(str2.equals(str3));//true

  }

}
