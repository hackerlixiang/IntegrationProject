package com.myproject.www.test2;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class Json2Map {
	
	@Test
	public void testJson2Map() throws Exception {
		
	}
	
	public static void main(String[] args) {
		String json = "{\"name\": \"测试菜单70\",\"nameFilter\": \"eq\",\"pname\": \"123123\",\"pnameFilter\": \"eq\"}";
		Map<String,Object> m = JsonUtils.toObject(json , Map.class);
		for (Entry<String, Object> en : m.entrySet()) {
			System.out.println(en.getKey()+"="+en.getValue());
		}
	}
}
