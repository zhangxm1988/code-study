package com.java.code.study.java.lang.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-30 15:10
 */
public class CGLIBProxyTest {

  static class Hello {
    public void sayHello() {
      System.out.println("cglib hello world");
    }
  }

  static class CgLibProxy implements MethodInterceptor {
    // 目标对象
    private Object target;

    public Object getInstance(Object target) {
      this.target = target;
      // 代理类class文件存入本地磁盘方便我们反编译查看源码
      System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");

      // 创建加强器，用来创建动态代理类
      Enhancer enhancer = new Enhancer();
      // 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
      enhancer.setSuperclass(target.getClass());
      // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
      enhancer.setCallback(this);

      // 创建动态代理类对象并返回
      return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

      System.out.println("插入前置通知代码===================");

      // 调用业务类（父类中）的方法
      methodProxy.invokeSuper(o, objects);

      System.out.println("插入后置通知代码===================");
      return null;
    }

  }

  public static void main(String[] args) {

    Hello hello = new Hello();
    CgLibProxy proxy = new CgLibProxy();

    Hello hello1 = (Hello) proxy.getInstance(hello);
    hello1.sayHello();
  }

}
