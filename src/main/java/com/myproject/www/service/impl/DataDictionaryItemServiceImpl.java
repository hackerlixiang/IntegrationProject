package com.myproject.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.dao.IDataDictionaryItemDao;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.DataDictionaryItemQuery;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.utils.BeanUtils;

@Service("dataDictionaryItemServiceImpl")
public class DataDictionaryItemServiceImpl extends BaseServiceImpl<DataDictionaryItemEntity, DataDictionaryItemQuery, Long> implements IDataDictionaryItemService {
	
	@Autowired
	private IDataDictionaryItemDao dataDictionaryItemDao;

	@Override
	public Message save(DataDictionaryItemBean dataDictionaryItemBean) throws Exception {
		DataDictionaryItemEntity dataDictionaryItem = new DataDictionaryItemEntity();
		BeanUtils.copyProperties(dataDictionaryItemBean, dataDictionaryItem);
		Long affectedConut = dataDictionaryItemDao.add(dataDictionaryItem);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.DATA_DICTIONARY_ADD_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.DATA_DICTIONARY_ADD_FAILURE);
		}
	}
	
}
