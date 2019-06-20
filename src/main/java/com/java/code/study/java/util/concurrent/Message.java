package com.java.code.study.java.util.concurrent;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-20 17:06
 */
@Getter @Setter
public class Message implements Delayed {

  private int id;// 消息id
  private String body;// 消息体
  private long delayTime;// 延迟时长，这个是必须的属性因为要按照这个判断延时时长。

  public Message(int id, String body, long delayTime) {
    this.id = id;
    this.body = body;
    this.delayTime = TimeUnit.NANOSECONDS.convert(delayTime,
        TimeUnit.MILLISECONDS) + System.nanoTime();
  }

  // 延迟任务是否到时就是按照这个方法判断如果返回的是负数则说明到期否则还没到期
  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(this.delayTime - System.nanoTime(), TimeUnit.NANOSECONDS);
  }

  @Override
  public int compareTo(Delayed delayed) {
    Message msg = (Message) delayed;
    return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
        : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
  }
}
