package com.myproject.www.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.dao.IBaseDao;
import com.myproject.www.entity.BaseEntity;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.pageQuery.query.BaseQuery;
import com.myproject.www.service.IBaseService;
import com.myproject.www.utils.BeanUtils;
import com.myproject.www.utils.JsonUtils;
import com.myproject.www.utils.validate.ValidateUtils;

/**
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月10日 下午2:27:26
 */
public class BaseServiceImpl<T extends BaseEntity,Q extends BaseQuery<T>,ID extends Serializable> implements IBaseService<T, Q, ID>{
	
	@Autowired
	private IBaseDao<T, Q, ID> baseDao;
	
	@Override
	@Transactional
	public Long add(T t) throws Exception{
		return baseDao.add(t);
	}

	@Override
	@Transactional
	public Long delete(ID id) throws Exception {
		return baseDao.delete(id);
	}

	@Override
	@Transactional
	public Long update(T t) throws Exception {
		return baseDao.update(t);
	}

	@Override
	@Transactional(readOnly=true)
	public T findById(ID id) throws Exception {
		return baseDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> findAll() throws Exception {
		return baseDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public Pagination<T> findPage(Q q) throws Exception {
		//查询对象不存在重新创建一个
		if(q==null){
			return null;
		}else{
			//获取拥有查询参数的查询对象
			Q queryFilters = (Q)JsonUtils.toObject(q.getFilter(), q.getClass());
			//将拥有查询参数的查询对象复制进查询对象中
			if(queryFilters!=null){
				BeanUtils.copyPropertiesIgnoreNull(queryFilters, q, q.getIgnoreProperties());
			}
		}
		//创建分页信息对象
		Pagination<T> pagination = new Pagination<T>(q);
		//根据查询参数进行当页查询获取参数列表
		List<T> datas = baseDao.findPage(q);
		//根据查询参数进行总数查询获取参数个数
		Long filteredCount = baseDao.getFilteredCount(q);
		//获取总记录数
		Long count = baseDao.getCount(q);
		//将结果封装进分页信息对象
		pagination.setData(datas);
		pagination.setRecordsFiltered(filteredCount);
		pagination.setRecordsTotal(count);
		
		//返回分页对象
		return pagination;
	}

	public boolean valid(Object object) throws Exception {
		try {
			return ValidateUtils.valid(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
