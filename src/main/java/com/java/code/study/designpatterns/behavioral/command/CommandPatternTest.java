package com.java.code.study.designpatterns.behavioral.command;

/**
 * @author zhangxm
 * @description 命令模式
 *
 * @create 2019-07-03 14:13
 */
public class CommandPatternTest {

  public static void main(String[] args) {
    // 命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式
    // 请求以命令的形式包裹在对象中，并传给调用对象。
    // 调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。

    // 意图：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
    // 主要解决：在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，
    // 但某些场合，比如需要对行为进行记录、撤销或重做、事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。

    // 何时使用：在某些场合，比如要对行为进行"记录、撤销/重做、事务"等处理，这种无法抵御变化的紧耦合是不合适的。
    // 在这种情况下，如何将"行为请求者"与"行为实现者"解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。

    // 如何解决：通过调用者调用接受者执行命令，顺序：调用者→接受者→命令。
    // 关键代码：定义三个角色：1、received 真正的命令执行对象 2、Command 3、invoker 使用命令对象的入口

    Stock stock = new Stock();

    Order buyStock = new BuyStock(stock);
    Order sellStock = new SellStock(stock);

    Borker borker = new Borker();
    borker.takeOrder(buyStock);
    borker.takeOrder(sellStock);

    borker.placeOrders();

  }

}
