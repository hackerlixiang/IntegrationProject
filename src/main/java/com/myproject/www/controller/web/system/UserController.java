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
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.StringUtils;
import com.myproject.www.utils.WebUtils;

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
		// 补充bean属性
		userBean.setRegistIp(WebUtils.getRemoteIp(request));//获取用户注册IP地址
		
		if(userBean.getAge()==null&&StringUtils.isNotBlank(userBean.getIdCard())){// 如果用户未填写年龄并且身份证不为空，则从身份证上获取
			userBean.setAge(IdCardUtils.getAgeByIdCard(userBean.getIdCard()));
		}
		
		//用户Bean验证
		if(!valid(userBean)){
			return Message.getMessage(MessageTypeEnum.warning,MessageAlias.USER_ADD);
		}
		//添加用户
		return userService.save(userBean);
	}
}
