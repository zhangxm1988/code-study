package com.java.code.study.java.util.collection;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxm
 * @description array source code study
 *
 * @create 2019-05-08 20:44
 */
public class ArraysTest {

  public static void main(String[] args) {
    // 0声明数组
    String[] aArray = new String[5];
    String[] bArray = {"a","b","c", "d", "e"};
    String[] cArray = new String[]{"a","b","c","d","e"};

    // 1打印数组
    int[] intArray = { 1, 2, 3, 6, 4, 5 };
    String intArrayString = Arrays.toString(intArray);
    // 直接打印,则会打印出引用对象的Hash值
    // [I@7150bd4d
    System.out.println(intArray);
    // [1, 2, 3, 4, 5]
    System.out.println(intArrayString);

    // 2根据数组创建ArrayList
    List<String> list = new ArrayList<>(Arrays.asList(bArray));
    list.forEach(s -> {System.out.println(s);});

    // 3检查数组是否包含某个值
    // Arrays.asList(T ...a) 返回是内部类ArrayList 容量是不可变的（final）
    System.out.println(Arrays.asList(cArray).contains("a"));
    System.out.println(Arrays.asList(1,2,3,4,5).contains(1));
    System.out.println(Arrays.asList(intArray).contains(1));

    // 4Arrays method study
    // equals(Object[], Object[])
    System.out.println(Arrays.equals(bArray, cArray));
    // sort(Object[])  toString(Object[])
    Arrays.sort(intArray);
    System.out.println(Arrays.toString(intArray));
    // fill(Object[], val)
    // Arrays.fill(intArray, 0);
    // System.out.println(Arrays.toString(intArray));
    // binarySearch(Object[], val)
    int index = Arrays.binarySearch(intArray, 2);
    System.out.println("binarySearch index:" + index);
    // copyof(array,length)
    int[] copyArray = Arrays.copyOf(intArray, 10);
    System.out.println(Arrays.toString(copyArray));
    int[] copyRangeArray = Arrays.copyOfRange(intArray, 1,3);
    System.out.println(Arrays.toString(copyRangeArray));

    // ArrayUtils study
    int[] addArray = ArrayUtils.add(intArray, 8);
    System.out.println(Arrays.toString(addArray));
    ArrayUtils.reverse(addArray);
    System.out.println(Arrays.toString(addArray));
    addArray = ArrayUtils.remove(addArray, 3);
    System.out.println(Arrays.toString(addArray));
    addArray = ArrayUtils.removeAll(addArray, 1,2,3);
    System.out.println(Arrays.toString(addArray));
    addArray = ArrayUtils.removeElement(addArray, 2);
    System.out.println(Arrays.toString(addArray));

    // java.lang.reflect.Array类提供静态方法来动态创建和访问Java数组。
    String[] array = (String[]) Array.newInstance(String.class, 20);
    array = ArrayUtils.add(array, "a");
    array = ArrayUtils.add(array, "b");
    array = ArrayUtils.insert(0, array, "c");

    System.out.println(Arrays.toString(array));


  }

}
