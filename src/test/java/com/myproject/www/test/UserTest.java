package com.myproject.www.test;

import javax.annotation.Resource;
//import javax.validation.Validator;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.bean.UserBean;
import com.myproject.www.others.Message;
import com.myproject.www.service.IUserService;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.validate.ValidateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class UserTest {
	
	@Resource(name="userServiceImpl")
	private IUserService userService;
	
	@Test
	public void addTest() throws Exception {
		UserBean userBean = new UserBean();
		userBean.setUsername("lx02788");
		userBean.setPassword("0276871LX");
		userBean.setName("阿萨德");
		userBean.setNickName("~A屌屌屌A~");
		userBean.setIdCard("510124199107034911");
		userBean.setEmail("565180713@qq.com");
		userBean.setMobile("15982554545");
		userBean.setHomeAddress("啊实打实的-aA-ddd");
		userBean.setRegistIp("192.168.151.22");
		userService.perBeforeHandleUser(userBean, null);
		if(ValidateUtils.valid(userBean)){
			Message msg = userService.save(userBean);
			System.out.println(msg.getContent());
		}else{
			System.out.println("用户添加失败");
		}
	}
	
//	public static void main(String[] args) {
//		String idCard = "510124199107034911";
//		System.out.println(IdCardUtils.validateCard(idCard));
//		System.out.println(IdCardUtils.getAgeByIdCard(idCard));
//		System.out.println(IdCardUtils.getBirthByIdCard(idCard));
//		System.out.println(IdCardUtils.getProvinceByIdCard(idCard));
//		System.out.println(IdCardUtils.getGenderByIdCard(idCard));
//		System.out.println(IdCardUtils.getDateByIdCard(idCard));
//		System.out.println(IdCardUtils.getMonthByIdCard(idCard));
//		System.out.println(IdCardUtils.getYearByIdCard(idCard));
//		
//		System.out.println(DigestUtils.md5Hex("abcd"));
//	}
	
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}
