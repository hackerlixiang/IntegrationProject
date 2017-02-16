package com.myproject.www.test;

import javax.annotation.Resource;
//import javax.validation.Validator;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.bean.AdminBean;
import com.myproject.www.others.Message;
import com.myproject.www.service.IAdminService;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.encryption.Base64Utils;
import com.myproject.www.utils.validate.ValidateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class AdminTest {
	
	@Resource(name="adminServiceImpl")
	private IAdminService adminServiceImpl;
	
	@Test
	public void addTest() throws Exception {
		for (int i = 20; i < 50; i++) {
			AdminBean userBean = new AdminBean();
			userBean.setUsername("lx02788"+i);
			userBean.setPassword(Base64Utils.encode("027681LX".getBytes()));
			userBean.setName("阿萨德");
			userBean.setNickName("~A屌屌屌A~");
			userBean.setIdCard("5101241991070349"+i);
			userBean.setEmail("56518071"+i+"@qq.com");
			userBean.setMobile("159825545"+i);
			userBean.setRegistIp("192.168.151.22");
			adminServiceImpl.perBeforeHandleAdmin(userBean, null);
			if(ValidateUtils.valid(userBean)){
				Message msg = adminServiceImpl.save(userBean);
				System.out.println(msg.getContent());
			}else{
				System.out.println("用户添加失败");
			}
		}
	}
	
	@Test
	public void validateUser() throws Exception {
		System.out.println(adminServiceImpl.validateRepeatUsername("lx027881", null));
		System.out.println(adminServiceImpl.validateRepeatUsername("lx02788", null));
		System.out.println(adminServiceImpl.validateRepeatEmail("565180713@qq.com", null));
		System.out.println(adminServiceImpl.validateRepeatMobile("15982554545", null));
		System.out.println(adminServiceImpl.validateRepeatIdCard("510124199107034911", null));
	}
	
	public static void main(String[] args) {
		String idCard = "510124199107034911";
		System.out.println(IdCardUtils.validateCard(idCard));
		System.out.println(IdCardUtils.getAgeByIdCard(idCard));
		System.out.println(IdCardUtils.getBirthByIdCard(idCard));
		System.out.println(IdCardUtils.getProvinceByIdCard(idCard));
		System.out.println(IdCardUtils.getGenderByIdCard(idCard));
		System.out.println(IdCardUtils.getDateByIdCard(idCard));
		System.out.println(IdCardUtils.getMonthByIdCard(idCard));
		System.out.println(IdCardUtils.getYearByIdCard(idCard));
		
		System.out.println(DigestUtils.md5Hex("abcd"));
	}
	
}
