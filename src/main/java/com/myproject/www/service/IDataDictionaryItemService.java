package com.myproject.www.service;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.DataDictionaryItemQuery;

/**
 * 数据字典项 Service
 * @author lixiang
 *
 */
public interface IDataDictionaryItemService extends IBaseService<DataDictionaryItemEntity, DataDictionaryItemQuery, Long>{
	
	/**
	 * 保存数据字典项
	 * @param dataDictionaryItemBean 数据字典Bean对象项
	 * @return 消息
	 */
	public Message save(DataDictionaryItemBean dataDictionaryItemBean) throws Exception;
}
