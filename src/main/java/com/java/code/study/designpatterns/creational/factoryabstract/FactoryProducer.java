package com.java.code.study.designpatterns.creational.factoryabstract;

import com.java.code.study.designpatterns.creational.factorymethod.ShapeFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 18:04
 */
public class FactoryProducer {

  public static AbstractFactory getFactory(String type) {

    if (StringUtils.isBlank(type)) {
      return null;
    }

    if (type.equalsIgnoreCase("SHAPE")) {
      return new ShapeFactory();
    } else if (type.equalsIgnoreCase("COLOR")) {
      return new ColorFactory();
    }

    return null;
  }
}
