package com.myproject.www.controller.web.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.others.Message;
import com.myproject.www.service.IAdminService;

/**
 * 登录Controller
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Controller
@RequestMapping("/system/login")
@Scope("prototype")
public class LoginController extends BaseSystemController{
	
	@Resource(name="adminServiceImpl")
	private IAdminService adminService;
	
	/**
	 * 跳转至登录页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
	
	/**
	 * 管理员登录
	 * @param request
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录结果
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public Message login(HttpServletRequest request,String username,String password) throws Exception{
		return null;
	}
	
}
