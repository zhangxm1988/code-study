package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description study threadLocal
 * @create 2019-06-21 16:08
 */
public class MyThreadLocal {

  // 定义了一个ThreadLocal变量，用来保存int或Integer数据
  private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){

    @Override
    protected Integer initialValue() {
      return 0;
    }

  };

  // 将threadLocal的值获取后加1，并更新设置threadLocal的值
  public Integer getNextNum() {
    threadLocal.set(threadLocal.get() + 1);
    return threadLocal.get();
  }

  public void remove() {
    threadLocal.remove();
  }
}
