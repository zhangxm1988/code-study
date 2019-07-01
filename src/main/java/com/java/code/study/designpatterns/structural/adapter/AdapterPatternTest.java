package com.java.code.study.designpatterns.structural.adapter;

/**
 * @author zhangxm
 * @description 适配器模式
 *
 * @create 2019-07-01 15:22
 */
public class AdapterPatternTest {

  public static void main(String[] args) {

    // 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁
    // 将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
    // 适配器继承或依赖已有的对象，实现想要的目标接口
    AudioPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play("mp3", "beyond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }

}
