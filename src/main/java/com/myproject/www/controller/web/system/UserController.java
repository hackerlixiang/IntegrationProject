package com.myproject.www.controller.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.bean.UserBean;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.entity.UserEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.pageQuery.query.UserQuery;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.service.IDataDictionaryService;
import com.myproject.www.service.IUserService;

@Controller
@RequestMapping("/system/user")
@Scope("prototype")
public class UserController extends BaseSystemController{
	
	@Resource(name="userServiceImpl")
	private IUserService userService;
	
	@Resource(name="dataDictionaryServiceImpl")
	private IDataDictionaryService dataDictionaryService;
	
	@Resource(name="dataDictionaryItemServiceImpl")
	private IDataDictionaryItemService dataDictionaryItemService;
	
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
		
		// 获取性别字典项
		List<DataDictionaryItemEntity> dataDictionaryItems = dataDictionaryItemService.findItemByDataDictionaryCode("SEX");
		modelAndView.addObject("dataDictionaryItems", dataDictionaryItems);
		
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
		return userService.save(userBean);
	}
	
	
	/**
	 * 验证用户名是否重复
	 * @param username 需要验证的用户名
	 * @param id 需要验证的用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_username",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatUsername(String username,Long id) throws Exception{
		return userService.validateRepeatUsername(username,id);
	}
	
	/**
	 * 验证用户身份证是否重复
	 * @param idCard 需要验证的用户身份证
	 * @param id 需要验证的用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_idcard",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatIdCard(String idCard,Long id) throws Exception{
		return userService.validateRepeatIdCard(idCard,id);
	}
	
	/**
	 * 验证用户邮箱是否重复
	 * @param email 需要验证的用户邮箱
	 * @param id 需要验证的用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_email",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatEmail(String email,Long id) throws Exception{
		return userService.validateRepeatEmail(email,id);
	}
	
	/**
	 * 验证用户手机号是否重复
	 * @param mobile 需要验证的用户手机号
	 * @param id 需要验证的用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_mobile",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatMobile(String mobile,Long id) throws Exception{
		return userService.validateRepeatMobile(mobile,id);
	}
	
}
