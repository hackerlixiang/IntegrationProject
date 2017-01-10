package com.myproject.www.controller.web.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.www.service.IMenuService;

@Controller
@RequestMapping("/test")
@Scope("prototype")
public class TestController extends BaseSystemController{
	@Resource(name="menuServiceImpl")
	private IMenuService menuService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		System.out.println("--------------");
		System.out.println(1/0);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------");
		return "test";
	}
	
}
