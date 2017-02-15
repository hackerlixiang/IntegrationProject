package com.myproject.www.service;

import java.util.List;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.query.DataDictionaryItemQuery;

/**
 * 数据字典项Service
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IDataDictionaryItemService extends IBaseService<DataDictionaryItemEntity, DataDictionaryItemQuery, Long>{
	
	/**
	 * 保存数据字典项
	 * @param dataDictionaryItemBean 数据字典Bean对象项
	 * @return 消息
	 */
	public Message save(DataDictionaryItemBean dataDictionaryItemBean) throws Exception;

	/**
	 * 根据字典code获取字典项
	 * @param code 字典code
	 * @return 字典项集合
	 */
	public List<DataDictionaryItemEntity> findItemByDataDictionaryCode(String dataDictionaryCode) throws Exception;
	
	/**
	 * 根据code 获取名称
	 * @param code 字典项code
	 * @return 字典项名称
	 * @throws Exception
	 */
	public String getNameByCode(String code) throws Exception;
	
	/**
	 * 将数据字典项名称加入缓存
	 */
	public void itemNamesAddCache() throws Exception;
	
	/**
	 * 根据数据字典code将数据字典项名称加入缓存
	 * @param code 数据字典dictionaryCode
	 */
	public void itemNamesAddCacheByDictionaryCode(String dictionaryCode) throws Exception;
}
