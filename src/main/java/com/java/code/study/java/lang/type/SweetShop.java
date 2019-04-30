package com.java.code.study.java.lang.type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-23 15:34
 */
class Candy{
  static{System.out.println("Loading Candy");}
}
class Gum{
  static{System.out.println("Loading Gum");}
}
class Cookie{
  static{System.out.println("Loading Cookie");}
  public Cookie(){
    System.out.println("initializing Cookie");
  }
}
public class SweetShop {
  public static void main(String[] args){
    Class<?> classType;
    System.out.println("inside main");
    try{
      classType=Class.forName("com.java.code.study.java.lang.type.Gum");
    }catch(ClassNotFoundException e){
      System.out.println("Couldn't not find Gum");
    }
    System.out.println("After creating Class.forName(\"Gum\")");
    classType=Candy.class;
    System.out.println("After creating Candy");
    Cookie cookie=new Cookie();
    classType=cookie.getClass();
    System.out.println("After creating Cookie");


    Class<? extends Number> numType = Integer.class;
    numType = double.class;
    numType = Number.class;

    List<? extends Number> list = new ArrayList<>();

  }
}
