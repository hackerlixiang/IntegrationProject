package com.myproject.www.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典Entity
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class DataDictionaryEntity extends BaseEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5767580034853442L;

	/** code */
	private String code;
	
	/** 字典名称 */
	private String name;
	
	/** 字典下包含的字典项 */
	private List<DataDictionaryItemEntity> dataDictionaryItems = new ArrayList<DataDictionaryItemEntity>();
	
	public DataDictionaryEntity() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DataDictionaryItemEntity> getDataDictionaryItems() {
		return dataDictionaryItems;
	}

	public void setDataDictionaryItems(List<DataDictionaryItemEntity> dataDictionaryItems) {
		this.dataDictionaryItems = dataDictionaryItems;
	}
	
}
