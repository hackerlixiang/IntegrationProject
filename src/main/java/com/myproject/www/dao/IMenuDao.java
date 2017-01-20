package com.myproject.www.dao;

import java.util.List;

import com.myproject.www.entity.MenuEntity;
import com.myproject.www.pageQuery.query.MenuQuery;

public interface IMenuDao extends IBaseDao<MenuEntity, MenuQuery, Long>{
	
	public List<MenuEntity> findChildByParentId(Long parentId) throws Exception;
	
	public List<MenuEntity> findMenus() throws Exception;
	
	public List<MenuEntity> findRoot() throws Exception;

	public Long validateRepeatName(String name) throws Exception;

	public Long validateRepeatPath(String path) throws Exception;
	
}
