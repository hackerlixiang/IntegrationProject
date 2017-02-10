package com.myproject.www.service;

import java.util.List;

import com.myproject.www.bean.MenuBean;
import com.myproject.www.entity.MenuEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.query.MenuQuery;

/**
 * 菜单Service
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IMenuService extends IBaseService<MenuEntity, MenuQuery, Long>{
	
	/**
	 * 保存菜单
	 * @param menu 菜单Bean对象
	 * @return 消息
	 */
	public Message save(MenuBean menuBean) throws Exception;
	
	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return 消息
	 */
	public Message remove(Long id) throws Exception;
	
	/**
	 * 修改菜单
	 * @param menu 菜单Bean对象
	 * @retuen 消息;
	 */
	public Message modify(MenuBean menuBean) throws Exception;
	
	/**
	 * 获取树形菜单
	 * @return 树形菜单
	 */
	public List<MenuEntity> findMenus() throws Exception;
	
	/**
	 * 获取树形菜单并存入缓存
	 * @return 树形菜单
	 */
	public List<MenuEntity> findMenusAndAddCache() throws Exception;

	/**
	 * 获取所有根菜单
	 * @return 菜单对象集合
	 */
	public List<MenuEntity> findRoot() throws Exception;

	/**
	 * 验证菜单名称是否重复
	 * @param name 需要验证的菜单名称
	 * @param id 需要验证的菜单ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatName(String name,Long id) throws Exception;

	/**
	 * 验证菜单路劲是否重复
	 * @param path 需要验证的菜单路劲
	 * @param id 需要验证的菜单ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatPath(String path,Long id) throws Exception;

}
