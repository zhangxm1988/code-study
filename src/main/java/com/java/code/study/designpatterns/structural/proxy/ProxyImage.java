package com.java.code.study.designpatterns.structural.proxy;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 17:00
 */
public class ProxyImage implements Image {

  private RealImage realImage;
  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(fileName);
    }

    realImage.display();
  }

}
