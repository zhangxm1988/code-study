package com.java.code.study.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 14:57
 */
public class Borker {

  private List<Order> orders = new ArrayList<>();

  public void takeOrder(Order order) {
    orders.add(order);
  }

  public void placeOrders() {
    for (Order order : orders) {
      order.execute();
    }

    orders.clear();
  }

}
