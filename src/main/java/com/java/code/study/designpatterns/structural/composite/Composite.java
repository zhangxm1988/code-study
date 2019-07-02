package com.java.code.study.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-02 11:14
 */
public class Composite extends Component {

  private List<Component> components = new ArrayList<>();

  private String name;

  public Composite(String name) {
    this.name = name;
  }

  @Override
  public void add(Component component) {
    components.add(component);
  }

  @Override
  public void remove(Component componment) {
    components.remove(componment);
  }

  @Override
  public void getChild(int i) {
    components.get(i);
  }

  @Override
  public void callMe() {
    System.out.println("You called me in composite: " + name);
    // 递归每个组件
    for (Component component : components) {
      component.callMe();
    }
  }
}
