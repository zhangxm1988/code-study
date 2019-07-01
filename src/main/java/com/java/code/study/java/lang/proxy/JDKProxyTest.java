package com.java.code.study.java.lang.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.*;

/**
 * @author zhangxm
 * @description jdk动态代理
 * @create 2019-04-30 09:53
 */
public class JDKProxyTest {

  public interface IHello {
    void sayHello();
  }

  public static class Hello implements IHello {
    public void sayHello() {
      System.out.println("jdk hello world");
    }
  }

  public static class HwInvocationHandler implements InvocationHandler {

    private Object target;// 目标对象

    public HwInvocationHandler(Object target) {
      this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

      System.out.println("插入前置通知代码===================");
      // 执行目标对象方法
      Object object = method.invoke(target, args);
      System.out.println("插入后置通知代码===================");

      return object;
    }
  }

  public static void main(String[] args) {

    //JDK动态代理
    //生成$Proxy0的class文件
    //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    Class proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(), new Class[]{IHello.class});
    System.out.println("proxy class:" + proxyClass.getName());

    IHello iHello = null;
    try {
      Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
      iHello = (IHello) constructor.newInstance(new HwInvocationHandler(new Hello()));
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    iHello.sayHello();

    // newProxyInstance方式
    IHello iHello1 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),
        new Class[]{IHello.class}, new HwInvocationHandler(new Hello()));
    iHello1.sayHello();

  }
}
