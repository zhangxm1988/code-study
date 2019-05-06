package com.java.code.study.java.lang.type;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author zhangxm
 * @description 枚举学习
 *
 * @create 2019-05-06 18:49
 */
public class EnumTest {

  public enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);

    private String name;
    private int index;

    // 构造方法
    Color(String name, int index) {
      this.name = name;
      this.index = index;
    }

    @Override
    public String toString() {
      return name + "-" + index;
    }
  }

  public enum Signal {
    GREEN, YELLOW, RED
  }

  public static class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
      System.out.println("color " + color.toString());
      switch (color) {
        case RED:
          color = Signal.GREEN;
          break;
        case YELLOW:
          color = Signal.RED;
          break;
        case GREEN:
          color = Signal.YELLOW;
          break;
      }

      System.out.println("color change " + color.toString());
    }
  }

  public static void main(String[] args) {
    System.out.println(Color.RED.toString());

    TrafficLight light = new TrafficLight();
    light.change();

    for (int i =0 ;i < Signal.values().length; i++) {
      System.out.println("信号枚举成员：" + Signal.values()[i].name() + "," + Signal.values()[i].ordinal());
    }

    System.out.println(Signal.valueOf("RED").toString());
    System.out.println(Signal.valueOf(Signal.class, "RED"));

    EnumMap map = new EnumMap(Signal.class);

    //map.put(Color.RED, "123");
    map.put(Signal.RED, "456");
    //map.put(Color.YELLOW, "789");
    map.put(Signal.YELLOW, "000");

    for (Object obj : map.keySet()) {
      System.out.println(map.get(obj));
    }

    EnumSet<Signal> enumSet = EnumSet.allOf(Signal.class);
    for (Signal signal : enumSet) {
      System.out.println("当前EnumSet中数据为：" + signal);
    }

  }

}
