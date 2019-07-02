package com.java.code.study.designpatterns.structural.bridge;

/**
 * @author zhangxm
 * @description 桥接模式
 *
 * @create 2019-07-02 09:31
 */
public class BridgePatternTest {

  public static void main(String[] args) {
    // 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。

    // 意图：将抽象部分与实现部分分离，使它们都可以独立的变化。
    // 主要解决：在有多种可能会变化的情况下，用继承会造成类爆炸问题，扩展起来不灵活。
    // 何时使用：实现系统可能有多个角度分类，每一种角度都可能变化。
    // 如何解决：把这种多角度分类分离出来，让它们独立变化，减少它们之间耦合。
    // 关键代码：抽象类依赖实现类。

    Shape greenCircle = new Circle(100, 10,20, new GreenCircle());
    Shape redCircle = new Circle(200, 10,10, new RedCircle());

    greenCircle.draw();
    redCircle.draw();
  }

}
