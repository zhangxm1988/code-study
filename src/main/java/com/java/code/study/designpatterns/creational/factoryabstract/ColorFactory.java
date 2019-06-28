package com.java.code.study.designpatterns.creational.factoryabstract;

import com.java.code.study.designpatterns.creational.factorymethod.Shape;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxm
 * @description 颜色工厂
 * @create 2019-06-28 17:27
 */
public class ColorFactory extends AbstractFactory {

  @Override
  public Shape getShape(String shapeType) {
    return null;
  }

  public Color getColor(String colorType) {

    if (StringUtils.isBlank(colorType)) {
      return null;
    }

    if (colorType.equalsIgnoreCase("RED")) {
      return new Red();
    } else if (colorType.equalsIgnoreCase("GREEN")) {
      return new Green();
    } else if (colorType.equalsIgnoreCase("BLUE")) {
      return new Blue();
    }

    return null;
  }
}
