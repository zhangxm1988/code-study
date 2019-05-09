package com.java.code.study.java.lang.reflect;

import com.java.code.study.java.lang.type.Student;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-28 17:18
 */
public class ReflectClassTest {

  public static void main(String[] args) {
    // Class类
    Class<?> cls = Student.class;
    System.out.println("class name:" + cls.getName());
    System.out.println("class modifier:" + cls.getModifiers());
    System.out.println("class modifier is " + Modifier.isFinal(cls.getModifiers()));
    System.out.println("package name:" + cls.getPackage());

    System.out.println("super class:" + cls.getSuperclass());

    // implements intefaces
    Class<?>[] intefaces = cls.getInterfaces();
    if (intefaces != null && intefaces.length > 0) {
      for (Class<?> clss : intefaces) {
        System.out.println("implement interfaces:" + clss.getName());
      }
    }

    // class Constructors
    Constructor<?>[] constructors = cls.getConstructors();
    if (constructors != null && constructors.length > 0) {
      for (Constructor<?> constructor : constructors) {
        // 通过构造器生成对象
        System.out.println("constructor:" + constructor.getName() +
            "," + constructor.getParameterCount() +
            ",modifier:" + constructor.getModifiers());
        int length = constructor.getParameterTypes().length;
        for (int k = 0; k < length; k++) {
          System.out.println("parameterTypes:" + constructor.getParameterTypes()[k].getName() +
              ",parameters:" + constructor.getParameters()[k].getName() +
              ",parameters modifiers:" + constructor.getParameters()[k].getModifiers());
        }
      }
      try {
        System.out.println("constructors new Object:" + cls.getConstructor(String.class)
            .newInstance("new String Object"));
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }
    }

    Student student = new Student();
    student.setName("zhangxm");student.setAges(31);
    // class fields
    Field[] declaredFields = cls.getDeclaredFields();
    if (declaredFields != null && declaredFields.length > 0) {
      System.out.println("field 私有化的字段如下：");
      for (Field field : declaredFields) {
        System.out.println(field.getName() + "," + field.getType() + "," + field.getModifiers());
        field.setAccessible(true);
        try {
          System.out.println(field.get(student));
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    Field[] fields = cls.getFields();
    if (fields != null && fields.length > 0) {
      System.out.println("field 公有化的字段和父类的字段如下：");
      for (Field field : fields) {
        System.out.println(field.getName() + "," + field.getType() + "," + field.getModifiers());
      }
    }

    // Method
    Method[] methods = cls.getDeclaredMethods();
    //methods = cls.getMethods();
    if (methods != null && methods.length > 0) {
      for (Method method : methods) {
        System.out.println("=========================================");
        System.out.println("method name :" + method.getName() + "," + method.getParameterCount());
        System.out.println("getter method :" + isGetter(method) + ", setter method :" + isSetter(method));
        System.out.println("=========================================");
      }
    }

    // 获取到指定的方法
    try {
      Method method = cls.getDeclaredMethod("study", new Class[]{String.class, long.class});
      method = cls.getDeclaredMethod("study", new Class[]{String.class, long.class});

      Class[] paramTypes = method.getParameterTypes();

      Class returnType = method.getReturnType();
      System.out.println("method return type :" + returnType.getName());

      // static和非static区别
      //method.invoke(null, "history");

      method.setAccessible(true);
      method.invoke(cls.newInstance(), "math", 3);

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }

    // java.lang.reflect.Array类提供静态方法来动态创建和访问Java数组。
    String[] array = (String[]) Array.newInstance(String.class, 10);
    array = ArrayUtils.add(array, "aa");
    array = ArrayUtils.add(array, "bb");
    array = ArrayUtils.insert(0, array, "cc");

    System.out.println(Arrays.toString(array));
  }

  public static boolean isGetter(Method method) {
    if (!method.getName().startsWith("get")) return false;
    if (method.getParameterCount() != 0) return false;
    if (method.getParameterTypes().length != 0) return false;
    if (Void.class.equals(method.getReturnType())) return false;
    return true;
  }

  public static boolean isSetter(Method method) {
    if (!method.getName().startsWith("set")) return false;
    if (method.getParameterTypes().length != 1) return false;

    return true;
  }

}
