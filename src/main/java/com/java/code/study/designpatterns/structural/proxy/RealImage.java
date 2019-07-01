package com.java.code.study.designpatterns.structural.proxy;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 16:49
 */
public class RealImage implements Image {

  private String fileName;

  public RealImage(String fileName) {
    this.fileName = fileName;
    this.loadFromDisk(fileName);
  }


  @Override
  public void display() {
    System.out.println("Displaying " + fileName);
  }

  private void loadFromDisk(String fileName) {
    System.out.println("from disk loading " + fileName);
  }

}
