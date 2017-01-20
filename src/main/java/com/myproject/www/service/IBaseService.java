package com.myproject.www.service;

import java.io.Serializable;
import java.util.List;

import com.myproject.www.entity.BaseEntity;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.pageQuery.query.BaseQuery;
/**
 * BaseService
 * @author lixiang
 *
 */
public interface IBaseService<T extends BaseEntity,Q extends BaseQuery<T>,ID extends Serializable> {
	
	/**
	 * 添加
	 * @param 对象
	 * @return
	 */
	public Long add(T t) throws Exception;
	
	/**
	 * 删除
	 * @param id 需要删除菜单的ID
	 */
	public Long delete(ID id) throws Exception;
	
	/**
	 * 修改
	 * @param 对象
	 */
	public Long update(T t) throws Exception;
	
	/**
	 * 根据ID查找
	 * @param id 需要查找对象的ID
	 * @return 查询到的对象
	 */
	public T findById(ID id) throws Exception;
	
	/**
	 * 获取所有对象
	 * @return 对象集合
	 */
	public List<T> findAll() throws Exception;
	
	/**
	 * 分页
	 * @param query 查询对象
	 * @return 筛选后的菜单集合
	 */
	public Pagination<T> findPage(Q q) throws Exception;

}
