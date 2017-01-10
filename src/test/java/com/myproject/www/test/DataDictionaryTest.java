package com.myproject.www.test;

import javax.annotation.Resource;
//import javax.validation.Validator;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.bean.DataDictionaryBean;
import com.myproject.www.bean.UserBean;
import com.myproject.www.service.IDataDictionaryService;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.validate.ValidateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class DataDictionaryTest {
	
	@Resource(name="dataDictionaryServiceImpl")
	private IDataDictionaryService dataDictionaryService;
	
	@Test
	public void addTest() throws Exception {
		DataDictionaryBean dataDictionaryBean = new DataDictionaryBean();
		dataDictionaryBean.setCode("111");
		dataDictionaryBean.setName("性别");
		System.out.println(ValidateUtils.valid(dataDictionaryBean));
		dataDictionaryService.save(dataDictionaryBean);
	}
	
}
