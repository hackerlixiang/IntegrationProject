package com.myproject.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.www.bean.DataDictionaryBean;
import com.myproject.www.dao.IDataDictionaryDao;
import com.myproject.www.entity.DataDictionaryEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.query.DataDictionaryQuery;
import com.myproject.www.service.IDataDictionaryService;
import com.myproject.www.utils.BeanUtils;

/**
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月10日 下午2:27:36
 */
@Service("dataDictionaryServiceImpl")
public class DataDictionaryServiceImpl extends BaseServiceImpl<DataDictionaryEntity, DataDictionaryQuery, Long> implements IDataDictionaryService {
	
	@Autowired
	private IDataDictionaryDao dataDictionaryDao;

	@Override
	public Message save(DataDictionaryBean dataDictionaryBean) throws Exception {
		DataDictionaryEntity dataDictionary = new DataDictionaryEntity();
		BeanUtils.copyProperties(dataDictionaryBean, dataDictionary);
		Long affectedConut = dataDictionaryDao.add(dataDictionary);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.DATA_DICTIONARY_ADD_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.DATA_DICTIONARY_ADD_FAILURE);
		}
	}
}
