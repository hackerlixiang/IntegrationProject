package com.myproject.www.dao;

import java.util.List;

import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.pageQuery.query.DataDictionaryItemQuery;

/**
 * 数据字典项Dao
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IDataDictionaryItemDao extends IBaseDao<DataDictionaryItemEntity, DataDictionaryItemQuery, Long>{

	/**
	 * 根据字典code获取字典项
	 * @param dictionaryCode 字典CODE
	 * @return 字典项集合
	 */
	public List<DataDictionaryItemEntity> findItemByDataDictionaryCode(String dictionaryCode);
	
}
