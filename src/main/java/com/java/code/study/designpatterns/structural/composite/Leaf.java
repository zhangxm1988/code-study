package com.java.code.study.designpatterns.structural.composite;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 11:22
 */
public class Leaf extends Component {

  private String name;

  public Leaf(String name) {
    this.name = name;
  }

  @Override
  public void callMe() {
    System.out.println("You called me in leaf: " + name);
  }
}
