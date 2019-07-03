package com.java.code.study.designpatterns.behavioral.command;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 14:56
 */
public class SellStock implements Order {

  private Stock sellStock;

  public SellStock(Stock sellStock) {
    this.sellStock = sellStock;
  }

  @Override
  public void execute() {
    sellStock.sell();
  }
}
