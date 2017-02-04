package com.myproject.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.bean.MenuBean;
import com.myproject.www.cache.CacheHandler;
import com.myproject.www.dao.IMenuDao;
import com.myproject.www.entity.MenuEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.query.MenuQuery;
import com.myproject.www.service.IMenuService;
import com.myproject.www.utils.BeanUtils;

@Service("menuServiceImpl")
public class MenuServiceImpl extends BaseServiceImpl<MenuEntity, MenuQuery, Long> implements IMenuService {
	
	@Autowired
	private IMenuDao menuDao;
	
	@Autowired
	private CacheHandler cacheHandler;
	
	@Override
	@Transactional
	public Message save(MenuBean menuBean) throws Exception {
		MenuEntity menu = new MenuEntity();
		BeanUtils.copyProperties(menuBean, menu);
		Long affectedConut = menuDao.add(menu);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.MENU_ADD_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.MENU_ADD_FAILURE);
		}
		
	}
	
	@Override
	@Transactional
	public Message remove(Long id) throws Exception {
		Long affectedConut = delete(id);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.MENU_DELETE_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.MENU_DELETE_FAILURE);
		}
	}

	@Override
	@Transactional
	public Message modify(MenuBean menuBean) throws Exception {
		MenuEntity pMenu = findById(menuBean.getId());
		BeanUtils.copyProperties(menuBean, pMenu);
		Long affectedConut = menuDao.update(pMenu);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.MENU_UPDATE_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.MENU_UPDATE_FAILURE);
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<MenuEntity> findMenus() throws Exception{
		return menuDao.findMenus();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<MenuEntity> findMenusAndAddCache() throws Exception{
		List<MenuEntity> menus = menuDao.findMenus();
		cacheHandler.addElementForCache("initParams", "menus", menus);
		return menus;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<MenuEntity> findRoot() throws Exception {
		return menuDao.findRoot();
	}

	@Override
	public Boolean validateRepeatName(String name,Long id) throws Exception {
		MenuEntity pMenu = menuDao.findMenuByName(name);
		if(pMenu==null){
			return true;
		}else if(pMenu.getId()!=null&&id==null){
			return false;
		}else if(pMenu.getId()!=null&&id!=null){
			return pMenu.getId()==id;
		}else{
			return false;
		}
	}

	@Override
	public Boolean validateRepeatPath(String path,Long id) throws Exception {
		MenuEntity pMenu = menuDao.findMenuByPath(path);
		if(pMenu==null){
			return true;
		}else if(pMenu.getId()!=null&&id==null){
			return false;
		}else if(pMenu.getId()!=null&&id!=null){
			return pMenu.getId()==id;
		}else{
			return false;
		}
	}

}
