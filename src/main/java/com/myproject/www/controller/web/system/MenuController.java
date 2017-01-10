package com.myproject.www.controller.web.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.www.bean.MenuBean;
import com.myproject.www.entity.MenuEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.MenuQuery;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.service.IMenuService;

@Controller
@RequestMapping("/system/menu")
@Scope("prototype")
public class MenuController extends BaseSystemController{
	
	public static final String redirectUrl = "redirect:/system/menu/list";
	
	@Autowired
	private IMenuService menuService;
	
	/**
	 * 跳转至菜单列表页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
	
	/**
	 * 获取菜单列表数据
	 * @param request
	 * @param query 查询参数
	 * @return 列表数据
	 */
	@RequestMapping(value="/getData",method = RequestMethod.POST)
	@ResponseBody
	public Pagination<MenuEntity> getData(HttpServletRequest request,MenuQuery query) throws Exception{
		Pagination<MenuEntity> pagination = null;
		pagination = menuService.findPage(query);
		return pagination;
	}
	
	/**
	 * 跳转至菜单添加页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		// 获取所有根菜单
		List<MenuEntity> roots = menuService.findRoot();
		modelAndView.addObject("roots", roots);
		
		return modelAndView;
	}
	
	/**
	 * 添加菜单
	 * @param menuBean 菜单Bean
	 * @return 添加结果消息
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Message add(MenuBean menuBean) throws Exception{
		//菜单Bean验证
		if(!valid(menuBean)){
			return Message.getMessage(MessageTypeEnum.warning,MessageAlias.MENU_PARAM_ERROR);
		}
		//验证菜单名是否重复
		if(!menuService.validateRepeatName(menuBean.getName(),null)){
			return Message.getMessage(MessageTypeEnum.warning, MessageAlias.MENU_NAME_REPEAT);
		}
		//验证菜单路劲是否重复
		if(!menuService.validateRepeatPath(menuBean.getPath(),null)){
			return Message.getMessage(MessageTypeEnum.warning, MessageAlias.MENU_PATH_REPEAT);
		}
		//添加菜单
		return menuService.save(menuBean);
	}
	
	/**
	 * 跳转至菜单修改页面
	 * @param request
	 * @return 视图模型对象
	 */
	@RequestMapping(value="/update/{id}",method = RequestMethod.GET)
	public ModelAndView update(@PathVariable Long id,HttpServletRequest request,RedirectAttributes attributes) throws Exception{
		
		MenuEntity pMenu =  menuService.findById(id);
		if(pMenu == null){
			attributes.addAttribute("o", "ss");
			return getModelAndView(redirectUrl);
		}else{
			ModelAndView modelAndView = getModelAndView(request);
			modelAndView.addObject("menu", pMenu);
			// 获取所有根菜单
			List<MenuEntity> roots = menuService.findRoot();
			
			modelAndView.addObject("roots", roots);
			
			return modelAndView;
		}
		
	}
	
	/**
	 * 修改菜单
	 * @param menuBean 菜单bean
	 * @return 修改结果消息
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Message update(MenuBean menuBean) throws Exception{
		//菜单Bean验证
		if(!valid(menuBean)||menuBean.getId()==null){
			return Message.getMessage(MessageTypeEnum.warning,MessageAlias.MENU_PARAM_ERROR);
		}
		//验证菜单名是否重复
		if(!menuService.validateRepeatName(menuBean.getName(),menuBean.getId())){
			return Message.getMessage(MessageTypeEnum.warning, MessageAlias.MENU_NAME_REPEAT);
		}
		//验证菜单路劲是否重复
		if(!menuService.validateRepeatPath(menuBean.getPath(),menuBean.getId())){
			return Message.getMessage(MessageTypeEnum.warning, MessageAlias.MENU_PATH_REPEAT);
		}
		//修改菜单
		return menuService.modify(menuBean);
	}
	
	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return 删除结果消息
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Message delete(@PathVariable Long id) throws Exception{
		//菜单id验证
		if(id==null){
			return Message.getMessage(MessageTypeEnum.warning,MessageAlias.MENU_PARAM_ERROR);
		}
		//删除菜单
		return menuService.remove(id);
	}
	
	/**
	 * 获取菜单详情
	 * @return
	 */
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id,HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		MenuEntity pMenu = menuService.findById(id);
		modelAndView.addObject("menu", pMenu);
		return modelAndView;
	}
	
	/**
	 * 验证菜单名是否重复
	 * @param name 菜单名称
	 * @param id 菜单id
	 * @return 是否重复
	 */
	@RequestMapping(value="/validateRepeatName",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatName(String name,Long id) throws Exception{
		return menuService.validateRepeatName(name,id);
	}
	
	/**
	 * 验证菜单url地址是否重复
	 * @param path 菜单地址
	 * @param id 菜单id
	 * @return 是否重复
	 */
	@RequestMapping(value="/validateRepeatPath",method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateRepeatPath(String path,Long id) throws Exception{
		return menuService.validateRepeatPath(path,id);
	}
	
}
