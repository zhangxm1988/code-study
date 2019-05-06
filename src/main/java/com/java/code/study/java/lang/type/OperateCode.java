package com.java.code.study.java.lang.type;

/**
 * @author zhangxm
 * @description 操作码枚举
 *
 * @create 2019-04-30 19:36
 */
public enum OperateCode {

  USE_REGISTER(100, "用户注册");

  private int code;
  private String desc;

  OperateCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int code() {
    return code;
  }

}
