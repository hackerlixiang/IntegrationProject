package com.myproject.www.controller.web.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.cache.CacheHandler;
import com.myproject.www.entity.MenuEntity;
import com.myproject.www.service.IMenuService;
import com.myproject.www.utils.DictionaryUtils;

/**
 * 主页Controller
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Controller
@RequestMapping("/system/index")
@Scope("prototype")
public class IndexController extends BaseSystemController{
	@Autowired
	private CacheHandler cacheHandler;
	
	@Resource(name="menuServiceImpl")
	private IMenuService menuServiceImpl;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		//获取菜单列表
		List<MenuEntity> menus = new ArrayList<>();
		//从缓存中获取
		Element element = cacheHandler.getElement("initParams", "menus");
		if(element!=null){//如果缓冲中存在
			menus = (List<MenuEntity>) element.getObjectValue();
		}else{//缓冲中不存在
			menus = menuServiceImpl.findMenusAndAddCache();
		}
		modelAndView.addObject("menus", menus);
		
		return modelAndView;
	}
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = getModelAndView(request);
		return modelAndView;
	}
}
