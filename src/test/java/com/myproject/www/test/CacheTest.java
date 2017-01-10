package com.myproject.www.test;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.cache.CacheHandler;

import net.sf.ehcache.Element;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class CacheTest {
	@Resource(name="CacheHandler")
	CacheHandler cacheHandler;
	
	@Test
	public void addCache() throws Exception {
		cacheHandler.addElementForCache("setting", "ce", "111111111111111");
		Element ele = cacheHandler.getElement("setting", "ce");
		System.out.println(ele.getObjectKey()+"="+ele.getObjectValue());
		cacheHandler.addElementForCache("setting", "ce", "222222");
		Element ele1 = cacheHandler.getElement("setting", "ce");
//		cacheHandler.flushAllCache();
		System.out.println(ele1.getObjectKey()+"="+ele1.getObjectValue());
	}
	
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> sets = properties.entrySet();
		for (Entry<Object, Object> entry : sets) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
