package com.myproject.www.test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.utils.SpringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class SpringUtilTest {
	
	@Test
	public void infoTest() throws Exception {
		System.out.println(SpringUtils.getMessage("MSG.su"));
	}
}
