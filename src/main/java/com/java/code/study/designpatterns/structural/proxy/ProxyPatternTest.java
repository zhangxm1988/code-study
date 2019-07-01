package com.java.code.study.designpatterns.structural.proxy;

/**
 * @author zhangxm
 * @description 代理模式
 * @create 2019-07-01 16:33
 */
public class ProxyPatternTest {

  public static void main(String[] args) {

    // 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能
    Image image = new ProxyImage("test_10mb.jpg");

    // 图像将从磁盘加载
    image.display();
    System.out.println("");
    // 图像不需要从磁盘加载
    image.display();

    JDKProxy jdkProxy = new JDKProxy();
    image = new RealImage("test_20mb.jpg");

    Image image1 = (Image) jdkProxy.createProxy(image);
    image1.display();
  }

}
