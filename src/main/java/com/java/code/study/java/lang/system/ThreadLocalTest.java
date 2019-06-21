package com.java.code.study.java.lang.system;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangxm
 * @description ThreadLocal study
 * @create 2019-06-21 10:40
 */
@SpringBootTest
public class ThreadLocalTest {

  // ThreadLocal该类提供了线程局部变量。这个局部变量与一般的成员变量不一样，ThreadLocal的变量在被多个线程使用时候，每个线程只能拿到该变量的一个副本
  // ThreadLocal的作用是提供线程内的局部变量，这种变量在线程的生命周期内起作用
  // 作用：提供一个线程内公共变量（比如本次请求的用户信息），减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度，
  // 或者为线程提供一个私有的变量副本，这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。

  // Thread类中有一个成员变量属于ThreadLocalMap类(一个定义在ThreadLocal类中的内部类)，它是一个Map，他的key是ThreadLocal实例对象。
  // 当为ThreadLocal类的对象set值时，首先获得当前线程的ThreadLocalMap类属性，然后以ThreadLocal类的对象为key，设定value。get值时则类似。
  // ThreadLocal变量的活动范围为某线程，是该线程“专有的，独自霸占”的，对该变量的所有操作均由该线程完成！
  // 也就是说，ThreadLocal 不是用来解决共享对象的多线程访问的竞争问题的，因为ThreadLocal.set() 到线程中的对象是该线程自己使用的对象，其他线程是不需要访问的，也访问不到的。当线程终止后，这些值会作为垃圾回收。
  // 由ThreadLocal的工作原理决定了：每个线程独自拥有一个变量，并非是共享的

  @Test
  public void threadLocalTest() {

    MyThreadLocal myThreadLocal = new MyThreadLocal();
    Thread thread1 = new MyThread(myThreadLocal);
    Thread thread2 = new MyThread(myThreadLocal);
    Thread thread3 = new MyThread(myThreadLocal);
    Thread thread4 = new MyThread(myThreadLocal);

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    // 个人认为使用ThreadLocal的场景最好满足两个条件，一是该对象不需要在多线程之间共享；二是该对象需要在线程内被传递
    // ThreadLocal使用场景举例
    // 第一个例子：数据库连接
    // 第二个例子：动态设置数据源

  }

}
