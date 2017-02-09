package com.myproject.www.dao;

import java.util.List;

import com.myproject.www.entity.MenuEntity;
import com.myproject.www.pageQuery.query.MenuQuery;

/**
 * 菜单Dao
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IMenuDao extends IBaseDao<MenuEntity, MenuQuery, Long>{
	
	public List<MenuEntity> findChildByParentId(Long parentId) throws Exception;
	
	public List<MenuEntity> findMenus() throws Exception;
	
	public List<MenuEntity> findRoot() throws Exception;

	public MenuEntity findMenuByName(String name) throws Exception;

	public MenuEntity findMenuByPath(String path) throws Exception;
	
}
