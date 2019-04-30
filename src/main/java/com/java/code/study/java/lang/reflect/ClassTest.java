package com.java.code.study.java.lang.reflect;

import com.java.code.study.java.lang.type.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-23 11:26
 */
public class ClassTest {

  public static void main(String[] args) {

    try {
      // 第一种获取Class方式 Class.forName()
      Class<Student> cls = (Class<Student>) Class.forName("com.java.code.study.java.lang.type.Student");
      System.out.println(cls.getName() + "\n" + cls.getSimpleName() +
          "\n" + cls.getTypeName() + "\n" + cls.getCanonicalName());

      // 第二中获取Class方式 getClass()方式
      Student student = new Student();
      cls = (Class<Student>) student.getClass();

      // 第三种获取Class方式 class
      cls = Student.class;

      System.out.println(cls.toString());

      Field[] fields = cls.getDeclaredFields();
      if (fields != null && fields.length > 0) {
        for (Field field : fields) System.out.println(field.getName() + "," + field.getType());
      }

      Method[] methods = cls.getDeclaredMethods();
      if (methods != null && methods.length > 0) {
        for (Method method : methods) System.out.println(method.getName() +
            "," + method.getReturnType() + "," + method.getParameterTypes() +
            "," + method.getTypeParameters());
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}
