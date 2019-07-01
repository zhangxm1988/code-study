package com.java.code.study.designpatterns.structural.adapter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 15:07
 */
public class Mp4Player implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    // noting to do
  }

  @Override
  public void playMp4(String fileName) {
    System.out.println("play mp4 file. Name:" + fileName);
  }
}
