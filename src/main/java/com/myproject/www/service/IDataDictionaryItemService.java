package com.myproject.www.service;

import java.util.List;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.query.DataDictionaryItemQuery;

/**
 * 数据字典项Service
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
	 * @param dictionaryCode 字典CODE
	 * @return 字典项集合
	 */
	public List<DataDictionaryItemEntity> findItemByDataDictionaryCode(String dictionaryCode) throws Exception;
}
