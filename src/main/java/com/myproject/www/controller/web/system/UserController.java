package com.myproject.www.controller.web.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.bean.UserBean;
import com.myproject.www.entity.UserEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.pageQuery.UserQuery;
import com.myproject.www.service.IUserService;

@Controller
@RequestMapping("/system/user")
@Scope("prototype")
public class UserController extends BaseSystemController{
	@Autowired
	private IUserService userService;
	
	/**
	 * 跳转至用户列表页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
	
	/**
	 * 获取用户列表数据
	 * @param request
	 * @param query 查询参数
	 * @return 列表数据
	 */
	@RequestMapping(value="/getData",method = RequestMethod.POST)
	@ResponseBody
	public Pagination<UserEntity> getData(HttpServletRequest request,UserQuery query) throws Exception{
		Pagination<UserEntity> pagination = userService.findPage(query);
		return pagination;
	}
	
	/**
	 * 跳转至用户添加页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
	
	/**
	 * 添加用户
	 * @param menuBean 用户Bean
	 * @return 添加结果消息
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Message add(UserBean userBean,HttpServletRequest request) throws Exception{
		
		userService.perBeforeHandleUser(userBean, request);
		
		//用户Bean验证
		if(!valid(userBean)){
			return Message.getMessage(MessageTypeEnum.warning,MessageAlias.USER_PARAM_ERROR);
		}
		
		//添加用户
//		return userService.save(userBean);
		return Message.addMessage(MessageTypeEnum.success, "添加成功");
	}
}
