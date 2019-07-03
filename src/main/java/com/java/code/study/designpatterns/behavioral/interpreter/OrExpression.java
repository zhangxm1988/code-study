package com.java.code.study.designpatterns.behavioral.interpreter;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 15:54
 */
public class OrExpression implements Expression {

  private Expression expression1;
  private Expression expression2;

  public OrExpression(Expression expression1, Expression expression2) {
    this.expression1 = expression1;
    this.expression2 = expression2;
  }

  @Override
  public boolean interpret(String context) {
    return expression1.interpret(context) || expression2.interpret(context);
  }
}
