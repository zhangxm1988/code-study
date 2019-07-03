package com.java.code.study.designpatterns.behavioral.interpreter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 15:51
 */
public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }

  @Override
  public boolean interpret(String context) {

    if (context.contains(data)) {
      return true;
    }
    return false;
  }

}
