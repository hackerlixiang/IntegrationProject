package com.myproject.www.controller.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.bean.AdminBean;
import com.myproject.www.entity.AdminEntity;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.pageQuery.query.AdminQuery;
import com.myproject.www.service.IAdminService;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.service.IDataDictionaryService;

/**
 * 管理员Controller
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Controller
@RequestMapping("/system/admin")
@Scope("prototype")
public class AdminController extends BaseSystemController{
	
	@Resource(name="adminServiceImpl")
	private IAdminService adminService;
	
	@Resource(name="dataDictionaryServiceImpl")
	private IDataDictionaryService dataDictionaryService;
	
	@Resource(name="dataDictionaryItemServiceImpl")
	private IDataDictionaryItemService dataDictionaryItemService;
	
	/**
	 * 跳转至管理员列表页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
	
	/**
	 * 获取管理员列表数据
	 * @param request
	 * @param query 查询参数
	 * @return 列表数据
	 */
	@RequestMapping(value="/getData",method = RequestMethod.POST)
	@ResponseBody
	public Pagination<AdminEntity> getData(HttpServletRequest request,AdminQuery query) throws Exception{
		Pagination<AdminEntity> pagination = adminService.findPage(query);
		return pagination;
	}
	
	/**
	 * 跳转至管理员添加页面
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
	 * 添加管理员
	 * @param menuBean 管理员Bean
	 * @return 添加结果消息
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Message add(AdminBean adminBean,HttpServletRequest request) throws Exception{
		
		//处理表单参数
		adminService.perBeforeHandleAdmin(adminBean, request);
		
		//管理员Bean验证
		if(!valid(adminBean)){
			return Message.getWarningMessage(MessageAlias.ADMIN_PARAM_ERROR);
		}
		
		//添加管理员
		return adminService.save(adminBean);
		
	}
	
	/**
	 * 跳转至管理员修改页面
	 * @param request
	 * @param id 管理员ID
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/update/{id}",method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request,@PathVariable Long id) throws Exception{
		
		if(!adminService.adminIsExist(id)){
			return new ModelAndView(NOT_FOUND_DATA).addObject("message", "管理员不存在!");
		}
		
		ModelAndView modelAndView = getModelAndView(request);
		
		AdminEntity pAdmin = adminService.findById(id);
		modelAndView.addObject("admin", pAdmin);
		
		// 获取性别字典项
		List<DataDictionaryItemEntity> dataDictionaryItems = dataDictionaryItemService.findItemByDataDictionaryCode("SEX");
		modelAndView.addObject("dataDictionaryItems", dataDictionaryItems);
		
		return modelAndView;
	}
	
	/**
	 * 修改管理员
	 * @param menuBean 管理员Bean
	 * @return 添加结果消息
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Message update(AdminBean adminBean,HttpServletRequest request) throws Exception{
		if(!adminService.adminIsExist(adminBean.getId())){
			return Message.getFailureMessage(MessageAlias.ADMIN_NOT_FOUND);
		}
		
		//处理表单参数
		adminService.perBeforeHandleAdmin(adminBean, request);
		
		//管理员Bean验证
		if(!valid(adminBean)){
			return Message.getWarningMessage(MessageAlias.ADMIN_PARAM_ERROR);
		}
		
		//添加管理员
		return adminService.modify(adminBean);
		
	}
	
	/**
	 * 验证管理员名是否重复
	 * @param username 需要验证的管理员名
	 * @param id 需要验证的管理员ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_username",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatUsername(String username,Long id) throws Exception{
		return adminService.validateRepeatUsername(username,id);
	}
	
	/**
	 * 验证管理员身份证是否重复
	 * @param idCard 需要验证的管理员身份证
	 * @param id 需要验证的管理员ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_idcard",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatIdCard(String idCard,Long id) throws Exception{
		return adminService.validateRepeatIdCard(idCard,id);
	}
	
	/**
	 * 验证管理员邮箱是否重复
	 * @param email 需要验证的管理员邮箱
	 * @param id 需要验证的管理员ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_email",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatEmail(String email,Long id) throws Exception{
		return adminService.validateRepeatEmail(email,id);
	}
	
	/**
	 * 验证管理员手机号是否重复
	 * @param mobile 需要验证的管理员手机号
	 * @param id 需要验证的管理员ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validate_repeat_mobile",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatMobile(String mobile,Long id) throws Exception{
		return adminService.validateRepeatMobile(mobile,id);
	}
	
}
