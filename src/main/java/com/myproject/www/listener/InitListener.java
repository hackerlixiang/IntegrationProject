package com.myproject.www.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myproject.www.cache.CacheHandler;
import com.myproject.www.service.IMenuService;

import net.sf.ehcache.Element;

@Component("initListener")
public class InitListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CacheHandler cacheHandler;
	
	@Resource(name="menuServiceImpl")
	private IMenuService menuServiceImpl;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Element element = cacheHandler.getElement("initParams", "menus");
		if(element==null){
			try {
				menuServiceImpl.findMenusAndAddCache();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println(cacheHandler.getDiskStorePath());
//		System.out.println(cacheHandler.getCacheSize());
	}

}
