package com.java.code.study.java.lang.type;

import java.io.*;

/**
 * @author zhangxm
 * @description 自定义类加载器
 *
 * @create 2019-04-26 17:45
 */
public class DiskClassLoader extends ClassLoader {

  private String libPath;// lib路径

  public DiskClassLoader(String path) {
    this.libPath = path;
  }

  protected Class<?> findClass(String name) throws ClassNotFoundException {

    String fileName = this.getFileName(name);
    File file = new File(libPath, fileName);

    FileInputStream fileInputStream = null;
    ByteArrayOutputStream byteArrayOutputStream = null;
    try {
      fileInputStream = new FileInputStream(file);
      byteArrayOutputStream = new ByteArrayOutputStream();
      int length = 0;
      while ((length = fileInputStream.read()) != -1) {
        byteArrayOutputStream.write(length);
      }
      byte[] dataArray = byteArrayOutputStream.toByteArray();

      return defineClass(name, dataArray, 0, dataArray.length);

    } catch (FileNotFoundException ffe) {
      ffe.printStackTrace();
    } catch (IOException ie) {
      ie.printStackTrace();
    } finally {
      try {
        if (fileInputStream != null) {
          fileInputStream.close();
        }
        if (byteArrayOutputStream != null) {
          byteArrayOutputStream.close();
        }
      } catch (IOException ie) {
        ie.printStackTrace();
      }
    }

    return super.findClass(name);
  }

  private String getFileName(String name) {
    int index = name.lastIndexOf(".");
    if (index == -1) {
      return name + ".class";
    } else {
      return name.substring(index + 1) + ".class";
    }
  }

}
