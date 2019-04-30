package com.java.code.study.java.lang.type;

import java.io.IOException;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-22 15:17
 */
public class ObjectCloneTest {

  public static void main(String[] args) {

    Student student = new Student();
    student.setName("苏大强");
    student.setAges(67);

    Student student1 = (Student) student.clone();
    student1.setName("苏小强");
    student1.setAges(68);
    System.out.println(student.toString());
    System.out.println("clone 浅层复制");

    Teacher teacher = new Teacher();
    teacher.setName("苏明成");
    teacher.setAge(36);
    teacher.setStudent(student);
    System.out.println(teacher.toString());

    Teacher teacher1 = (Teacher)teacher.clone();
    teacher1.getStudent().setName("苏明玉");
    teacher1.getStudent().setAges(32);
    System.out.println(teacher1.toString());
    System.out.println(student.toString());
    System.out.println("clone 深层复制");

    try {
      Teacher teacher2 = (Teacher) teacher.deepClone();
      teacher2.getStudent().setName("苏小成");
      teacher2.getStudent().setAges(24);
      System.out.println(teacher2.toString());
      System.out.println(student.toString());
      System.out.println("clone Serializable 深层复制");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Object object = new Object();
  }

}
