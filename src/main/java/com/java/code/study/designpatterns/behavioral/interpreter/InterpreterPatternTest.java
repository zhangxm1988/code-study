package com.java.code.study.designpatterns.behavioral.interpreter;

/**
 * @author zhangxm
 * @description 解释器模式
 *
 * @create 2019-07-03 15:08
 */
public class InterpreterPatternTest {

  // 规则：Robert 和 John 是男性
  public static Expression getMaleExpression() {
    Expression robert = new TerminalExpression("Robert");
    Expression john = new TerminalExpression("John");

    return new OrExpression(robert, john);
  }

  // 规则：Julie 是一个已婚的女性
  public static Expression getMarriedWomanExpression() {
    Expression julie = new TerminalExpression("Julie");
    Expression married = new TerminalExpression("Married");
    return new AndExpression(julie, married);
  }


  public static void main(String[] args) {
    // 解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式，它属于行为型模式
    // 这种模式实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL 解析、符号处理引擎等。

    // 意图：给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。
    // 主要解决：对于一些固定文法构建一个解释句子的解释器。
    // 何时使用：如果一种特定类型的问题发生的频率足够高，那么可能就值得将该问题的各个实例表述为一个简单语言中的句子。
    // 这样就可以构建一个解释器，该解释器通过解释这些句子来解决该问题。

    // 如何解决：构建语法树，定义终结符与非终结符。
    // 关键代码：构建环境类，包含解释器之外的一些全局信息，一般是 HashMap。
    // 应用实例：编译器、运算表达式计算。
    Expression isMale = getMaleExpression();
    Expression isMarriedWoman = getMarriedWomanExpression();

    System.out.println("John is male? " + isMale.interpret("Married"));
    System.out.println("Julie is a married women? "
        + isMarriedWoman.interpret("Married Julie"));

  }

}
