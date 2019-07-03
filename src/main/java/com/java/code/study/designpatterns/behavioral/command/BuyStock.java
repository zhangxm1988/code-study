package com.java.code.study.designpatterns.behavioral.command;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 14:54
 */
public class BuyStock implements Order {

  private Stock buyStock;

  public BuyStock(Stock buyStock) {
    this.buyStock = buyStock;
  }

  @Override
  public void execute() {
    buyStock.buy();
  }
}
