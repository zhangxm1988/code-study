package com.java.code.study.java.lang.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-23 10:39
 */
@Getter @Setter
@ToString
public class Teacher implements Cloneable, Serializable {

  private String name;
  private int age;

  private Student student;

  protected Object clone() {
    Teacher object = null;
    try {
      object = (Teacher) super.clone();
      object.student = (Student) student.clone();
    } catch (CloneNotSupportedException ex) {
      ex.printStackTrace();
    }

    return object;
  }

  public Object deepClone() throws IOException, ClassNotFoundException {
    // 将对象写到流中
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    ObjectOutputStream oo = new ObjectOutputStream(bo);
    oo.writeObject(this);

    // 从流中读出来
    ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
    ObjectInputStream oi = new ObjectInputStream(bi);

    return oi.readObject();
  }

}
