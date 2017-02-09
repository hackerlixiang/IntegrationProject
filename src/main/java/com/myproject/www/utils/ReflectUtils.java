package com.myproject.www.utils;

import java.lang.reflect.Field;

/**
 * 反射工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class ReflectUtils {
	
	private ReflectUtils(){
		
	}
	
	public static Field[] getSuperClassFileds(Class<?> clazz){
		Class<?> superClass = clazz.getSuperclass();
		return superClass.getDeclaredFields();
	}
	
	public static void getFieldNameAndValue(Class<?> clazz,Object obj) throws IllegalArgumentException, IllegalAccessException{
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName()+"="+field.get(obj));
			field.setAccessible(false);
		}
	}
}
