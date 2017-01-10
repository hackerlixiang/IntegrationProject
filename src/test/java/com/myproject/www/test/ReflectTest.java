package com.myproject.www.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import com.myproject.www.dao.IMenuDao;
import com.myproject.www.pageQuery.BaseQuery;
import com.myproject.www.pageQuery.MenuQuery;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		test3();
	}
	
	public static void test1() throws Exception {
		MenuQuery m = new MenuQuery();
		m.setFilter("{\"name\":\"aaa\",\"nameFilter\":\"eq\",\"pname\":\"bb\"}");
		Map<String, Object> q = m.getQuerys();
		for (Entry<String, Object> en : q.entrySet()) {
			System.out.println(en.getKey()+":"+en.getValue());
		}
	}
	
	public static void test2() throws Exception {
		BaseQuery query = new BaseQuery();
		Class<? extends BaseQuery> qClass = query.getClass();
		Field[] fields = qClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	
	public static void test3() throws Exception {
		Class<IMenuDao> clazz = IMenuDao.class;
		Method method = clazz.getDeclaredMethod("add");
		Class<?>[] types = method.getParameterTypes();
		for (Class<?> type : types) {
			System.out.println(type.getName());
		}
	}
	
	public String a(String s){
		return s;
	}
}
