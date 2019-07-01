package com.java.code.study.designpatterns.creational.builder;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 10:56
 */
public class BuilderPatternTest {

  public static void main(String[] args) {

    MealBuilder mealBuilder = new MealBuilder();

    Meal vegBuiger = mealBuilder.prepareVegBuiger();
    vegBuiger.showItems();
    System.out.println("vegBuiger meal cost is " + vegBuiger.getCost());


    Meal chickenBuiger = mealBuilder.prepareChickenBuiger();
    chickenBuiger.showItems();
    System.out.println("chickenBuiger meal cost is " + chickenBuiger.getCost());
  }

}
