package com.java.code.study.java.lang.type;

import sun.misc.Launcher;

import java.lang.reflect.Method;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-24 17:27
 */
public class ClassLoaderTest {

  public static void main(String[] args) {

    System.out.println("AppClassLoader加载类的路径：" + System.getProperty("java.class.path"));
    System.out.println("ExtClassLoader加载类的路径：" + System.getProperty("java.ext.dirs"));
    System.out.println("BootstrapClassLoader加载类的路径：" + System.getProperty("sun.boot.class.path"));

    ClassLoader cl = ClassLoaderTest.class.getClassLoader();
    System.out.println("ClassLoader is:"+cl.toString());
    System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
//    System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());

    try {
      Class<?> cls = Launcher.getLauncher().getClassLoader()
          .loadClass("com.java.code.study.java.lang.type.Student");
      System.out.println("class类加载：" + cls.getName());
      System.out.println("类实例对象：" + cls.newInstance());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // 创建自定义classloader对象
    DiskClassLoader classLoader = new DiskClassLoader("F:\\test");

    try {
      Class cls = classLoader.loadClass("cn.com.workapp.auto.tsleasing.timewheel.Test");
      if (cls != null) {
        Object object = cls.newInstance();
        Method method = cls.getDeclaredMethod("study", String.class);

        method.invoke(object, "history");
      }

    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // jdbc
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Class.forName("cn.com.workapp.auto.tsleasing.timewheel.Test",
          true, new DiskClassLoader("F:\\test"));
      // Class.forName vs ClassLoader.loadClass
      Class<?> x = Class.forName("[I");
      System.out.println(" Class.forName:" + x);

      x = ClassLoader.getSystemClassLoader().loadClass("[I");
      System.out.println("ClassLoadger.loadClass:" + x);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getContextClassLoader().getClass().getName());
  }

}
