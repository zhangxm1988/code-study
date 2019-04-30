package com.java.code.study.java.lang.type;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-21 15:01
 */
public class NumberCacheTest {

  public static void main(String[] args) {

    // Byte包装类
    Byte byte1 = 127;
    Byte byte2 = 127;
    System.out.println("Byte == " + (byte1.equals(byte2)));

    // Short包装类
    Short short1 = new Short("20");
    System.out.println("Short:" + short1);

    Integer integer1 = 300;
    Integer integer2 = 300;
    System.out.println("Integer12 == " + (integer1 == integer2));

    Long long1 = 127L;
    Long long2 = 127L;
    Long long3 = 256L;
    Long long4 = 256L;
    System.out.println("Long12 == " + (long1 == long2));
    System.out.println("Long34 == " + (long3 == long4));
  }

}
