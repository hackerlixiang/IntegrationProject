package com.myproject.www.test;

import javax.annotation.Resource;
//import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.utils.validate.ValidateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class DataDictionaryItemTest {
	
	@Resource(name="dataDictionaryItemServiceImpl")
	private IDataDictionaryItemService dataDictionaryItemService;
	
	@Test
	public void addTest() throws Exception {
		DataDictionaryItemBean dataDictionaryItemBean = new DataDictionaryItemBean();
		dataDictionaryItemBean.setCode("WOMAN");
		dataDictionaryItemBean.setName("女");
		dataDictionaryItemBean.setDataDictionaryId(1L);
		System.out.println(ValidateUtils.valid(dataDictionaryItemBean));
		dataDictionaryItemService.save(dataDictionaryItemBean);
	}
	
}
