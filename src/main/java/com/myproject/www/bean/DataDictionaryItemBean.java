package com.myproject.www.bean;

import com.myproject.www.utils.validate.annon.Validate;

public class DataDictionaryItemBean extends BaseBean {

	/** code */
	@Validate
	private String code;
	
	/** 字典名称 */
	@Validate
	private String name;
	
	/** 数据字典项对应数据字典ID */
	@Validate
	private Long dataDictionaryId;

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

	public Long getDataDictionaryId() {
		return dataDictionaryId;
	}

	public void setDataDictionaryId(Long dataDictionaryId) {
		this.dataDictionaryId = dataDictionaryId;
	}
	
}
