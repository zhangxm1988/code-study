package com.java.code.study.designpatterns.structural.adapter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 15:14
 */
public class AudioPlayer implements MediaPlayer {

  private MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {

    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("play mp3 file. Name:" + fileName);
    } else if (audioType.equalsIgnoreCase("vlc") ||
        audioType.equalsIgnoreCase("mp4")) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    } else {
      System.out.println("Invalid media. "+ audioType + " format not supported");
    }

  }
}
