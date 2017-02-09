package com.myproject.www.dao;

import java.io.Serializable;
import java.util.List;

import com.myproject.www.entity.BaseEntity;
import com.myproject.www.pageQuery.query.BaseQuery;

/**
 * 基础Dao
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IBaseDao<T extends BaseEntity,Q extends BaseQuery<T>,ID extends Serializable> {
	
	public Long add(T t) throws Exception;
	
	public Long delete(ID id) throws Exception;
	
	public Long update(T t) throws Exception;
	
	public T findById(ID id) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public List<T> findPage(Q q) throws Exception;
	
	public Long getCount(Q q) throws Exception;
	
	public Long getFilteredCount(Q q) throws Exception;

}
