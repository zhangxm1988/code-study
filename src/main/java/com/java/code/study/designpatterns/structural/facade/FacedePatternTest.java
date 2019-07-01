package com.java.code.study.designpatterns.structural.facade;


import org.apache.catalina.connector.RequestFacade;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * @author zhangxm
 * @description 外观模式
 *
 * @create 2019-07-01 18:18
 */
public class FacedePatternTest {

  public static void main(String[] args) {
    // 外观模式（Facade Pattern）隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
    // 外观模式：JdbcUtils.closeConnection();
    JdbcUtils.closeConnection(null);

    // 外观模式：RequestFacade
    RequestFacade requestFacade;
    // 医院的例子  医院  病人  接待员 （挂号、门诊、划价、化验、收费、取药等）

    Computer computer = new Computer();
    computer.start();

    computer.shutdown();
  }

}
