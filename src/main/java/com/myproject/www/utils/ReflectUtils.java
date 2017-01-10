package com.myproject.www.utils;

import java.lang.reflect.Field;

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
