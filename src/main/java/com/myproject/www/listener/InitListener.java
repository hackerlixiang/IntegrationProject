package com.myproject.www.listener;

import javax.annotation.Resource;

import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myproject.www.cache.CacheHandler;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.service.IMenuService;

/**
 * 初始化监听器
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Component("initListener")
public class InitListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CacheHandler cacheHandler;
	
	@Resource(name="menuServiceImpl")
	private IMenuService menuServiceImpl;
	
	@Resource(name="dataDictionaryItemServiceImpl")
	private IDataDictionaryItemService dataDictionaryItemServiceImpl;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 将菜单加入缓存
		menusAddCache();
		//将数据字典-性别 加入缓存
		sexAddCache();
		
//		System.out.println(cacheHandler.getDiskStorePath());
//		System.out.println(cacheHandler.getCacheSize());
	}
	
	// 将菜单加入缓存
	private void menusAddCache(){
		Element element = cacheHandler.getElement("initParams", "menus");
		if(element==null){
			try {
				menuServiceImpl.findMenusAndAddCache();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//将数据字典-性别 加入缓存
	private void sexAddCache(){
		try {
			dataDictionaryItemServiceImpl.itemNamesAddCacheByDictionaryCode("SEX");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
