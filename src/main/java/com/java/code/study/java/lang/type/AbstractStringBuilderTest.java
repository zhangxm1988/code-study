package com.java.code.study.java.lang.type;

/**
 * @author zhangxm
 * @description 字符系列
 *
 * @create 2019-04-21 18:10
 */
public class AbstractStringBuilderTest {

  public static void main(String[] args) {

    // 使用场景：在频繁进行字符串运算（如拼接、替换、和删除等），并且运行在单线程的环境中，
    // 则可以考虑使用StringBuilder，如SQL语句的拼装、JSON封装等。
    StringBuilder builder = new StringBuilder();
    builder.append(1).append('a').append(1.0);
    System.out.println("builder:" + builder.toString());

    // 使用场景：在频繁进行字符串运算（如拼接、替换、删除等），并且运行在多线程环境中，
    // 则可以考虑使用StringBuffer，例如XML解析、HTTP参数解析和封装。
    StringBuffer buffer = new StringBuffer();
    buffer.append(1).append('a').append(1.0);
    System.out.println("buffer:" + buffer.toString());

  }

}
