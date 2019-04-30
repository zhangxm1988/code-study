package com.java.code.study.java.lang.reflect;

import com.java.code.study.java.lang.type.Student;
import com.sun.org.apache.xml.internal.security.Init;

import java.lang.reflect.*;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-29 18:59
 */
public class GenericsTest {

  public static void main(String[] args) {

    try {
      Class<?> cls = Student.class;
      Method method = cls.getMethod("getStringList", null);
      method.invoke(cls.newInstance(), null);

      Type returnType = method.getGenericReturnType();

      if (returnType instanceof ParameterizedType) {
        ParameterizedType paramType = (ParameterizedType) returnType;

        Type[] types = paramType.getActualTypeArguments();
        Class typeClass = null;
        for (Type type : types) {
          typeClass = (Class) type;
          System.out.println(typeClass);
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    //Array study
    int[] intArray = (int[]) Array.newInstance(int.class, 3);
    Array.set(intArray, 0, 123);
    Array.set(intArray, 1, 456);
    Array.set(intArray, 2, 789);
    System.out.println("intArray[0]:" + Array.get(intArray, 0));
    System.out.println("intArray[1]:" + Array.get(intArray, 1));
    System.out.println("intArray[2]:" + Array.get(intArray, 2));

    Class stringArrayClass = String[].class;
    System.out.println("array class:" + stringArrayClass.getName());
    try {
      Class intArrayClass = Class.forName("[I");
      System.out.println("array class:" + intArrayClass.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String[] strings = new String[3];
    stringArrayClass = strings.getClass();
    System.out.println(stringArrayClass.getName());
    Class stringArrayComponentType = stringArrayClass.getComponentType();
    System.out.println(stringArrayComponentType);

  }

}
