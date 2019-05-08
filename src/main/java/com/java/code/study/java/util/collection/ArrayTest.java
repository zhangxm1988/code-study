package com.java.code.study.java.util.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxm
 * @description array source code study
 *
 * @create 2019-05-08 20:44
 */
public class ArrayTest {

  public static void main(String[] args) {
    // 0声明数组
    String[] aArray = new String[5];
    String[] bArray = {"a","b","c", "d", "e"};
    String[] cArray = new String[]{"a","b","c","d","e"};

    // 1打印数组
    int[] intArray = { 1, 2, 3, 4, 5 };
    String intArrayString = Arrays.toString(intArray);
    // 直接打印,则会打印出引用对象的Hash值
    // [I@7150bd4d
    System.out.println(intArray);
    // [1, 2, 3, 4, 5]
    System.out.println(intArrayString);

    // 2根据数组创建ArrayList
    List<String> list = Arrays.asList(bArray);

  }

}
