package com.java.code.study.designpatterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 16:39
 */
@Getter @Setter
public abstract class Shape implements Cloneable {

  private String id;
  protected String type;

  abstract void draw();

  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return clone;
  }

}
