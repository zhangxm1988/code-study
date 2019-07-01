package com.java.code.study.designpatterns.structural.adapter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 15:06
 */
public class VlcPlayer implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    System.out.println("play vlc file. Name:" + fileName);
  }

  @Override
  public void playMp4(String fileName) {
    // noting to do
  }
}
