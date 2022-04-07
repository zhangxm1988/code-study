package com.java.code.study.spring.javaBeans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * javaBean
 *
 * @author xiaoming.zhang
 * @version 1.0
 * @date 2022/4/5 17:37
 */
public class BeanInfoDemo {


	public static void main(String[] args) throws IntrospectionException {

		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
		Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

			// propertyDescriptor 允许属性添加属性编辑器 propertyEditor
			// GUI text(String)  ->  PropertyType
			// name -> String
			// age -> Integer
			Class<?> propertyType = propertyDescriptor.getPropertyType();
			String propertyName = propertyDescriptor.getName();
			// 为age字段 / 属性  增加  propertyEditor
			if ("age".equals(propertyName)) {

				// String  ->  Integer
				propertyDescriptor.setPropertyEditorClass(StringToInterPropertyEditor.class);
			}

			System.out.println(propertyDescriptor.toString());
		});

	}

	static class StringToInterPropertyEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws java.lang.IllegalArgumentException {
			Integer value = Integer.valueOf(text);
			setValue(value);
		}

	}

}
