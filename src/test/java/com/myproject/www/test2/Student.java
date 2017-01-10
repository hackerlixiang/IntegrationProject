package com.myproject.www.test2;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.myproject.www.annon.FieldColumn;
import com.myproject.www.entity.MenuEntity;

public class Student{
//	public static void main(String[] args) throws Exception {
//		Class<MenuEntity> clazz = MenuEntity.class;
//		Class<? super MenuEntity> c = clazz.getSuperclass();
//		Field[] fields = clazz.getDeclaredFields();
//		for (Field field : fields) {
//			if(field.getAnnotation(FieldColumn.class)!=null){
//				System.out.println(field.getAnnotation(FieldColumn.class).column());
//			}
//			System.out.println(field.getName());
//		}
//	}
	
//	public static void main(String[] args) throws Exception {
//		MenuEntity m = new MenuEntity();
//		m.setName("asdasd");
//		Class<?> clazz = m.getClass();
//		Field[] fileds = clazz.getDeclaredFields();
//		for (Field field : fileds) {
//			if(!"serialVersionUID".equals(field.getName())){
//				field.setAccessible(true);
//				System.out.println(field.getName()+"="+field.get(m));
//			}
//		}
//	}
	
	public static void main(String[] args) {
		Map<String,String> m = new HashMap<String,String>();
		m.put("sss", "aaaa");
		if(m.containsKey("sss")){
			String v = m.get("sss");
			m.remove("sss");
			m.put("aaa", v);
		}
		for (Entry<String, String> en : m.entrySet()) {
			System.out.println(en.getKey()+"="+en.getValue());
		}
	}
}


