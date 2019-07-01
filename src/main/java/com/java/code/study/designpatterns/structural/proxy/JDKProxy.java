package com.java.code.study.designpatterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 17:44
 */
public class JDKProxy implements InvocationHandler {

  private Image image;

  public Object createProxy(Image image) {
    this.image = image;
    ClassLoader classLoader = JDKProxy.class.getClassLoader();
    Class[] clazz = image.getClass().getInterfaces();

    return Proxy.newProxyInstance(classLoader, clazz, this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("JDKProxy前置增强");
    Object object = method.invoke(image, args);
    System.out.println("JDKProxy后置增强");

    return object;
  }
}
