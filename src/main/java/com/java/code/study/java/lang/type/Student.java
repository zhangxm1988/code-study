package com.java.code.study.java.lang.type;

import com.java.code.study.java.lang.annotation.ClassLogger;
import com.java.code.study.java.lang.annotation.FieldLogger;
import com.java.code.study.java.lang.annotation.MethodLogger;
import com.java.code.study.java.lang.annotation.ParamLogger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-22 19:08
 */
@Getter @Setter
@ToString
@ClassLogger(name = "LEVEL", value = "1")
public class Student implements Cloneable, Serializable {

  @FieldLogger(name="LEVEL", value = "3")
  private String name;
  private int ages;

  protected List<String> stringList;

  public List<String> getStringList(){
    System.out.println("get string list");
    return this.stringList;
  }

  protected Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException ex) {
      ex.printStackTrace();
      return null;
    }
  }

  @MethodLogger(name = "LEVEL", value = "2")
  private void study(@ParamLogger(name="LEVEL", value = "4") String item, long time) {
    System.out.println("student task is study " + item + ", study " + item + " " + time + " hours");
  }

}
