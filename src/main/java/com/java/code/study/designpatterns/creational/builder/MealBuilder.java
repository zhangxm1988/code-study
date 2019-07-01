package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:51
 */
public class MealBuilder {

  public Meal prepareVegBuiger() {
    Meal meal = new Meal();
    meal.addItem(new VegBurger());

    meal.addItem(new Cook());

    return meal;
  }

  public Meal prepareChickenBuiger() {
    Meal meal = new Meal();
    meal.addItem(new ChickenBurger());
    meal.addItem(new Pepsi());

    return meal;
  }


}
