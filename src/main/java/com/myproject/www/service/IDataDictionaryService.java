package com.myproject.www.service;

import com.myproject.www.bean.DataDictionaryBean;
import com.myproject.www.entity.DataDictionaryEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.query.DataDictionaryQuery;

/**
 * 数据字典Service
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IDataDictionaryService extends IBaseService<DataDictionaryEntity, DataDictionaryQuery, Long>{
	
	/**
	 * 保存数据字典
	 * @param dataDictionaryBean 数据字典Bean对象
	 * @return 消息
	 */
	public Message save(DataDictionaryBean dataDictionaryBean) throws Exception;

}
