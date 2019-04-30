package com.java.code.study.java.lang.annotation;

import com.java.code.study.java.lang.type.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-29 15:37
 */
public class AnnotationsTest {

  public static void main(String[] args) {
    Class<?> cls = Student.class;

    Annotation[] annotations = cls.getAnnotations();
    //annotations = cls.getDeclaredAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println("class annotation:" + annotation.toString());
    }
    // 指定类的注解
    Annotation annotation = cls.getAnnotation(ClassLogger.class);
    System.out.println("class annotation:" + annotation.toString());
    if (annotation instanceof ClassLogger) {
      ClassLogger logger = (ClassLogger) annotation;
      System.out.println("class logger " + logger.name() + " " + logger.value());
    }

    // method annotation
    Method method = null;
    try {
      method = cls.getDeclaredMethod("study", String.class, long.class);

      Annotation[] annotations1 = method.getAnnotations();
      annotations1 = method.getDeclaredAnnotations();
      MethodLogger logger = null;
      for (Annotation annotation1 : annotations1) {
        System.out.println("method annotation:" + annotation1.toString());
        if (annotation1 instanceof MethodLogger) {
          logger = (MethodLogger) annotation1;
          System.out.println("method logger " + logger.name() + " " + logger.value());
        }
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    // field annotation
    try {
      Field field = cls.getDeclaredField("name");
      Annotation[] annotations2 = field.getAnnotations();
      annotations2 = field.getDeclaredAnnotations();
      FieldLogger logger = null;
      for (Annotation annotation2 : annotations2) {
        System.out.println("field annotation:" + annotation2.toString());
        if (annotation2 instanceof FieldLogger) {
          logger = (FieldLogger) annotation2;
          System.out.println("filed logger " + logger.name() + " " + logger.value());
        }
      }

      Annotation annotation2 = field.getAnnotation(FieldLogger.class);
      logger = (FieldLogger) annotation2;
      System.out.println("filed logger " + logger.name() + " " + logger.value());
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

    // param annotation
    Annotation[][] annotations3 = method.getParameterAnnotations();
    Class[] parameterTypes = method.getParameterTypes();

    int i = 0;
    Class parameterType = null;
    ParamLogger logger = null;
    for (Annotation[] annotation3 : annotations3) {
      parameterType = parameterTypes[i++];

      for (Annotation annotation4 : annotation3) {
        System.out.println("parameter type :" + parameterType.getName());
        if (annotation4 instanceof ParamLogger) {
          logger = (ParamLogger) annotation4;
          System.out.println("filed logger " + logger.name() + " " + logger.value());
        }
      }
    }

  }

}
