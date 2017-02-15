package com.myproject.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.bean.DataDictionaryItemBean;
import com.myproject.www.cache.CacheHandler;
import com.myproject.www.dao.IDataDictionaryItemDao;
import com.myproject.www.entity.DataDictionaryItemEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.query.DataDictionaryItemQuery;
import com.myproject.www.service.IDataDictionaryItemService;
import com.myproject.www.utils.BeanUtils;

/**
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月10日 下午2:27:32
 */
@Service("dataDictionaryItemServiceImpl")
public class DataDictionaryItemServiceImpl extends BaseServiceImpl<DataDictionaryItemEntity, DataDictionaryItemQuery, Long> implements IDataDictionaryItemService {
	
	@Autowired
	private IDataDictionaryItemDao dataDictionaryItemDao;
	
	@Autowired
	private CacheHandler cacheHandler;

	@Override
	@Transactional
	public Message save(DataDictionaryItemBean dataDictionaryItemBean) throws Exception {
		DataDictionaryItemEntity dataDictionaryItem = new DataDictionaryItemEntity();
		BeanUtils.copyPropertiesIgnoreNull(dataDictionaryItemBean, dataDictionaryItem);
		Long affectedConut = dataDictionaryItemDao.add(dataDictionaryItem);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.DATA_DICTIONARY_ADD_SUCCESS);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.DATA_DICTIONARY_ADD_FAILURE);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<DataDictionaryItemEntity> findItemByDataDictionaryCode(String dictionaryCode) throws Exception {
		return dataDictionaryItemDao.findItemByDataDictionaryCode(dictionaryCode);
	}

	@Override
	@Transactional(readOnly=true)
	public String getNameByCode(String code) throws Exception {
		return dataDictionaryItemDao.getNameByCode(code);
	}
	
	@Override
	public void itemNamesAddCache() throws Exception {
		List<DataDictionaryItemEntity> items = findAll();
		for (DataDictionaryItemEntity item : items) {
			itemNameAddCache(item.getCode(), item.getName());
		}
	}

	@Override
	public void itemNamesAddCacheByDictionaryCode(String dictionaryCode) throws Exception {
		List<DataDictionaryItemEntity> items = findItemByDataDictionaryCode(dictionaryCode);
		for (DataDictionaryItemEntity item : items) {
			itemNameAddCache(item.getCode(), item.getName());
		}
	}
	
	private void itemNameAddCache(String code,String name){
		cacheHandler.addElementForCache("initParams",code,name);
	}
}
