package com.java.code.study.designpatterns.structural.composite;

/**
 * @author zhangxm
 * @description 组合模式
 *
 * @create 2019-07-02 10:18
 */
public class CompositePatternTest {

  public static void main(String[] args) {
    // 组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。
    // 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。

    // 意图：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
    // 主要解决：它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，
    // 客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
    // 何时使用： 1、您想表示对象的部分-整体层次结构（树形结构）。
    // 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
    //如何解决：树枝和叶子实现统一接口，树枝内部组合该接口。
    //关键代码：树枝内部组合该接口，并且含有内部属性 List，里面放 Component。

    Component component1 = new Leaf("test1");
    Component component2 = new Leaf("test2");
    Component component3 = new Leaf("test3");

    Composite composite1 = new Composite("folder1");
    composite1.add(component1);
    composite1.add(component2);
    composite1.add(component3);

    Component component4 = new Leaf("test4");
    Component component5 = new Leaf("test5");
    Component component6 = new Leaf("test6");

    Composite composite2 = new Composite("folder2");
    composite2.add(component4);
    composite2.add(component5);
    composite2.add(component6);

    Composite folderRoot = new Composite("folderRoot");
    folderRoot.add(composite1);
    folderRoot.add(composite2);

    folderRoot.callMe();

  }

}
