package com.java.code.study.designpatterns.behavioral.observer;

/**
 * @author zhangxm
 * @description 观察者模式
 *
 * @create 2019-07-03 09:23
 */
public class ObserverPatternTest {

  public static void main(String[] args) {
    // 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
    // 比如，当一个对象被修改时，则会自动通知它的依赖对象。

    // 意图：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
    // 主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
    // 何时使用：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
    // 如何解决：使用面向对象技术，可以将这种依赖关系弱化。
    // 关键代码：在抽象类里有一个 ArrayList 存放观察者们。
    // 使用实例：1、拍卖的时候，拍卖师观察最高标价，然后通知给其他竞价者竞价。
    // 优点： 1、观察者和被观察者是抽象耦合的。 2、建立一套触发机制。

    Observer fObserver = new FObserver();
    Observer sObserver = new SObserver();
    Observer tObserver = new TObserver();

    Subject subject = new Subject();
    subject.addAttach(fObserver);
    subject.addAttach(sObserver);
    subject.addAttach(tObserver);

    subject.updateMessage("subject message update");

  }

}
