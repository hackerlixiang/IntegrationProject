package com.myproject.www.utils;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import com.myproject.www.service.IDataDictionaryItemService;

/**
 * Utils - 字典工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public final class DictionaryUtils{
	
	private DictionaryUtils(){
		
	}
	
	public static String getNameByCode(String code){
		if(StringUtils.isBlank(code)){
			return "-";
		}
		IDataDictionaryItemService dataDictionaryItemServiceImpl = (IDataDictionaryItemService)SpringUtils.getBean("dataDictionaryItemServiceImpl");
		try {
			return dataDictionaryItemServiceImpl.getNameByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-";
	}
	
}