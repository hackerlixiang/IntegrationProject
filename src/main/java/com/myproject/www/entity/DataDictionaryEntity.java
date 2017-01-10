package com.myproject.www.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 数据字典实体
 * @author lixiang
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
